Feature: Reset Password

  @ResetPassword
  Scenario Outline: Reset password
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country> and <currency>
    And the user has accessed the login form
    When the user attempts to reset the password
    And the user inserts a valid email <email> and clicks the reset button
    Then the user should see a popup message indicating that an email has been sent for resetting the password
    And the user accesses the Yopmail website
    And the user logs in with the email <email> used for password reset
    And the user retrieves the latest email
    And the user inserts a new password <newPassword> and confirms it
    And the user sees a popup confirming that the password has been successfully changed
    Examples:
      | country        | currency | email                        | newPassword |
      | United Kingdom | € EUR    | testauto19auto10@yopmail.com | testAuto1/  |

