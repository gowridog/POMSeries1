package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.WaitHelper;

public class LoginPage {

	private WebDriver driver;
	WaitHelper waitHelper;

	// 1. By Locators: OR
	// private By emailId = By.id("email");

	// ### @Findby Using ##############

	@FindBy(id = "email")
	@CacheLookup
	private WebElement emailId;

	private By password = By.id("passwd");
	private By signInButton = By.name("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot *your password?");
	private By contactUsLink = By.linkText("Contact us");
	

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//implicit wait instatiating at class cosntructor level use in action methods.
		waitHelper = new WaitHelper(driver);
		

	}

	// 3. page actions: features/behaviours of the page in the form of methods:
	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();

	}
	
	public void contactUsLinkClick() {
		driver.findElement(contactUsLink).click();

	}

	public void enterUserName(String username) {
		// driver.findElement(emailId).sendKeys(username);
		//using the implict wait and to wait max 30 secs
		waitHelper.WaitForElement(emailId, 30);
		emailId.clear();
		emailId.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		// driver.findElement(emailId).sendKeys(un);
		emailId.sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);

	}

}
