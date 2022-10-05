Feature: Landing Page

  Scenario: Verify the main page's search field contains correct placeholder text
    When landing page is open
    Then placeholder text contains "Weather in your city"

  Scenario Outline: Search for City and selects it
    When landing page is open
    And user searches for "<city>"
    And user selects "<cityListItem>" from the list
    Then The results for correct "<city>" are displayed, with date and time according to "<timezoneID>" timezone

    Examples:
    | city    | cityListItem | timezoneID       |
    | Sydney  | Sydney, AU   | Australia/Sydney |