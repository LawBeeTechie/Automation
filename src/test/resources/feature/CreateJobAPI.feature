#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Test Phoneix Backend Application
  In order to Test Phoneix backend Application
  As a User
  I should be able to login into the application

  @tag1
  Scenario: Verify User can Create Job
    Create JOb using some Valid details
   Given Backend URL and Login endpoint 
    When a valid user creates job
    Then the response status code is 200
