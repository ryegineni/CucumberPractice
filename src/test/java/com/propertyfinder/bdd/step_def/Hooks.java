package com.propertyfinder.bdd.step_def;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends PageObjectInit {
	@Before
	public void before() {
		getDriver();
	}

	@After
	public void after() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver = null;
		}
	}
}
