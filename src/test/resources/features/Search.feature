Feature: Search

  @Search
  Scenario Outline: search category
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country> and <currency>
    And the user click on search button
    When  the user fill the search field by <category>
    Then the value searched should be the same as the value entered <category>
    Examples:
      | category        | country        | currency |
      | Royal Blend Tea | United Kingdom | € EUR    |