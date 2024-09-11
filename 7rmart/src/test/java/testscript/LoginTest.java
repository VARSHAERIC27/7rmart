package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLoginUsingValidCredential", groups = {
			"Regression" })
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean ishomePageloaded = loginpage.isHomePageLoaded();
		assertTrue(ishomePageloaded, Constants.ErrormessageForLogin);

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLoginUsingInvalidUsername", groups = {
			"Smoke" })
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessageForLogin);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLoginUsingInvalidPassword")
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage lpage = new LoginPage(driver);
		lpage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean isalertFieldDisplayed = lpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessageForLogin);
	}

	@Test(dataProvider = "LOGINPROVIDER", retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLoginUsingInvalidCredential")
	public void verifyTheUserIsAbleToLoginUsingInvalidCredential(String username, String password) throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean isalertFieldDisplayed = loginpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessageForLogin);

	}

	@DataProvider(name = "LOGINPROVIDER")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(3, 0, "LoginPage"), ExcelUtility.getStringData(3, 1, "LoginPage") }, };
	}
}
