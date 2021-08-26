package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class TaskCategoriesPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Add Category')]")
	private WebElement addCategoryBtn;
	
	@FindBy(xpath="//table[@class='chunky-table']//button[@data-pendo='settings-task-categories-edit']")
	private List<WebElement> taskCategoriesNameslist;
	
	@FindBy(xpath="//label[contains(text(),'Name')]//following-sibling::input[@type='text']")
	private WebElement taskCategoryName;
	
	@FindBy(xpath="//label[text()='Colour']//following-sibling::div[contains(@class,'colour-picker')]//div")
	private List<WebElement> colorPickerList;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	

	public TaskCategoriesPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}
	
	public boolean addTaskCategory(String CategoryName, String ColourCode) throws InterruptedException {
		
		addCategoryBtn.click();
		Thread.sleep(500);
		
		taskCategoryName.sendKeys(CategoryName);
		
		ElementUtils.chooseColorfromPicker(colorPickerList, ColourCode);
		
		saveBtn.click();
		Thread.sleep(2000);
		
		return ElementUtils.verifyValueOnPage(taskCategoriesNameslist, CategoryName);
	}
	
}
