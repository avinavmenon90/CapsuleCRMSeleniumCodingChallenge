package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class OpportunitiesPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Add Milestone')]")
	private WebElement addMilestoneBtn;
	
	@FindBy(xpath="//table[@class='chunky-table']//tr//td//button[contains(@data-pendo,'edit-milestone')]")
	private List<WebElement> milestoneNamesList;
	
	@FindBy(xpath="//label[contains(text(),'Name')]//following-sibling::input[@type='text']")
	private WebElement milestoneNameField;
	
	@FindBy(xpath="//label[contains(text(),'Description')]//following-sibling::textarea[contains(@class,'description')]")
	private WebElement milestoneDescriptionField;
	
	@FindBy(xpath="//label[contains(text(),'Probability')]//following-sibling::input[@type='number'][contains(@class,'probability')]")
	private WebElement probabilityOfWinningField;
	
	@FindBy(xpath="//label[contains(text(),'Stale')]//following-sibling::input[@type='number'][contains(@class,'stale')]")
	private WebElement daysUntilStaleField;
	
	@FindBy(xpath="//button[@type='submit'][text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Cancel')]")
	private WebElement cancelBtn;
	

	public OpportunitiesPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}

	public boolean addMilestone(String Name, String Description, String WinningProbability, String DaysUntilStale) throws InterruptedException {
		
		addMilestoneBtn.click();
		Thread.sleep(2000);
		milestoneNameField.sendKeys(Name);
		milestoneDescriptionField.sendKeys(Description);
		probabilityOfWinningField.sendKeys(WinningProbability);
		daysUntilStaleField.sendKeys(DaysUntilStale);
		saveBtn.click();
		
		Thread.sleep(2000);
		
		return ElementUtils.verifyValueOnPage(milestoneNamesList, Name);
	}
	
}
