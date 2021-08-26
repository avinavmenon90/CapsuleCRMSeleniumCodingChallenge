package com.capsulecrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(partialLinkText = "Account Settings")
	private static WebElement accountSettingsPageLink;
	
	@FindBy(id="ember22")
	private static WebElement personIcon;
	
	@FindBy(xpath="//a[@aria-label='Cases']")
	private static WebElement casesIcon;
	
	@FindBy(id="select-box-el-32")
	private WebElement addIcon;
	
	@FindBy(xpath="//a[@data-pendo='quick-menu-add-person'][contains(text(),'Person')]")
	private WebElement addPersonLink;
	
	@FindBy(xpath="//a[@data-pendo='quick-menu-add-case'][contains(text(),'Case')]")
	private WebElement addCaseLink;
	
	//@FindBy(xpath="//div[@class='nav-bar-account-details']")
	@FindBy(xpath="//div[contains(@class,'nav-bar-account-button')]")
	private WebElement accountDetailsDropDown;
	
	@FindBy(xpath="//a[contains(@href,'logout')]")
	private WebElement logoutLink;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void goToPeopleAndOrganizationsPage() {
		
		System.out.println("person icon enabled? "+personIcon.isEnabled());
		personIcon.click();
	}
	
	public static void goToCasesPage() {
		
		System.out.println("cases icon enabled? "+casesIcon.isEnabled());
		casesIcon.click();
	}
	
	public void goToAddNewPersonPage() throws InterruptedException {
		
		personIcon.click();
		addIcon.click();
		Thread.sleep(2000);
		addPersonLink.click();
		//action.moveToElement(addPersonLink).click().build().perform();
	
	}
	
	public void goToAddNewCasePage() throws InterruptedException {
		
		casesIcon.click();
		addIcon.click();
		Thread.sleep(500);
		addCaseLink.click();
		Thread.sleep(3000);
		//action.moveToElement(addPersonLink).click().build().perform();
	
	}
	
	public void goToAccountSettingsPage() throws InterruptedException {
		
		//ElementUtils.clickButtonUsingJS(accountDetailsDropDown, driver);
		accountDetailsDropDown.click();
		Thread.sleep(500);
		accountSettingsPageLink.click();
		Thread.sleep(1000);	
	}
	
	public void logoutFromAcct() throws InterruptedException {
		
		//ElementUtils.clickButtonUsingJS(accountDetailsDropDown, driver);
		accountDetailsDropDown.click();
		Thread.sleep(1000);
		logoutLink.click();		
	}
	
}
