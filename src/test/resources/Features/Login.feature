@Regression @LoginFeature
Feature: Login

  Background:
    Given I open browser and navigate to "https://the-internet.herokuapp.com/login"
    And I am on the login page

  @Positive
  Scenario: Login with valid credentials
    When I enter "tomsmith" as username
    And I enter "SuperSecretPassword!" as password
    And I click on login button
    Then I should be logged in
    And I close the browser

  @Negative
  Scenario: Login with invalid credentials
    When I enter "tomandjerry" as username
    And I enter "SuperSecretPassword!" as password
    When I click on login button
    Then I should see error message about "username"
    And I close error message
    When I enter "tomsmith" as username
    And I enter "fedrick siagian" as password
    And I click on login button
    Then I should see error message about "password"
    And I close error message
    And I close the browser
