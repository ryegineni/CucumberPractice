package com.propertyfinder.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.propertyfinder.bdd.config.Helper;

public class HomePage  {
	public HomePage(WebDriver driver) {

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);

	}

	@FindBy(css = ".menu_link")
	private List<WebElement> menuLinks;

	@FindBy(css = ".autocomplete_input")
	private WebElement locationSearchField;

	@FindBy(css = ".autocomplete_suggestion")
	private WebElement locAutoSugg;

	@FindBy(css = ".dropdown.dropdown-height1.dropdown-widthhalf")
	private List<WebElement> minBedRoomDropdown;

	@FindBy(css = ".dropdown_popup.dropdown_popup-opened.false>div")
	private List<WebElement> dropdownOpts;

	@FindBy(css = ".button.button-fullheight.button-connectedright")
	private WebElement agentFindbtn;

	@FindBy(xpath = "//div[@class='searchproperty_submitbtn']")
	private WebElement findBtn;

	@FindBy(css = ".dropdown_text")
	private List<WebElement> agentSearchDropdown;
	
	@FindBy(css = ".dropdown_popup.dropdown_popup-opened.dropdown_popup-mulitple>div")
	private List<WebElement> langDropdownOpts;
	
	@FindBy(css = ".globalswitch_langlink.globalswitch_langlink-ar")
	private List<WebElement> langSwitch;
	
	public void clickMenuLink(String menuLink) {
		for (int i = 0; i < menuLinks.size(); i++) {
			WebElement menu = menuLinks.get(i);
			if (menu.getText().trim().equalsIgnoreCase(menuLink)) {
				menu.click();
				break;
			}
		}
	}

	public void enterLocation(String loc) {
		locationSearchField.sendKeys(loc);
	}

	public void clickLocSugg() {
		Helper.threadSleep(3);
		locAutoSugg.click();
	}

	public void clickMinBedRoomDropdown() {
		Helper.threadSleep(3);
		minBedRoomDropdown.get(2).click();
	}

	public void clickMaxBedRoomDropdown() {
		Helper.threadSleep(3);
		minBedRoomDropdown.get(3).click();
	}

	public void selectDropdownOpt(String option) {
		for (int i = 0; i < dropdownOpts.size(); i++) {
			WebElement dropdown = dropdownOpts.get(i);
			if (dropdown.getText().trim().equalsIgnoreCase(option)) {
				dropdown.click();
				break;
			}
		}
	}

	public void clickFindBtn() {
		findBtn.click();
	}

	public void clickLanguageDropdown() {
		agentSearchDropdown.get(1).click();
	}

	public void clickNationalityDropdown(){
		agentSearchDropdown.get(2).click();
	}
	public void clickAgentFindBtn() {
		agentFindbtn.click();
	}
	public void langDropdownOpt(String option) {
		for (int i = 0; i < langDropdownOpts.size(); i++) {

			WebElement dropdown = langDropdownOpts.get(i);
			if (dropdown.getText().trim().equalsIgnoreCase(option)) {
				dropdown.click();
				break;
			}
		}
	}
	public void scrollViewDropdownOpt(WebDriver driver,String option) {
		for (int i = 0; i < langDropdownOpts.size(); i++) {
			
			WebElement dropdown = langDropdownOpts.get(i);
			String prints=dropdown.getText().trim();
			System.out.println(prints);
			if (prints.equalsIgnoreCase(option)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(dropdown);
				actions.perform();
				dropdown.click();
				break;
			}
		}
	}
	public void clickLanguageSwitch(){
		langSwitch.get(0).click();
	}

}
