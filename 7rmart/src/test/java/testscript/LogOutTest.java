package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	public LoginPage login;
	public AdminUserPage admin;
	public LogOutPage logout;
	public ManageCategoryPage managecategory;


	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLogOut", groups = { "Regression" })
	public void verifyTheUserIsAbleToLogOut() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password);
		admin=login.clickOnSignInButton();
		logout=login.clickOnAdminImageField();
		managecategory=logout.clickOnAdminImageField().clickOnLogOutField();
		String logintext = logout.getTextFromLogOutField();
		Assert.assertEquals(logintext, Constants.AlertMessageForLogOut);

	}

}
