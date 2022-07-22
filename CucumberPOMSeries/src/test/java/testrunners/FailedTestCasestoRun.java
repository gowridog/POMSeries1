package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@target\\FailedTestCases\\failedrerun.txt"},
		glue = {"stepdefinition", "AppHooks"},
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target\\FailedTestCases\\failedrerun.txt"},
		monochrome = true
		
		
		)
public class FailedTestCasestoRun {

}
