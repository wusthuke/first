# frozen_string_literal: true

module SnippetsActions
  extend ActiveSupport::Concern

  def edit
  end

  # rubocop:disable Gitlab/ModuleWithInstanceVariables
  def raw
    disposition = params[:inline] == 'false' ? 'attachment' : 'inline'

    workhorse_set_content_type!

    send_data(
      convert_line_endings(@snippet.content),
      type: 'text/plain; charset=utf-8',
      disposition: disposition,
      filename: @snippet.sanitized_file_name
    )
  end
  # rubocop:enable Gitlab/ModuleWithInstanceVariables

  def js_request?
    request.format.js?
  end

  private

  def convert_line_endings(content)
    params[:line_ending] == 'raw' ? content : content.gsub(/\r\n/, "\n")
  end
end
