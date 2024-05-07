Feature: Login

  @Account
  Scenario Outline: login with valid data
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country> and <currency>
    And the user has accessed the login form
    When the user attempts to login with valide <email> and <password>
    Then the user is successfully logged in
    And the user access to the Account page
    Examples:
      | country        | currency | email                        | password   |
      | United Kingdom | € EUR    | testauto19auto10@yopmail.com | testAuto1/ |