package TestRun;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	
	@RunWith(Cucumber.class) 
	@CucumberOptions(
			features = {"src/main/java/feature/fblogin.feature"},
			publish=true,
			glue = {"stepDefinition"}) // StepDefinition package name
	public class TestRuner {

}
