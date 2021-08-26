package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class AddNewPersonPage {
	
	private WebDriver driver;
	
	private boolean flag;
	
	@FindBy(xpath="//label[contains(text(),'Title')]//following::div[1][@role='listbox']")
	private WebElement nameTitleDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Title')]//following::div[1][@role='listbox']//div[@class='select-box__options']//div")
	private  List<WebElement> nameTitleDropDownOptions;
	
	@FindBy(xpath="//label[contains(text(),'First Name')]//following-sibling::input")
	private WebElement firstName;
	
	@FindBy(xpath="//label[contains(text(),'Last Name')]//following-sibling::input")
	private WebElement lastName;
	
	@FindBy(xpath="//label[contains(text(),'Job Title')]//following-sibling::input")
	private WebElement jobTitle;
	
	@FindBy(xpath="//label[text()='Organization']//following::div[1]//input[contains(@class,'input')]")
	private WebElement organizationField;
	
	@FindBy(xpath="//label[text()='Organization']//following::div[1]//div[@role='option']")
	private WebElement addNewOrganization;
	
	@FindBy(xpath="//label[contains(text(),'Tags')]//following::div[@role='combobox']//input[contains(@class,'input')]")
	private WebElement tagsField;
	
	@FindBy(xpath="//label[contains(text(),'Tags')]//following::div[@role='combobox']//following::div[1][@role='option']")
	private WebElement addNewTag;
	
	@FindBy(xpath="//div[text()='Phone Numbers']//following::input[contains(@class,'phone-number')]")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//div[text()='Mobile']")
	private WebElement phoneNumberTypeDropDown;
	
	@FindBy(xpath="//div[text()='Mobile']//following::div[@class='select-box__options']//div")
	private List<WebElement> phoneNumberTypeDropDownOptions;
	
	@FindBy(xpath="//div[text()='Email Addresses']//following::input[contains(@class,'email-address')]")
	private WebElement email;
	
	@FindBy(xpath="//div[text()='Email Addresses']//following::div[contains(@class,'form-field')]//div[1][text()='Work']")
	private WebElement emailTypeDropDown;
	
	@FindBy(xpath="//div[text()='Email Addresses']//following::div[contains(@class,'form-field')]//div[1][text()='Work']//following::div[@class='select-box__options']//div")
	private List<WebElement> emailTypeDropDownOptions;
	
	@FindBy(xpath="//div[text()='Websites & Social Networks']//following::input[@type='text']")
	private WebElement website;
	
	@FindBy(xpath="//div[1][text()='Twitter']")
	private WebElement socialNetworkDropDown;
	
	@FindBy(xpath="//div[1][text()='Twitter']//following::div[1][@class='select-box__options']//div")
	private List<WebElement> socialNetworkDropDownOptions;		
	
/*	@FindBy(xpath="//div[text()='Websites & Social Networks']//following::div[@class='form-row form-row-flush-fields']//div[@role='button']")
	private WebElement websiteTypeDropDown;
	
	@FindBy(xpath="//div[@aria-labelledby='select-box-el-50']//div[@role='option']")
	private List<WebElement> websiteTypeDropDownOptions; */
	
	@FindBy(xpath="//legend//following::button[contains(text(),'Add')][4]")
	private WebElement addAddressLink;
	
	@FindBy(xpath="//label[contains(text(),'Address')]//following::textarea")
	private WebElement addressTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Address')]//following::textarea//following::div[2][@role='listbox']")
	private WebElement addressTypeDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Address')]//following::textarea//following::div[2][@role='listbox']//div[@class='select-box__options']//div")
	private List<WebElement> addressTypeDropDownOptions;
	
	@FindBy(xpath="//label[contains(text(),'City')]//following::input[1][@type='text']")
	private WebElement addCity;
	
	@FindBy(xpath="//label[contains(text(),'State')]//following::input[1][@type='text']")
	private WebElement addState;
	
	@FindBy(xpath="//label[contains(text(),'Zip')]//following::input[1][@type='text']")
	private WebElement addZipCode;
	
	@FindBy(xpath="//label[contains(text(),'Country')]//following::div[@role='button']")
	private WebElement countryDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Country')]//following::div[@role='button']//following::div[@class='select-box__options']//div")
	private List<WebElement> countryDropDownOptions;
	
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveFormBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelFormBtn;
	
	@FindBy(xpath="//tbody[@class='ember-view']//tr[@class='list-results__row']//td[3]//a")
	private List<WebElement> personNames;
	
	public AddNewPersonPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public boolean addNewPerson(String Title, String FirstName, String LastName, String JobTitle, String Organization, String Tags, String Phone, String PhoneType, String Email, String EmailType, String	WebsitesOrSocialNetworks, String SocialNetworkType, String AddressBox, String AddressType, String CityOrTown, String StateOrCountry, String ZipOrPostalCode, String Country) throws InterruptedException {

		nameTitleDropDown.click();
		Thread.sleep(1000);
		ElementUtils.chooseValueFromDropDown(nameTitleDropDownOptions, Title);
		
		firstName.sendKeys(FirstName);
		
		lastName.sendKeys(LastName);
		
		jobTitle.sendKeys(JobTitle);
		
		System.out.println("org field displayed? "+organizationField.isDisplayed());
		System.out.println("org field enabled? "+organizationField.isEnabled());
		//organizationField.click();
		//System.out.println("after click, org field enabled? "+organizationField.isEnabled());
		//Thread.sleep(3000);
		organizationField.sendKeys(Organization);
		//ElementUtils.sendKeysUsingJS(organizationField, driver, "ABC");
		Thread.sleep(1000);
		addNewOrganization.click();
		
		tagsField.sendKeys(Tags);
		Thread.sleep(1000);
		addNewTag.click();
		
		phoneNumber.sendKeys(Phone);
		
		phoneNumberTypeDropDown.click();
		Thread.sleep(500);
		ElementUtils.chooseValueFromDropDown(phoneNumberTypeDropDownOptions, PhoneType);	
		
		email.sendKeys(Email);
		
		emailTypeDropDown.click();
		ElementUtils.chooseValueFromDropDown(emailTypeDropDownOptions,EmailType);
		
		website.sendKeys(WebsitesOrSocialNetworks);
		
		socialNetworkDropDown.click();
		ElementUtils.chooseValueFromDropDown(socialNetworkDropDownOptions, SocialNetworkType);
		//websiteTypeDropDown.click();
		//ElementUtils.chooseValueFromDropDown(websiteTypeDropDownOptions, "Work");
		
		addAddressLink.click();
		Thread.sleep(1000);
		
		addressTextBox.sendKeys(AddressBox);
		
		addressTypeDropDown.click();
		Thread.sleep(500);
		ElementUtils.chooseValueFromDropDown(addressTypeDropDownOptions, AddressType);
		
		addCity.sendKeys(CityOrTown);
		
		addState.sendKeys(StateOrCountry);
		
		addZipCode.sendKeys(ZipOrPostalCode);
		
		countryDropDown.click();
		Thread.sleep(500);
		ElementUtils.chooseValueFromDropDown(countryDropDownOptions, Country);
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[@role='button']")).getText());
		
		saveFormBtn.click();
		Thread.sleep(1000);
		
		HomePage.goToPeopleAndOrganizationsPage();
		Thread.sleep(2000);
		
		flag = false;	
		for(WebElement e: personNames) {
			//System.out.println(e.getText());
			//System.out.println(FirstName+" "+LastName);
			if(e.getText().equalsIgnoreCase((FirstName+" "+LastName))) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
	
	
	
}
