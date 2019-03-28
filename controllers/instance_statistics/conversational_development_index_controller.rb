# frozen_string_literal: true

class InstanceStatistics::ConversationalDevelopmentIndexController < InstanceStatistics::ApplicationController
  # rubocop: disable CodeReuse/ActiveRecord
  def index
    @metric = ConversationalDevelopmentIndex::Metric.order(:created_at).last&.present
  end
  # rubocop: enable CodeReuse/ActiveRecord
end
