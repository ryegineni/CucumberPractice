package com.propertyfinder.bdd.step_def;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchPageStepDefs extends PageObjectInit {

	@Then("I verify user redirect to search page$")
	public void i_verify_search_page() throws Throwable {
		search.sortByDropdown();
	}

	@When("I Select \"([^\"]*)\" from property type dropdown$")
	public void i_click_on_something_menu_link(String arg1) throws Throwable {
		search.clickPropertyTypeDropdown();
		home.selectDropdownOpt(arg1);
	}

	@When("I select \"([^\"]*)\" from sort by dropdown$")
	public void i_select_something_from_sortBy_dropdown(String arg1) throws Throwable {
		//search.sortByDropdown();
		search.clickSortByDropdown();
		home.selectDropdownOpt(arg1);
	}

	@Then("I should display search results header text$")
	public void i_should_display_search_result_header() throws Throwable {
		System.out.println(search.getSearchTitle());
	}

	@When("I open last item of the search result$")
	public void i_open_last_item_of_the_search_result() throws Throwable {
		search.clickSearchPagePropertyLink();
	}

	@Then("I verify it has two bedrooms $")
	public void i_verify_it_has_two_bedrooms() throws Throwable {
		Assert.assertEquals("2", search.getPropertyContent("Bedrooms"));
	}

	@Then("I should display property name and price of the search result$")
	public void i_should_display_property_name_and_price_of_the_search_result() throws Throwable {
		search.displayPropertyTitlePrice();
	}

}
