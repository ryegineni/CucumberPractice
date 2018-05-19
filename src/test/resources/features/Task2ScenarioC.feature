@regression
Feature: As a end user i am able to display agent information
Background:I am on propertyfinder.qa home page
    When I launch " https://propertyfinder.ae/" 

Scenario:Validate agent information
		When I click on "FIND AGENT" menu link
		When I click on first agent
		Then I print agents information
		And I capture screenshot
		When I switch language to Arabic
		Then I capture screenshot
		
