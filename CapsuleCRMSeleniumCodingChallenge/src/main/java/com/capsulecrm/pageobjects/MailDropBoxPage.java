package com.capsulecrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailDropBoxPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h2[contains(@class,'title')]")
	private WebElement pageTitle;

	public MailDropBoxPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}
	
}
