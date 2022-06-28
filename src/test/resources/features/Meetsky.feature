Feature: Login Functionality
  User Story: As a user, I should be able to login.

@METSK-333
Scenario: User can login with valid credentials
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters valid username
  And   user enters valid password
  And   user clicks Log In button
  Then  user should see the Files-Meetsky-QA title on the opened Files page

@METSK-337
  Scenario: User can not login with invalid username
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters invalid username
  And   user enters valid password
  And   user clicks Log In button
  Then  user should see the Wrong username or password warning

@METSK-339
  Scenario: User can not login with invalid password
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters valid username
  And   user enters invalid password
  And   user clicks Log In button
  Then  user should see the Wrong username or password warning

@METSK-341
  Scenario: User can not login with invalid password and username
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters invalid username
  And   user enters invalid password
  And   user clicks Log In button
  Then  user should see the Wrong username or password warning



@METSK-342
  Scenario: User should see "Please fill out this field" message if the username is empty.
    Given user goes to log in page
    When  user on Meetsky LogIn page
    And   user enters valid username
    And   user clicks Log In button
    Then  user should see the Please fill out this field message.





















