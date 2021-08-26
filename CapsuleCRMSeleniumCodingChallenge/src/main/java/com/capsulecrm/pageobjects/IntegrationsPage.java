package com.capsulecrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntegrationsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//a[starts-with(@class,'btn-primary')][contains(text(),'Configure')]")
	private List<WebElement> configureBtnList;

	public IntegrationsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}
	
	public int numberOfConfigureButtons() {
		
		return configureBtnList.size();
	}
	
}
