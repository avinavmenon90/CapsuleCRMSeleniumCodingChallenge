package com.capsulecrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountAndPlanPage {
	
	private WebDriver driver;

	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private static WebElement pageTitle;

	public AccountAndPlanPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}

}