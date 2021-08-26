package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class UsersAndTeamsPage {
	
	private WebDriver driver;
	
	private boolean flag;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private static WebElement pageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Add User')]")
	private WebElement addUserBtn;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'firstname')]")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'lastName')]")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'email')]")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'username')]")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@type='checkbox'][contains(@id,'administrator')]")
	private WebElement administratorPermissionCheckBox;
	
	@FindBy(xpath="//input[@type='checkbox'][contains(@id,'exporter')]")
	private WebElement exporterPermissionCheckBox;
	
	@FindBy(xpath="//input[@type='submit'][@value='Invite user']")
	private WebElement inviteUserBtn;
	
	@FindBy(linkText = "Cancel")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//table[@class='chunky-table']//tbody//td[contains(@class,'name-column')]//a")
	private List<WebElement> userNamesList;
	
	
	public UsersAndTeamsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String pageTitle() {
		
		return pageTitle.getText().trim();
	}

	public boolean addUser(String FirstName, String LastName, String Email, String Username, String Role) throws InterruptedException {
		
		addUserBtn.click();
		Thread.sleep(500);
		firstNameField.sendKeys(FirstName);
		lastNameField.sendKeys(LastName);
		emailField.sendKeys(Email);
		usernameField.sendKeys(Username);
		
		switch(Role) {
		case "Administrator":
			administratorPermissionCheckBox.click();
			break;
		case "Exporter":
			exporterPermissionCheckBox.click();
			break;
		
		default:
			System.out.println("Invalid role!");
		}
		
		inviteUserBtn.click();
		
		Thread.sleep(3000);
		
		return ElementUtils.verifyValueOnPage(userNamesList, Username);
		
	}
	
}
