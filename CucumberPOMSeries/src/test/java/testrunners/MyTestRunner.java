package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/"},
		glue = {"stepdefinition", "AppHooks"},
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/FailedTestCases/failedrerun.txt"},
		//if we dont want to write tags in feature and write from Hooks, wrote code in @Before tag as order = 0
		//tags = "not @Skip",
		monochrome = true,
		dryRun = false )

public class MyTestRunner {

}
