package stepDefinition;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Hooks_StepDefinition {

	WebDriver driver;
	
	
	@Before //import from Cucumber API 
	public void setUp() {
		System.out.println("launch browser");
		System.out.println("Enter URL");
	}
	
	@After
	public void tearDown() {
		System.out.println("close browser");
	}
	@Given("^User is already on Login Page$") //^ an $ used for Cucumber to understand this line
	public void user_already_on_login_page() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}
	
	//@SuppressWarnings("deprecation")
	@When("^Title of login page is My Store$")
	public void title_of_login_page_is_My_Store() {
	    
		String title = driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals("My Store", title);
	    //throw new PendingException();
	}
	
	@Then("^User clicks on Sign In Button$")
	public void user_clicks_on_Sign_In_Button() {
	    
		driver.findElement(By.className("login")).click();
		//driver.wait();
	    
	}
	
	@Then("^User enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		
		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) { //Map object
		driver.findElement(By.name("email")).sendKeys(data.get("username")); 
		driver.findElement(By.name("passwd")).sendKeys(data.get("password"));
		}
	}

	@Then("^User clicks on Login Button$")
	public void user_clicks_on_Login_Button(){

		driver.findElement(By.name("SubmitLogin")).click();
		//driver.wait();
	    
	}
	
	@Then("^User is taken to home page$")
	public void user_is_taken_to_home_page() {

		String title = driver.getTitle();
		System.out.println("Home page title:"+title);
		Assert.assertEquals("My account - My Store", title);
	    
	} 
}
