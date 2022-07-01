Feature: LogOut Functionality
  User Story: As a user, I should be able to log out.


  Scenario: User can log out and ends up in login page
    Given User Logs in the account with valid credentials
    When  User on Files page
    And   User clicks the icon on the upper right corner of the page
    And   User clicks the Log Out button on the opened menu under the clicked icon
    Then  User should go to Log In page

