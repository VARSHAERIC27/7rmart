package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base {
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredential() {

		String username = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();

		boolean ishomePageloaded = loginpage.isHomePageLoaded();
		assertTrue(ishomePageloaded, "home page is not loaded when user enter valid credentials");

	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() {
		String username = "varsha";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();

		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid username");
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() {
		String username = "admin";
		String password = "adm";
		LoginPage lpage = new LoginPage(driver);
		lpage.enterUsernameOnUsernameField(username);
		lpage.enterPasswordOnPasswordField(password);
		lpage.clickOnSignInButton();
		boolean isalertFieldDisplayed = lpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid password");

	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidCredential() {
		String username = "admi";
		String password = "adm";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid credentials");

	}
}
