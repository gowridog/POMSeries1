package AppHooks;

import java.util.Properties;
import org.junit.Assume;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks  {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
// To skip scenarios from Hooks using Tags
	//@Before(value = "@Skip", order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("Skipped Scenario Name is :" + scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();

	}

	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
		try {
			driver.get(ConfigReader.init_prop().getProperty("url"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.body.style.zoom='100%'");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) { // take screenshot 
			String screenshotName =	scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}

	}

}
