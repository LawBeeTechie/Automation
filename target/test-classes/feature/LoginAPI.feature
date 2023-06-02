#Author: Ezenwaka Chikwado L
#Keywords Summary : Login API Feature Test
Background: is necessary when there is same feature more than one scenario
@tag
Feature: Test Phoneix Backend Application
  In order to Test Phoneix backend Application 
  As a User
  I should be able to login into the application by using API.
  
  @tag1
  Scenario: Verify User Login with API.
  Login to phoenix application using some valid credentials with the help of login API.
    Given Backend URL and login endpoint
    When a valid user enters their credentials
    Then the response status code is 200

    
  