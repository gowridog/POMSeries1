package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

//1. By Locators: OR
	private By accountSections = By.cssSelector("div#center_column span");

//2. Constructor of the page class:
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

//3. page actions: features/behaviours of the page in the form of methods:
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
//returns the sections count.
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}

//returns accounts list 
	public List<String> getAccountsSectionList() {

		List<String> accountsList = new ArrayList<>();

		List<WebElement> accountHeaderList = driver.findElements(accountSections);

		for (WebElement e : accountHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}

}
