package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CartStepWithMapDefinition {

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
	
	@Then("^user moves to Search bar$")
	public void user_moves_to_Search_bar() throws InterruptedException {
		
		//driver.findElement(By.id("searchbox")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("searchbox")));
		//Thread.sleep(1000);
		
	}

	@Then("^user types keyword$")
	public void user_types_keyword(DataTable search) {
		
		for(Map<String, String> searcKeyword : search.asMaps(String.class, String.class)) { //using Data table withMap object
			driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys(searcKeyword.get("search"));
			driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
			}
	}

	@Then("^user clicks on add to cart$")
	public void user_clicks_on_add_to_cart() {

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
		
	    
	}

	@Then("^user clicks on Proceed to Checkout$")
	public void user_clicks_on_Proceed_to_Checkout() {

		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	   
	}

	@Then("^Title of Cart Page is Order - My Store$")
	public void title_of_Cart_Page_is_Order_My_Store() {

		String cartPagetitle = driver.getTitle();
		Assert.assertEquals("Order - My Store", cartPagetitle);
		
	}
	
	
	@Then("^Close the browser$")
	public void close_the_browser() {

		driver.quit();
	}
	
	
}
