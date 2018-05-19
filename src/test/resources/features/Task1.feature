@regression
Feature: As a end user i am able to select location from autosuggesstionAs a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms
Background:I am on propertyfinder.qa home page
    When I launch "https://www.propertyfinder.qa/" 
    Then I verify i am on home page

Scenario:Verify that i am able to list of the least expensive apartment to rent in marina which has at least two bedrooms
		When I click on "RENT" menu link
		And I enter "marina" in location field
		And I select first autosugg from the list
		When I select "2 bedrooms" from the Min.bed dropdown
		And I click on find button
		Then I verify user redirect to search page
		When I Select "Apartment" from property type dropdown
		And I select "Price (low)" from sort by dropdown
		Then I should display search results header text
		When I open last item of the search result
		#Then I verify it has two bedrooms 