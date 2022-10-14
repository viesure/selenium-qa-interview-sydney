Feature: the temperature can be changed with api call
  @API
  Scenario Outline:Temperature can be changed
    Given a working API
    When set the temperature to <fahrenheit>
    Then the temperature in fahrenheit should be <fahrenheit>
    And the temperature in celsius should be <celsius>
    And the description should contain "<adjective>"

    Examples:
    |fahrenheit|celsius|adjective|
    |        28|     -3| freezing|
    |        34|      1|     cold|
    |        59|     15|     mild|
    |        73|     22|     warm|
    |       104|     40|      hot|
