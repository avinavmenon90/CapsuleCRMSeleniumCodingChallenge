package com.capsulecrm.pageobjects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.utilities.ElementUtils;

public class AppearancePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header')]//h1[contains(@class,'title')]")
	private WebElement pageTitle;
	
	//@FindBy(xpath="//input[@type='file']")
	@FindBy(id="appearance:uploadDecorate:logoImage")
	WebElement fileUploadBtn;
	
	@FindBy(xpath="//h4[contains(text(),'Color Scheme')]//following-sibling::div[@class='swatches']//div[contains(@class,'swatch')]//div[@class='colour']")
	private List<WebElement> colourPickerList;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement saveBtn;

	public AppearancePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		
		return pageTitle.getText().trim();
	}

	public boolean chooseLogoAndColorScheme(String filePath, String colourCode) throws InterruptedException, AWTException {
	
		ElementUtils.uploadFile(fileUploadBtn,filePath, driver);		
		//fileUploadBtn.sendKeys(filePath);
		//Thread.sleep(1000);
		
		ElementUtils.chooseColorfromPicker(colourPickerList, colourCode);
		Thread.sleep(1000);
			
		return true;
	}
	
}
