package Runner;


//https://www.youtube.com/watch?v=vHzMJuc9Zuk&list=PLFGoYjJG_fqoBFPevCDZDCufDX5h-o3yO


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "C:\\Users\\Avinav\\eclipse-workspace\\CucumberBDDFramework\\src\\main\\java\\Feature\\tagging.feature", //location of feature file
		glue= {"stepDefinition"}, //path of step definition file
		//glue= {"C:\\Users\\Avinav\\eclipse-workspace\\CucumberBDDFramework\\src\\main\\java\\stepDefinition\\CartStepDefinition.java"},
		format = {"pretty","html:test-output","json:json_output/cucumber.json","junit:junt_xml/cucumber.xml"}, //generate different types of reporting formats
		dryRun = true, //check mapping between feature file and step def file
		monochrome = true, //display console o/p in a readable format
		strict = true, //Fails execution if there are any pending or undefined steps
		//tags = {"@SmokeTest", "@RegressionTest"} //only execute scenarios under these tags in the feature file

//ORed: tags = tags = {"@SmokeTest, @RegressionTest"}, --execute all tested tagged as @SmokeTest OR @RegressionTest
//ANDed: tags = tags = {"@SmokeTest", "@RegressionTest"}, --execute all tested tagged as @SmokeTest AND @RegressionTest	
		
		//Ignore a specific tag
		//tags = {"~@SmokeTest", "@RegressionTest"} //only execute scenarios under these tags in the feature file
		
		//ONLY execute scenarios WITHOUT any tags
		tags = {"~@SmokeTest", "~@RegressionTest","~@End2end"} //only execute scenarios under these tags in the feature file

		)

public class TestRunner {

	
	
}
