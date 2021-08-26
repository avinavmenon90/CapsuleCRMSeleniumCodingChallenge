package com.capsulecrm.testcases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.capsulecrm.factory.DriverFactory;
import com.capsulecrm.pageobjects.AccountAndPlanPage;
import com.capsulecrm.pageobjects.AccountSettingsPage;
import com.capsulecrm.pageobjects.AddNewCasePage;
import com.capsulecrm.pageobjects.AddNewPersonPage;
import com.capsulecrm.pageobjects.AppearancePage;
import com.capsulecrm.pageobjects.CustomFieldsPage;
import com.capsulecrm.pageobjects.CustomTitlesPage;
import com.capsulecrm.pageobjects.HomePage;
import com.capsulecrm.pageobjects.IntegrationsPage;
import com.capsulecrm.pageobjects.MailDropBoxPage;
import com.capsulecrm.pageobjects.OpportunitiesPage;
import com.capsulecrm.pageobjects.TagsAndDataTagsPage;
import com.capsulecrm.pageobjects.TaskCategoriesPage;
import com.capsulecrm.pageobjects.TracksPage;
import com.capsulecrm.pageobjects.UsersAndTeamsPage;
import com.capsulecrm.utilities.ConfigPropertiesFileReader;
import com.capsulecrm.utilities.ElementUtils;

public class BaseClass {

	DriverFactory df;
	ConfigPropertiesFileReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	AddNewPersonPage addNewPersonPage;
	AddNewCasePage addNewCasePage;
	AccountAndPlanPage accountAndPlanPage;
	AccountSettingsPage accountSettingsPage;
	AppearancePage appearancePage;
	CustomFieldsPage customFieldsPage;
	CustomTitlesPage customTitlesPage;
	IntegrationsPage integrationsPage;
	MailDropBoxPage mailDropBoxPage;
	OpportunitiesPage opportunitiesPage;
	TagsAndDataTagsPage tagsAndDataTagsPage;
	TaskCategoriesPage taskCategoriesPage;
	TracksPage tracksPage;
	UsersAndTeamsPage usersAndTeamsPage;
	
	ElementUtils elementUtils;
	int counter;
	Object[][] excelData;
	
	@BeforeSuite
	public void setUp() {
		
		counter=0;
		cp = new ConfigPropertiesFileReader();
		df = new DriverFactory();
		prop = cp.initProperties(); //initiate & load from properties file
		driver = df.initDriver(prop.getProperty("browser"), prop); //pass prop obj to df & launch URL
		homePage = new HomePage(driver);
		addNewPersonPage = new AddNewPersonPage(driver);
		addNewCasePage = new AddNewCasePage(driver);
		accountSettingsPage = new AccountSettingsPage(driver);
		accountAndPlanPage = new AccountAndPlanPage(driver);
		appearancePage = new AppearancePage(driver);
		customFieldsPage = new CustomFieldsPage(driver);
		integrationsPage = new IntegrationsPage(driver);
		mailDropBoxPage = new MailDropBoxPage(driver);
		opportunitiesPage = new OpportunitiesPage(driver);
		tagsAndDataTagsPage = new TagsAndDataTagsPage(driver);
		taskCategoriesPage = new TaskCategoriesPage(driver);
		usersAndTeamsPage = new UsersAndTeamsPage(driver);
		tracksPage = new TracksPage(driver);
		elementUtils = new ElementUtils(driver);

	}

	@AfterSuite
	public void tearDown() {
		
		//driver.close();
		//driver.quit();
	}
	
	@BeforeMethod()
	public void login() throws InterruptedException {
		
		driver.findElement(By.id("login:usernameDecorate:username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("login:passwordDecorate:password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login:login")).click();
		
		System.out.println("login counter: "+(counter++));
		if(counter==1) {
		
			driver.findElement(By.xpath("//a[text()='Return to home page']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("login:usernameDecorate:username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.id("login:passwordDecorate:password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("login:login")).click();
			}
	}
	
	@AfterMethod()
	public void logout() throws InterruptedException {
		
		Thread.sleep(2000);
		homePage.logoutFromAcct();
	}
	
	
}
