package TestRun;

import java.io.*;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/feature/goodness.feature"},
				//publish=true,
				glue = {"stepDefinition"},
						

				plugin = {
						     "pretty",
						     
						     "html:reports/html-report",
						      "json:reports/result.json",
						      "junit:reports/result.xml"  }
		)
		
public class TestPlum {
	
}
