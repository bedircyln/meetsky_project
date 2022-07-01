Feature: LogOut Functionality
  User Story: As a user, I should be able to log out.

@METSK-373
  Scenario: User can log out and ends up in login page
    Given User Logs in the account with valid credentials
    When  User on Files page
    And   User clicks the icon on the upper right corner of the page
    And   User clicks the Log Out button on the opened menu under the clicked icon
    Then  User should go to Log In page

@METSK-374
    Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given User Logs in the account with valid credentials
    When  User on Files page
    And   User clicks the icon on the upper right corner of the page
    And   User clicks the Log Out button on the opened menu under the clicked icon
    And   User should go back to Log In page
    And   User clicks the step back button
    Then  User stays at Log In page

