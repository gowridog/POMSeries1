package stepdefinition;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	private LoginPage loginPagePage = new LoginPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
		loginPagePage.contactUsLinkClick();
		
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\jsrin\\eclipse-workspace\\CucumberPOMSeries\\src\\test\\resources\\ExcelDataFile\\Book1.xlsx", sheetName);
		
		String heading = testData.get(rowNumber).get("Heading");
		String email = testData.get(rowNumber).get("Email");
		String orderRef = testData.get(rowNumber).get("OrderRef");
		String message = testData.get(rowNumber).get("Message");
		
		contactUsPage.fillContactUsForm(heading, email, orderRef, message);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = contactUsPage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}

}