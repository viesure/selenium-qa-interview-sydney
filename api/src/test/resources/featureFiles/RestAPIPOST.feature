Feature: Weather API returns current weather conditions

  Scenario Outline: Check that Weather API response contains required fields
    Given Get call to "weather" api
    Then Response contains the "<field>"

    Examples:
    | field           |
    |city             |
    |condition        |
    |icon             |
    |conditionID      |
    |description      |
    |weather          |
    |tempInFahrenheit |
    |tempInCelsius    |

  Scenario: Check Weather API response code and validate json schema
    Given Get call to "weather" api
    Then Response code is "200" OK
    And City is "vienna"
    And Response JSON has valid schema

  Scenario Outline: Check Condition value and icon Name for each ConditionID
    Given PUT call to "weather/condition" with weather "<conditionID>"
    When Get call to "weather" api
#    Then ConditionID is "<conditionID>" TODO uncomment when ConditionID field is present in the response
    And Condition is "<condition>"
    And Icon is "<icon>"

    Examples:
      | conditionID | condition|     icon     |
      |     1       | clear    | clear.png    |
      |     2       | windy    | windy.png    |
      |     3       | mist     | mist.png     |
      |     4       | drizzle  | drizzle.png  |
      |     5       | dust     | dust.png     |

  Scenario Outline: Check Weather Description corresponds to outside temperature
    Given PUT call to "weather/temp" with temperature in "<fahrenheit>"
    When Get call to "weather" api
    And Weather description ends with "<description>" for each temperature "<celsius>"

    Examples:
      | fahrenheit | celsius | description |
      |     30     |  -1     | freezing    |
      |     32     |   0     | freezing    |
      |     34     |   1     | cold        |
      |     49     |   9     | cold        |
      |     50     |  10     | cold        |
      |     52     |  11     | mild        |
      |     67     |  19     | mild        |
      |     68     |  20     | warm        |
      |     70     |  21     | warm        |
      |     76     |  24     | warm        |
      |     77     |  25     | hot         |
      |     79     |  25     | hot         |



  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius
  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius
  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius
  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius
  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius
  Scenario Outline: city, condition, icon, description conditionId tempInFahrenheit and tempInCelsius