package com.qa.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static final Logger log = LogManager.getLogger(DriverFactory.class);
	
	public WebDriver driver;
	
	//Thread local driver  for parallel execution
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/*
	 * This method is used to initialize the Thread Local driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * 
	 * @return
	 */	
	
	//public WebDriver init_Driver(Properties prop) {
	public WebDriver init_Driver(String browserName) {
		
		 //String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is  :" + browserName);
		
		if (browserName.equals("chrome")) {
			WebDriver driver = WebDriverManager.chromedriver().create();
			tlDriver.set(driver);
		log.info("================ ********************** Chrome Broswer Launched *************************===============");
		}
			
		else if (browserName.equals("firefox")) {
			WebDriver driver = WebDriverManager.firefoxdriver().create();
				tlDriver.set(driver);
				log.info("================ ********************** Firefox Broswer Launched *************************===============");
		}
		
		else if (browserName.equals("safari")) {
				tlDriver.set(new SafariDriver());
				log.info("================ ********************** Safari Broswer Launched *************************===============");
	}
		else if (browserName.equals("edge")) {
			WebDriver driver = WebDriverManager.edgedriver().create();
			tlDriver.set(driver);
			log.info("================ ********************** Edge Broswer Launched *************************===============");
	}
		else {
			System.out.println("please pass the right browser name... " + browserName);
			log.info("================ ********************** Invalid Broswer Name *************************===============");
			//throw new FrameworkException("no browser found...");
		}
		
		//can use driver
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//getDriver().get(prop.getProperty("url"));
		
		//############# To open the browser in 100% zoom to avoid failing mouse actions in different browser
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		 * jse.executeScript("document.body.style.zoom='500%'");
		 */
		return getDriver();
	}

	/*
	 * This is used to get the driver with Threadlocal
	 * 
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
