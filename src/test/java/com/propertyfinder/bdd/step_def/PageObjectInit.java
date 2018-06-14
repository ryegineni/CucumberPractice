package com.propertyfinder.bdd.step_def;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.propertyfinder.bdd.config.Helper;
import com.propertyfinder.bdd.pageObjects.HomePage;
import com.propertyfinder.bdd.pageObjects.SearchPage;
import com.propertyfinder.bdd.pageObjects.SportsDirectPage;


public class PageObjectInit {
	public static WebDriver driver = null;
	public DesiredCapabilities dc=null;

	protected static HomePage home = null;
	protected static SearchPage search = null;
	protected static SportsDirectPage sports=null;

	public WebDriver getDriver() {
		if (driver == null) {
			if (Helper.prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
				String path = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver",
						path + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Helper.prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();

			}
			else if (Helper.prop.getProperty("browser").equalsIgnoreCase("Mobile")) {
				dc.setCapability("BROWSER_NAME", "Chrome");
				  dc.setCapability("PLATFORM", "Android");
				  dc.setCapability("PLATFORM_VERSION", "6.0.1");
				  dc.setCapability("DEVICE_NAME", "emulator-5554");
				//  driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

			}
			
			driver.manage().window().maximize();
		}
		home = new HomePage(driver);
		search = new SearchPage(driver);
		sports=new SportsDirectPage(driver);
		return driver;

	}

}
