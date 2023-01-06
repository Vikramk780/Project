package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources/parallel"},
		glue = {"parallel"}, //this parallel relavant to applicationhooks
		monochrome =true,
		dryRun =false,
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"


				
				
		}
		
		)
public class RunCucumberIT {
	
}
