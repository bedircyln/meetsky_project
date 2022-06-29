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
    Then  user should see the Please fill out this field message on password input box


@METSK-353
Scenario: User should see "Please fill out this field" message if the username is empty.
    Given user goes to log in page
    When  user on Meetsky LogIn page
    And   user enters valid password
    And   user clicks Log In button
    Then  user should see the Please fill out this field message on username input box


@METSK-354
Scenario: User should see "Please fill out this field" message if the username is empty.
    Given user goes to log in page
    When  user on Meetsky LogIn page
    And   user clicks Log In button
    Then  user should see the Please fill out this field message on username input box


@METSK-357
Scenario: User should see the password in form of dots by default
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters valid password
  Then  user should see the password as form of dots


  @METSK-359
  Scenario: User can see the password explicitly if needed
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user enters valid password
  And   user cliks the eye image to see the password explicitly
  Then  user should see the password explicitly


@METSK-361
Scenario: User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  Given user goes to log in page
  When  user on Meetsky LogIn page
  And   user can see the Forgot password? link
  And   user clicks the Forgot password link
  Then  user can see the Reset Password button


  Scenario:User can see valid placeholders on Username and Password fields
  Given user goes to log in page
  When  user on Meetsky LogIn page
  Then  user can see the Username and Password placeholders as expected






















