package com.qa.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.EventHandler;
import com.qa.util.Log4jHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	// Thread local driver for parallel execution
	public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
	/*
	 * This method is used to initialize the Thread Local driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * 
	 * @return
	 */

	// public WebDriver init_Driver(Properties prop) {
	public WebDriver init_Driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		// String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is  :" + browserName);

		if (browserName.equals("chrome")) {
			 driver = WebDriverManager.chromedriver().create();
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			EventHandler handler = new EventHandler();
			eventDriver.register(handler);
			tlDriver.set(eventDriver);
			Log4jHelper.info(
					"================ ********************** Chrome Broswer Launched *************************===============");
		}

		else if (browserName.equals("firefox")) {
			 driver = WebDriverManager.firefoxdriver().create();
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			EventHandler handler = new EventHandler();
			eventDriver.register(handler);
			tlDriver.set(eventDriver);
			Log4jHelper.info(
					"================ ********************** Firefox Broswer Launched *************************===============");
		}

		else if (browserName.equals("safari")) {
			 driver = WebDriverManager.safaridriver().create();
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			EventHandler handler = new EventHandler();
			eventDriver.register(handler);
			tlDriver.set(eventDriver);
			Log4jHelper.info(
					"================ ********************** Safari Broswer Launched *************************===============");
		} else if (browserName.equals("edge")) {

			 driver = WebDriverManager.edgedriver().create();
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			EventHandler handler = new EventHandler();
			eventDriver.register(handler);
			tlDriver.set(eventDriver);
			Log4jHelper.info(
					"================ ********************** Edge Broswer Launched *************************===============");
		} else {
			System.out.println("please pass the right browser name... " + browserName);
			Log4jHelper.info(
					"================ ********************** Invalid Broswer Name *************************===============");
			// throw new FrameworkException("no browser found...");
		}

		// can use driver
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();


		return getDriver();
	}

	/*
	 * This is used to get the driver with Threadlocal
	 * 
	 * @return
	 */

	public static synchronized EventFiringWebDriver getDriver() {
		return tlDriver.get();
	}

}
