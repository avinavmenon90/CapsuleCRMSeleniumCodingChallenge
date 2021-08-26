package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class TracksPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//a[contains(@data-pendo,'add-opportunity-track')]")
	private WebElement addOpportunityTrackBtn;
	
	@FindBy(xpath="//table[@class='chunky-table']//tbody//tr//td//a[contains(@data-pendo,'edit-opportunity-track')]")
	private List<WebElement> opportunityTrackNameslist;
	
	@FindBy(xpath="//label[contains(text(),'Name')]//following-sibling::span[contains(@class,'input')]//input[@type='text']")
	private WebElement opportunityTrackName;
	
	@FindBy(xpath="//label[contains(text(),'Tag')]//following-sibling::span[contains(@class,'input')]//input[@type='text']")
	private WebElement opportunityTrackTag;
	
	@FindBy(id="advancedOptionsLabel")
	private WebElement advancedOptionsLink;
	
	@FindBy(xpath="//select[contains(@id,'trackDirection')]//option")
	private List<WebElement> advancedOptionSelectBoxList;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'taskDescription')]")
	private WebElement taskDescriptionField;
	
	@FindBy(xpath="//span[text()='None']") 
	private WebElement categorySelectBoxDropDown;
	
	@FindBy(xpath="//ul[contains(@class,'colorselectmenu')]//li[@role='option']")
	private List<WebElement> categorySelectBoxDropDownOptions;
	
	@FindBy(xpath="//select[contains(@name,'taskAssignment')]//option")
	private List<WebElement> assigneeSelectBoxList;
	
	@FindBy(xpath="//input[@type='text'][contains(@id,'taskDaysAfter')]")
	private WebElement dueValueField;
	
	@FindBy(xpath="//select[contains(@id,'trackDayDelayRule')]//option")
	private List<WebElement> dueDurationSelectBoxList;

	@FindBy(xpath="//a[contains(text(),'Save')]")
	private static WebElement saveBtn;
	
	public TracksPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}

	public boolean addOpportunitiesTrack(String Name, String Tag, String ChooseAdvancedOptions, String taskDesciption,
			String Category, String Assignee, String DueValue, String DueDuration) throws InterruptedException {
			
		addOpportunityTrackBtn.click();
		Thread.sleep(2000);
		
		opportunityTrackName.sendKeys(Name);
		
		opportunityTrackTag.sendKeys(Tag);
		
		advancedOptionsLink.click();
		Thread.sleep(500);
		
		ElementUtils.chooseValueFromDropDown(advancedOptionSelectBoxList, ChooseAdvancedOptions);
		Thread.sleep(500);
		
		taskDescriptionField.sendKeys(taskDesciption);
		
		categorySelectBoxDropDown.click();
		Thread.sleep(500);

		
		ElementUtils.chooseValueFromDropDown(categorySelectBoxDropDownOptions, Category);	
		Thread.sleep(500);
		
		ElementUtils.chooseValueFromDropDown(assigneeSelectBoxList, Assignee);	
		Thread.sleep(500);
		
		dueValueField.clear();
		Thread.sleep(500);
		dueValueField.sendKeys(DueValue);
		
		ElementUtils.chooseValueFromDropDown(dueDurationSelectBoxList, DueDuration);	
		Thread.sleep(500);
		
		saveBtn.click();
		
		Thread.sleep(2000);
		
			
		return ElementUtils.verifyValueOnPage(opportunityTrackNameslist, Name);
	}
	
}
