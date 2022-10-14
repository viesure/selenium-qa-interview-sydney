Feature: The UI should be working

  @UI
  Scenario:Search Input has correct text
      Given browser is open on openweather url
      When  the main page is visible
      Then search input should have correct text
  @UI
  Scenario:City weather data is displayed correctly
      Given browser is open on openweather url
      When the main page is visible
      And the user searches for sydney
      And the user selects Sydney, Au from the list
      Then the city name should be displayed correctly
      And the date should be visible correctly
