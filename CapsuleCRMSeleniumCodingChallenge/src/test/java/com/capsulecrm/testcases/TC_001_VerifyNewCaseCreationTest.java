package com.capsulecrm.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capsulecrm.utilities.ElementUtils;

import junit.framework.Assert;

public class TC_001_VerifyNewCaseCreationTest extends BaseClass {

	
	
	
	@DataProvider
	public Object[][] getExcelDataforPerson() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("Person_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}
	
	@DataProvider
	public Object[][] getExcelDataforCase() throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		excelData = ElementUtils.loadDataFromExcelFile("Case_Details","./src/main/java/com/capsulecrm/utilities/Excel Data/CapsuleCRMDataFeed.xlsx");
		return excelData;
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.getTitle();
		Assert.assertEquals("Dashboard | Kempegowda CRM", driver.getTitle());
	}
	
	@Test(priority=2, dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforPerson")
	public void addNewPersonTest (String Title, String FirstName, String LastName, String JobTitle, String Organization, String Tags, String Phone, String PhoneType, String Email, String EmailType, String	WebsitesOrSocialNetworks, String SocialNetworkType, String AddressBox, String AddressType, String CityOrTown, String StateOrCountry, String ZipOrPostalCode, String Country) throws InterruptedException{
		
		homePage.goToAddNewPersonPage();
		boolean personAdded = addNewPersonPage.addNewPerson(Title, FirstName, LastName, JobTitle, Organization, Tags, Phone, PhoneType, Email, EmailType,	WebsitesOrSocialNetworks, SocialNetworkType, AddressBox, AddressType, CityOrTown, StateOrCountry, ZipOrPostalCode, Country);
		
		Assert.assertTrue(personAdded);
	} 
	
	@Test(priority=3, dependsOnMethods = {"verifyHomePageTitle"}, dataProvider = "getExcelDataforCase")
	public void addNewCaseTest (String PersonOfCase, String CaseName, String Description, String Tags) throws InterruptedException{
		
		//System.out.println("Values inside addNewCaseTest method: "+PersonOfCase+" "+CaseName+" "+Description+" "+Tags);
		
		homePage.goToAddNewCasePage();
		boolean caseAdded = addNewCasePage.addNewCase(PersonOfCase, CaseName, Description, Tags);
		
		Assert.assertTrue(caseAdded);
	} 
}
