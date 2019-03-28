# frozen_string_literal: true

class RunnerJobsFinder
  attr_reader :runner, :params

  def initialize(runner, params = {})
    @runner = runner
    @params = params
  end

  def execute
    items = @runner.builds
    items = by_status(items)
    items
  end

  private

  # rubocop: disable CodeReuse/ActiveRecord
  def by_status(items)
    return items unless HasStatus::AVAILABLE_STATUSES.include?(params[:status])

    items.where(status: params[:status])
  end
  # rubocop: enable CodeReuse/ActiveRecord
end
