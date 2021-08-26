package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class AccountSettingsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[@data-pendo='settings-portal-primary']//h2[contains(@class,'item-title')]")
	private List<WebElement> accountSettingsItemsList;
	
	@FindBy(xpath="//a[@data-pendo-guide='show-breadcrumbs-guide'][contains(text(),'Account Settings')]")
	private WebElement accountSettingsHomeLink;
	
	@FindBy(xpath="//div[@data-pendo='settings-portal-secondary']//h2[contains(text(),'Appearance')]")
	private WebElement appearancePageLink;

	public AccountSettingsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToAccountSettings(String linkToClick) throws InterruptedException {
		
		switch(linkToClick) {
		
		case "Account and Plan": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Users and Teams": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Integrations": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Mail Drop Box": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Opportunities": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Tracks": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Task Categories": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Custom Fields": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Tags and DataTags": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Custom Titles": 
			ElementUtils.chooseValueFromDropDown(accountSettingsItemsList, linkToClick);
			break;
			
		case "Appearance": 
			appearancePageLink.click();
			break;
		
		default: 
				System.out.println("Invalid option! Please check and Try again");
			
		}
	
	}
	
	public void accountSettingsHomePage() {
		
		accountSettingsHomeLink.click();
		
	}
	

}
