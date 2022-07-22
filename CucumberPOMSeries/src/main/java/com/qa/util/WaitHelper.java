package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper (WebDriver driver) {
		this.driver =driver;
		
	}
	
	//Implicit wait utility and use this in page object class consturctor Ex: LoginPage.class
	public void WaitForElement(WebElement element, long timeOutInSeconds) {
		
		WebDriverWait  wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
