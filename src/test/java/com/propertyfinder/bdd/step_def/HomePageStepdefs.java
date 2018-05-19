package com.propertyfinder.bdd.step_def;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.propertyfinder.bdd.config.Helper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepdefs extends PageObjectInit {
	private int agentCountBeforeFilterApply = 0;
	private int agentCountAfterFilterApply = 0;

	@When("^I launch \"([^\"]*)\"$")
	public void i_launch_website(String arg1) throws Throwable {
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^I verify i am on home page$")
	public void i_verify_i_am_on_home_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "propertyfinder.qa - Qatar's #1 property site");
	}

	@When("I click on \"([^\"]*)\" menu link$")
	public void i_click_on_something_menu_link(String arg1) throws Throwable {
		home.clickMenuLink(arg1);
	}

	@When("I enter \"([^\"]*)\" in location field$")
	public void i_enter_something_in_location_field(String arg1) throws Throwable {
		home.enterLocation(arg1);
	}

	@When("I select first autosugg from the list$")
	public void i_select_first_autosugg_from_the_list() throws Throwable {
		home.clickLocSugg();
	}

	@When("I select \"([^\"]*)\" from the Min.bed dropdown$")
	public void i_select_something_from_dropdon(String arg1) throws Throwable {
		home.clickMinBedRoomDropdown();
		home.selectDropdownOpt(arg1);
	}

	@When("I select \"([^\"]*)\" from the Max.bed dropdown$")
	public void i_select_something_from_maxBed_dropdon(String arg1) throws Throwable {
		home.clickMaxBedRoomDropdown();
		home.selectDropdownOpt(arg1);
	}

	@When("I click on find button$")
	public void i_click_on_find_button() throws Throwable {
		home.clickFindBtn();
	}

	@When("I click on languages dropdown$")
	public void i_click_on_languages_dropdown() throws Throwable {
		home.clickLanguageDropdown();
	}

	@When("^I select \"([^\"]*)\" from language dropdown$")
	public void i_select_from_language_dropdown(String arg1) throws Throwable {
		String[] lang = arg1.split(",");
		for (int i = 0; i < lang.length; i++) {
			System.out.println("Language=" + lang[i]);
			home.langDropdownOpt(lang[i]);

		}
	}

	@When("^I click on agent find button$")
	public void i_click_on_agent_find_button() throws Throwable {
		home.clickAgentFindBtn();
		Helper.threadSleep(3);
	}

	@Then("^I print agents total count of agents$")
	public void i_print_agents_total_count_of_agents() throws Throwable {
		agentCountBeforeFilterApply = search.getAgentCount();
		System.out.println("Agents count in before search result page=" + agentCountBeforeFilterApply);
		Helper.threadSleep(3);
	}

	@When("^I click on Nationality dropdown$")
	public void i_click_on_Nationality_dropdown() throws Throwable {
		home.clickNationalityDropdown();
	}

	@When("^I click on \"([^\"]*)\" from Nationality dropdown$")
	public void i_click_on_India_from_dropdown(String arg1) throws Throwable {
		home.selectDropdownOpt(arg1);
		Helper.threadSleep(5);
	}

	@Then("^I verify agents should be less than the previous$")
	public void i_verify_agents_should_be_less_than_the_previous() throws Throwable {
		agentCountAfterFilterApply = search.getAgentCount();
		System.out.println("Agents count in search result page=" + agentCountAfterFilterApply+"  before results="+agentCountBeforeFilterApply);
		Assert.assertTrue(agentCountAfterFilterApply<agentCountBeforeFilterApply);
	}

}
