@regression
Feature: As a end user i Verify search result count display less than the count after applying Nationality filter
Background:I am on propertyfinder.qa home page
    When I launch " https://propertyfinder.ae/" 

Scenario:Verify search result count display less than the count after applying Nationality filter
		When I click on "FIND AGENT" menu link
		When I click on languages dropdown
		And I select "ARABIC,ENGLISH,HINDI" from language dropdown
		And I click on agent find button
		Then I print agents total count of agents
		When I click on Nationality dropdown
		And I click on "India" from Nationality dropdown
		Then I verify agents should be less than the previous
		