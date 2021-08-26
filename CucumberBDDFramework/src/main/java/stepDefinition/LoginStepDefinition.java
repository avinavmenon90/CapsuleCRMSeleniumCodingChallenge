package stepDefinition;

//https://www.youtube.com/watch?v=vHzMJuc9Zuk&list=PLFGoYjJG_fqoBFPevCDZDCufDX5h-o3yO

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import junit.framework.Assert;


public class LoginStepDefinition {
/*	
	WebDriver driver;
	
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
	
	
	@Then("^User enters \"(.*)\" and \"(.*)\"$") //regex indicating that value comes from feature file
	public void user_enters_username_and_password(String username, String password) {
		
		//Data Driven Testing (without Examples keyword)
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("passwd")).sendKeys(password);
		
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
	
	@Then("^Close the Browser$")
	public void close_the_Browser() {

		driver.quit();
	    
	}	
*/	
}
