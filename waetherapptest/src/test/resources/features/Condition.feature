Feature: The condition id can be changed and it will change the png and the condition.
  @API
  Scenario Outline: Condition can be changed
  Given a working API
  When set the weather condition to <conditionId>
  Then the condition should be "<condition>"
  And the icon png should contain "<condition>"


Examples:
  |conditionId|condition|
  |    1      |clear    |
  |    2      |windy    |
  |    3      |mist     |
  |    4      |drizzle  |
  |    5      |dust     |