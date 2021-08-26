package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TaggedHooksStepDefinition {
	
	//Global Hooks - will be executed for ALL scenarios
	@Before(order=0) //import from Cucumber API 
	public void setUp() {
		System.out.println("launch browser");
		System.out.println("Enter URL");
	}
	
	@After(order=0)
	public void tearDown() {
		System.out.println("close browser");
	}
	
	
	@Before(order=1) //Ordering of multiple @Before and @After tags/hooks
	public void setUp1() {
		System.out.println("launch browser");
		System.out.println("Enter URL");
	}
	
	@After(order=1)
	public void tearDown1() {
		System.out.println("close browser");
	}
	
	
	
	//Local Hooks - only for 1st scenario
		@Before("@First") 
		public void beforeFirst() {
			System.out.println("before only 1st scenario");
		}
		
		@After("@First")
		public void afterFirst() {
			System.out.println("after only 1st scenario");
		}
		
		@Before("@Second") 
		public void beforeSecond() {
			System.out.println("before only 2nd scenario");
		}
		
		@After("@Second")
		public void afterSecond() {
			System.out.println("after only 2nd scenario");
		}
		
		@Before("@Third") 
		public void beforeThird() {
			System.out.println("before only 3rd scenario");
		}
		
		@After("@Second")
		public void afterThird() {
			System.out.println("after only 3rd scenario");
		}


}
