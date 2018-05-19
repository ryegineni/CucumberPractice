package com.propertyfinder.bdd.step_def;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.propertyfinder.bdd.config.Helper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgentDetailStepDefs extends PageObjectInit {

	@When("^I click on first agent$")
	public void i_click_on_first_agent() throws Throwable {
		search.clickAgent();
	}

	@Then("^I print agents information$")
	public void i_print_agents_information() throws Throwable {

		search.displayAgentInfo();
	}

	@Then("^I capture screenshot$")
	public void i_capture_screenshot() throws Throwable {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String currTime = dtf.format(now);
		String fileName = System.getProperty("user.dir") + "/src/test/resources/drivers/screen" + currTime + ".png";
		Helper.takeScreenShot(driver, fileName);
	}

	@When("^I switch language to Arabic$")
	public void i_switch_language_to_Arabic() throws Throwable {
		home.clickLanguageSwitch();
	}

}
