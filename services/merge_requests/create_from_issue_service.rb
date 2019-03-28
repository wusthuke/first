# frozen_string_literal: true

module MergeRequests
  class CreateFromIssueService < MergeRequests::CreateService
    def initialize(project, user, params)
      # branch - the name of new branch
      # ref    - the source of new branch.

      @branch_name = params[:branch_name]
      @issue_iid   = params[:issue_iid]
      @ref         = params[:ref]

      super(project, user)
    end

    def execute
      return error('Invalid issue iid') unless @issue_iid.present? && issue.present?

      result = CreateBranchService.new(project, current_user).execute(branch_name, ref)
      return result if result[:status] == :error

      new_merge_request = create(merge_request)

      if new_merge_request.valid?
        SystemNoteService.new_merge_request(issue, project, current_user, new_merge_request)

        success(new_merge_request)
      else
        SystemNoteService.new_issue_branch(issue, project, current_user, branch_name)

        error(new_merge_request.errors)
      end
    end

    private

    # rubocop: disable CodeReuse/ActiveRecord
    def issue
      @issue ||= IssuesFinder.new(current_user, project_id: project.id).find_by(iid: @issue_iid)
    end
    # rubocop: enable CodeReuse/ActiveRecord

    def branch_name
      @branch ||= @branch_name || issue.to_branch_name
    end

    def ref
      return @ref if project.repository.branch_exists?(@ref)

      project.default_branch || 'master'
    end

    def merge_request
      MergeRequests::BuildService.new(project, current_user, merge_request_params).execute
    end

    def merge_request_params
      {
        issue_iid: @issue_iid,
        source_project_id: project.id,
        source_branch: branch_name,
        target_project_id: project.id,
        target_branch: ref
      }
    end

    def success(merge_request)
      super().merge(merge_request: merge_request)
    end
  end
end
