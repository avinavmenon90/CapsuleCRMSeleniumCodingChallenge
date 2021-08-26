package com.capsulecrm.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.capsulecrm.utilities.ElementUtils;

import junit.framework.Assert;

/*
 * Log in to the account
 * go to account settings under username -> Account Settings
 * Verify Account Settings header is displayed on the top left navbar
 * click on each link at the left panel and verify the header info on each page
 * Users page => add 1 new user by filling form from Excel. Verify created user on the User page
 * Opportunities Page -> Add Milestone (ignore Lost eEasons) and verify newly created Milestone
 * Tracks page -> Add new Opportunirt Track & verify the same
 * Tasks page -> Add new category & verify the same
 * Integrations page -> verify total number of configure buttons
 * Custom Title page -> Add new custom title and verify
 * Click on Appearance on the bottom -> Upload a logo from the desktop/project folder
 */

public class TC_002_VerifyAccountSettingsTest extends BaseClass{
	
	@DataProvider
	public Object[][] getExcelDataforAddUser() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("AddUser_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}

	@DataProvider
	public Object[][] getExcelDataforAddMilestone() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("Milestone_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}
	
	@DataProvider
	public Object[][] getExcelDataforAddOpportunityTrack() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("OpportunityTrack_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}
	
	@DataProvider
	public Object[][] getExcelDataforAddTaskCategory() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("TaskCategory_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.getTitle();
		Assert.assertEquals("Dashboard | Kempegowda CRM", driver.getTitle());
	}
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, enabled=false)
	public void verifyAaccountAndPlanPage() throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Account and Plan");
		Assert.assertEquals(accountAndPlanPage.pageTitle(),"Account");
		accountSettingsPage.accountSettingsHomePage();
	} 
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforAddUser", enabled=false)
	public void verifyUsersAndTeamsPage(String FirstName, String LastName, String Email, String Username, String Role) throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Users and Teams");
		Assert.assertEquals(accountAndPlanPage.pageTitle(),"Users and Teams");
		Assert.assertTrue(usersAndTeamsPage.addUser(FirstName, LastName, Email, Username, Role));
		accountSettingsPage.accountSettingsHomePage();
	}
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, enabled=false)
	public void verifyIntegrationsPage() throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Integrations");
		Assert.assertEquals(integrationsPage.pageTitle(),"Integrations");
		Assert.assertEquals(integrationsPage.numberOfConfigureButtons(), 14);
		accountSettingsPage.accountSettingsHomePage();
	} 
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, enabled=false)
	public void verifyMailDropBoxPage() throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Mail Drop Box");
		Assert.assertEquals(mailDropBoxPage.pageTitle(),"Mail Drop Box");
		accountSettingsPage.accountSettingsHomePage();
	} 

	@Test(dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforAddMilestone", enabled=false)
	public void verifyOpportunitiesPage(String Name, String Description, String WinningProbability, String DaysUntilStale) throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Opportunities");
		Assert.assertEquals(opportunitiesPage.pageTitle(),"Opportunities");
		Assert.assertTrue(opportunitiesPage.addMilestone(Name, Description, WinningProbability, DaysUntilStale));
		
		accountSettingsPage.accountSettingsHomePage();
	} 
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforAddOpportunityTrack", enabled=false)
	public void verifyTracksPage(String Name, String Tag, String ChooseAdvancedOptions, String TaskDesciption, String Category, String Assignee, String DueValue, String DueDuration) throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Tracks");
		Assert.assertEquals(tracksPage.pageTitle(),"Tracks");
		Assert.assertTrue(tracksPage.addOpportunitiesTrack(Name, Tag, ChooseAdvancedOptions, TaskDesciption, Category, Assignee, DueValue, DueDuration));
		
		accountSettingsPage.accountSettingsHomePage();
	} 
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforAddTaskCategory", enabled=false)
	public void verifyTaskCategoriesPage(String CategoryName, String ColourCode) throws InterruptedException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Task Categories");
		Assert.assertEquals(taskCategoriesPage.pageTitle(),"Task Categories");
		Assert.assertTrue(taskCategoriesPage.addTaskCategory(CategoryName, ColourCode));
		
		accountSettingsPage.accountSettingsHomePage();
	} 
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"})
	public void verifyAppearancePage() throws InterruptedException, AWTException{
		
		homePage.goToAccountSettingsPage();
		accountSettingsPage.goToAccountSettings("Appearance");
		Assert.assertEquals(appearancePage.pageTitle(),"Appearance");
		//Assert.assertTrue(appearancePage.chooseLogoAndColorScheme("‪C:\\Users\\Avinav\\Desktop\\aminternational.jpg","#0076C2"));
		Assert.assertTrue(appearancePage.chooseLogoAndColorScheme("C:/‪test.png","#0076C2"));
		
		accountSettingsPage.accountSettingsHomePage();
	} 

}
