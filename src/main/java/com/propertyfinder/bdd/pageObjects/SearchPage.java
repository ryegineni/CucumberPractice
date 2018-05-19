package com.propertyfinder.bdd.pageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.propertyfinder.bdd.config.Helper;

public class SearchPage {
	public SearchPage(WebDriver driver) {

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);

	}

	@FindBy(css = ".dropdown.dropdown-bordered")
	private WebElement sortByDropdown;

	@FindBy(css = ".searchproperty_column.searchproperty_type>div")
	private WebElement propertyTypeDropdown;

	@FindBy(css = ".propertyheader_title")
	private WebElement propertySearchHeaderTitle;

	@FindBy(css = ".propertyheader_listcount.ge_resultsnumber")
	private WebElement searchResultCount;

	@FindBy(css = ".card_title.card_title-link")
	private List<WebElement> propertyLinkTitle;

	@FindBy(css = ".card_price")
	private List<WebElement> price;

	@FindBy(css = ".facts_label")
	private List<WebElement> propertyDetails;

	@FindBy(css = ".facts_content")
	private List<WebElement> propertyContent;

	@FindBy(css = ".title")
	private WebElement searchAgentResultText;

	@FindBy(css = ".tile_title")
	private WebElement agent;

	@FindBy(xpath = "//span[@class='table_column table_column-header' or @class='table_column table_column-widthstyle1 table_column-header']")
	private List<WebElement> agentInfoKey;

	@FindBy(xpath = "//span[@class='table_column table_column-header' or @class='table_column table_column-widthstyle1 table_column-header']/following::span[@class='table_column']")
	private List<WebElement> agentInfoValue;

	@FindBy(xpath = "//span[@class='table_column table_column-header' or @class='table_column table_column-widthstyle1 table_column-header']/following::span[@class='table_column']/a")
	private List<WebElement> agentInfoValueLink;

	@FindBy(css = ".button.pane_button")
	private WebElement agentPhoneNobtn;

	@FindBy(css = ".button_text.button_text-value.button_phone-ltr")
	private WebElement agentPhoneNo;

	@FindBy(css = ".text.text-size1")
	private WebElement agentCompany;

	@FindBy(css = ".tab_button.tab_button-first")
	private WebElement agentAboutMe;

	@FindBy(css = ".tab_content.tab_content-size1.tab_content-active")
	private WebElement agentAboutMeTxt;

	@FindBy(css = ".title.title-size1.bioinfo_name")
	private WebElement agentName1;

	public void clickSortByDropdown() {
		sortByDropdown.click();
		Helper.threadSleep(3);
	}

	public boolean sortByDropdown() {
		return sortByDropdown.isDisplayed();
	}

	public void clickPropertyTypeDropdown() {
		propertyTypeDropdown.click();
		Helper.threadSleep(3);
	}

	public String getSearchTitle() {
		return propertySearchHeaderTitle.getText().trim();
	}

	public String getSearchReusltCount() {
		return searchResultCount.getText().trim();
	}

	public void clickSearchPagePropertyLink() {
		for (int i = 0; i < propertyLinkTitle.size(); i++) {
			if (i == propertyLinkTitle.size()) {
				propertyLinkTitle.get(i).click();
				break;
			}
		}
	}

	public String getPropertyContent(String bedRoomSize) {
		String propContent = null;
		for (int i = 0; i < propertyDetails.size(); i++) {
			WebElement prop = propertyDetails.get(i);
			if (prop.getText().trim().equalsIgnoreCase(bedRoomSize)) {
				propContent = propertyContent.get(i).getText().trim();
				break;
			}
		}
		return propContent;
	}

	public void displayPropertyTitlePrice() {
		Properties prop = new Properties();
		for (int i = 0; i < propertyLinkTitle.size(); i++) {
			try {
				Helper.threadSleep(1);
				prop.setProperty(propertyLinkTitle.get(i).getText().trim(), price.get(i).getText().trim());
				File file = new File(System.getProperty("user.dir")
						+ "/src/main/java/com/propertyfinder/properties/propertyPriceList.txt");
				FileOutputStream fileOut = new FileOutputStream(file);
				prop.store(fileOut, "Properties price listing");
				fileOut.close();
				System.out.println(propertyLinkTitle.get(i).getText().trim() + "-" + price.get(i).getText().trim());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public int getAgentCount() {
		String reusltTxt = searchAgentResultText.getText().trim().replaceAll("[^0-9]", "");
		return Integer.parseInt(reusltTxt);
	}

	public void clickAgent() {
		agent.click();
	}

	public String getAgentPhoneNo() {
		agentPhoneNobtn.click();
		Helper.threadSleep(3);
		return agentPhoneNo.getText();
	}

	public String getAgentComp() {
		return agentCompany.getText();
	}

	public String getAgentAbout() {
		agentAboutMe.click();
		Helper.threadSleep(3);
		return agentAboutMeTxt.getText().trim();

	}

	public String getAgentDetail(String name) {
		String value = null;
		for (int i = 0; i < agentInfoKey.size(); i++) {
			String text = agentInfoKey.get(i).getText().trim();
			if (text.equalsIgnoreCase(name)) {

				if (name.equalsIgnoreCase("LinkedIn:")) {
					value = agentInfoValueLink.get(2).getAttribute("href");
				} else {
					value = agentInfoValue.get(i).getText().trim();
				}
				break;

			}
		}

		return value;
	}

	public String getAgentName() {
		return agentName1.getText();
	}

	public void displayAgentInfo() {

		Properties prop = new Properties();
		try {
			Helper.threadSleep(1);
			prop.setProperty("Name", getAgentName());
			prop.setProperty("Nationality", getAgentDetail("Nationality:"));
			prop.setProperty("Languages", getAgentDetail("Languages:"));
			prop.setProperty("License", getAgentDetail("License No.:"));
			prop.setProperty("Active listings", getAgentDetail("Active listings:"));
			prop.setProperty("Experience since", getAgentDetail("Experience since:"));
			prop.setProperty("Phone no", getAgentPhoneNo());
			prop.setProperty("Company", getAgentComp());
			prop.setProperty("LinkedIn:", getAgentDetail("LinkedIn:"));
			prop.setProperty("About Me", getAgentAbout());

			File file = new File(
					System.getProperty("user.dir") + "/src/main/java/com/propertyfinder/properties/AgentInfo.txt");
			FileOutputStream fileOut = new FileOutputStream(file);
			prop.store(fileOut, "Properties price listing");
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
