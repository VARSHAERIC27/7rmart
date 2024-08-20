package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException {

		//String username = "admin";
		//String password = "admin";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();

		boolean ishomePageloaded = loginpage.isHomePageLoaded();
		assertTrue(ishomePageloaded, "home page is not loaded when user enter valid credentials");

	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {
		//String username = "varsha";
		//String password = "admin";
		String username=ExcelUtility.getStringData(2, 0,"LoginPage" );
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();

		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid username");
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {
		//String username = "admin";
		//String password = "adm";
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage lpage = new LoginPage(driver);
		lpage.enterUsernameOnUsernameField(username);
		lpage.enterPasswordOnPasswordField(password);
		lpage.clickOnSignInButton();
		boolean isalertFieldDisplayed = lpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid password");

	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidCredential() throws IOException {
		//String username = "admi";
		//String password = "adm";
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert is not displayed when user enter invalid credentials");

	}
}
