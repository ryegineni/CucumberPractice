package com.propertyfinder.bdd.step_def;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		                   "pretty",
		                   "json:target/cucumber-report.json", 
		                   "html:target/cucumber-report.html" },

							features="src/test/resources/features/Task2ScenarioC.feature")
public class RunCukesTest {
	
}
