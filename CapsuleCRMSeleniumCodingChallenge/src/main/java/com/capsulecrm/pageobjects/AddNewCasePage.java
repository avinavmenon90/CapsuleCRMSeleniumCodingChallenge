package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.capsulecrm.utilities.ElementUtils;

public class AddNewCasePage {
	
	private WebDriver driver;
	
	private WebElement currentCaseStatus;
	
	private boolean flag;
	
	private int loopCounter;
	
	@FindBy(xpath="//label[contains(text(),'Case Relates To')]//following::div//input[@placeholder='Find a person or organization']")
	private WebElement caseRelatesToField;
	
	@FindBy(xpath="//div[@class='search-select__results']//span[contains(@class,'option-main-text')]")
	private List<WebElement> caseRelatesToFieldDropDownValues;
	
	@FindBy(xpath="//div[contains(text(),'Additional Contacts')]")
	private WebElement additionalContactsLink;
	
	@FindBy(xpath="//div[contains(text(),'Additional Contacts')]//following::input[@placeholder='Find a person or organization']")
	private WebElement findPersonOrOrganizationField;
	
	
	@FindBy(xpath="//div[contains(text(),'Additional Contacts')]//following::input[@placeholder='Find a person or organization']//following::div[@role='listbox']//span[contains(@class,'main-text')]")
	private List<WebElement>  findPersonOrOrganizationDropDownValues;
	
	@FindBy(xpath="//label[contains(text(),'Case Name')]//following-sibling::input[@type='text']")
	private WebElement caseNameField;
	
	@FindBy(xpath="//label[contains(text(),'Description')]//following-sibling::textarea")
	private WebElement descriptionTextArea;
	
	@FindBy(xpath="//label[contains(text(),'Tags')]//following::div[@role='combobox']//input[contains(@class,'input')]")
	private WebElement tagsField;
	
	@FindBy(xpath="//label[contains(text(),'Tags')]//following::div[@role='combobox']//following-sibling::div[@role='option']")
	private List<WebElement> chooseTagfromList;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveFormBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelFormBtn;
	
	@FindBy(xpath="//div[starts-with(@class,'list-results')]//table//tbody//div[@class='list-results-cell-summary']//a")
	private List<WebElement> caseNames;

	
	public AddNewCasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public boolean addNewCase(String PersonOfCase, String CaseName, String Description, String Tags) throws InterruptedException {
		
		System.out.println("Values inside addNewCase method: "+PersonOfCase+" "+CaseName+" "+Description+" "+Tags);
		caseRelatesToField.sendKeys(PersonOfCase);
		Thread.sleep(1000);
		ElementUtils.chooseValueFromDropDown(caseRelatesToFieldDropDownValues, PersonOfCase);
		Reporter.log("Test reporter");
		
		caseNameField.sendKeys(CaseName);
		
		descriptionTextArea.sendKeys(Description);
		
		tagsField.click();
		Thread.sleep(500);
		ElementUtils.chooseValueFromDropDown(chooseTagfromList, Tags);
		
		saveFormBtn.click();
		Thread.sleep(1000);
		
		HomePage.goToCasesPage();
	
		loopCounter = 0;
		
		for(WebElement e: caseNames) {
			loopCounter++;  //increase counter after each loop iteration
			//System.out.println("String from site: "+e.getText());
			String[] stringArr = e.getText().split(",");
			//System.out.println("String array values:"+stringArr[0].trim()+" & "+stringArr[1].trim());
			flag = false;
			if((stringArr[0].trim().equalsIgnoreCase(PersonOfCase)) && (stringArr[1].trim().equalsIgnoreCase(CaseName))) {	
				currentCaseStatus = driver.findElement(By.xpath("//div[starts-with(@class,'list-results')]//table//tbody//div[@class='list-results-cell-summary']//a//following::td[contains(@class,'status')]["+loopCounter+"]//span"));
				System.out.println("checking current case status for position "+loopCounter+" "+currentCaseStatus.getText().trim());	
					if(currentCaseStatus.getText().trim().equalsIgnoreCase("Open")) {
						flag=true;
						break;
					}
			}
		}
		return flag;
	}
}
