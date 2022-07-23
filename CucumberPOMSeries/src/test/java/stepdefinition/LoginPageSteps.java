package stepdefinition;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.JavascriptExecutor;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Log4jHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	//public static final Logger log = LogManager.getLogger(DriverFactory.class);

	// Create a object for Login Page as private instead of extending

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	// 1. Soft assertion declaration  step  in Junit
	@Rule
	public ErrorCollector ec = new ErrorCollector();

	@Given("user is on login page")
	public void user_is_on_login_page() {

		// DriverFactory.getDriver().get("https://sso.teachable.com/secure/9521/identity/login/password?wizard_id=K7kRWqv1B7A2q-ThPcwMo17oYRRam3nX0ZYNTJ3U8q4qC33erxXUF9uTBlPFYSlYFmZvvKui_AGcOjK4Z0ffiA");
		/*
		 * DriverFactory.getDriver() .get(
		 * "http://automationpractice.com/index.php?controller=authentication&back=my-account"
		 * );
		 */

		// ############# To open the browser in 100% zoom to avoid failing mouse actions
		// in different browser
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("document.body.style.zoom='100%'");
//		DriverFactory.getDriver().manage().window().maximize();
		
		Log4jHelper.info("****************   Maximized ***********************");
		Log4jHelper.debug("****************   Maximized ***********************");
		Log4jHelper.error("****************   Maximized ***********************");
		Log4jHelper.fatal("****************   Maximized ***********************");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is :" + title);
		Log4jHelper.info("****************   Maximized ***********************");
		Log4jHelper.debug("****************   Maximized ***********************");
		Log4jHelper.error("****************   Maximized ***********************");
		Log4jHelper.fatal("****************   Maximized ***********************");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {

		Assert.assertTrue(title.contains(expectedTitleName));
		// or
		/*
		 * Assert.assertTrue(
		 * DriverFactory.getDriver().findElement(By.tagName("body")).getText().contains(
		 * expectedTitleName));
		 */
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		/*
		 * if
		 * (DriverFactory.getDriver().getPageSource().contains("Forgot your password?"))
		 * { System.out.println("FOUND ========= > Forgot your password?");
		 * System.out.println(DriverFactory.getDriver().getTitle()); } else {
		 * System.out.
		 * println("NOT FOUND text in soruce of the page ====> Forgot your password?");
		 * 
		 * }
		 */
		String forgotPwdText = loginPage.isForgotPwdLinkText();
		Assert.assertEquals(forgotPwdText, "Forgot your password??");
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());

		// 2. Soft assertion declaration final step 
		/*
		 * try {
		 * 
		 * Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		 * 
		 * } catch (Exception e) { ec.addError(e); }
		 */
		

	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
		Log4jHelper.info("****************   Maximized ***********************");
		Log4jHelper.debug("****************   Maximized ***********************");
		Log4jHelper.error("****************   Maximized ***********************");
		Log4jHelper.fatal("****************   Maximized ***********************");
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	}

}
