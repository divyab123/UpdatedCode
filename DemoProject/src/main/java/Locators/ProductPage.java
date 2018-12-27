package Locators;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.GetWrappedElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
//import javafx.scene.control.Alert;
import BrowserInstance.CommonMethods;

public class ProductPage {

	CommonMethods commonLocators = new CommonMethods();
	public static By icixprdctPage = By.xpath("//span[@class='slds-truncate'][text()='ICIX Products']");
	public static By newprdBtn = By.xpath("//div[text()='New']");
	public static By prdheading = By
			.xpath("//li[@class='slds-breadcrumb__item slds-line-height--reset']/span[text()='ICIX Products']");
	public static By newprdbtn = By.xpath(
			"//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']/li/a/div[text()='New']");
	public static By searchTPbox = By.xpath(
			"//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon--right ng-scope']/input[@role='combobox']");
	public static By frame = By.tagName("iframe");
	public static By selectTPName = By.xpath("//div[@role='listbox']/ul/li[@class='slds-lookup__item slds-clear ng-scope']");
	public static By searchBtn = By.id("btnProductSearch");

	public void openPrdPage() throws Exception {
		commonLocators.waitForElementToBeClickable(icixprdctPage);
		$(icixprdctPage).click();
	}

	public String getTitle() {
		return $(prdheading).getText();
	}

	public void clickNewBtn() throws Exception {
		commonLocators.waitForElementToBeClickable(newprdbtn);
		$(newprdbtn).click();
	}

	public void searchTP() throws Exception {
		try {
			int size = $$(frame).size();
			System.out.println("Size of frames" + size);
			WebDriverRunner.getWebDriver().switchTo().frame(0);
			$(searchTPbox).setValue("QA Org 2 Automation Res Pkg Stg");
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}
	
	public void selectTPName()
	{
		try {
			commonLocators.waitForElementToBeClickable(selectTPName);
			$(selectTPName).click();
		} catch (Exception e) {
			System.out.println("TP Name is not find/ clickable");
		}
	}
	
	public void clickSearchBtn()
	{
		commonLocators.visiblewait(searchBtn);
		$(searchBtn).click();
	}
	
	public boolean enableSearchBtn()
	{
		return $(searchBtn).isEnabled();
	}
	
	public void searchTPandClick() throws Exception
	{
		this.searchTP();
		this.selectTPName();
		this.clickSearchBtn();
	}
}
