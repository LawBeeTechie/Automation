#Author: Ezenwaka Chikwado Lawrence
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Test Phoneix Backend Application
  In order to Test Phoneix backend Application 
  As a User
  I should be able to login into the application by using API.

  @tag1
  Scenario: Login API Scenario
    Given The user credentials
    |iamfd|password|
    |iamsup|password|
    |iamqc|password|
    When login api request is made
    Then the status code is 200
