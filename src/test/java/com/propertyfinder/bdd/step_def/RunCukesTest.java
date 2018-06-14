package com.propertyfinder.bdd.step_def;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		                   "pretty",
		                   "json:target/cucumber-report.json", 
		                   "html:target/cucumber-report.html" },
							/*tags = {"@regression"},*/

							features="src/test/resources/features/task.feature")
public class RunCukesTest {
	
}
