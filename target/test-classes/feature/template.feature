#Author: your.email@your.domain.com
#Keywords Summary :

@e2e 	@sanitytest		@smoketest
Feature: Inwarranty flow of the application via backend
  As a user I want to verify if the Inwarranty flow for goggle devices

  Scenario: As a user of the application I should be able to create an In warranty job
    Given The customer and product information
    When the fd logins
    And creates the inwarranty job for the customer
    Then jobid is present in the response
    And jobid should be a number
    And job is in pending for assignment stage
    And HTTP status code should be 200
    
  Scenario: As a user of the application supervisor should be able to assign the job to engineer  
		When supvisor logs in
		And He should assign the job to the engineer
		Then the job status should change to pending for repair stage
		And HTTP status code should be 200
		
	Scenario: As a user of the application engineer should be able to mark the job complete with proper remark	
 		When Engineer logs in
 		And He marks the job complete with proper rmark
 		Then the job status should change to pending for QC stage
 		And HTTP status code should be 200