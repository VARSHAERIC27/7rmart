package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToLogOut", groups = { "Regression" })
	public void verifyTheUserIsAbleToLogOut() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		LogOutPage logoutpage = new LogOutPage(driver);
		logoutpage.clickOnAdminImageField();
		logoutpage.clickOnLogOutField();
		String logintext = logoutpage.getTextFromLogOutField();
		Assert.assertEquals(logintext, Constants.AlertMessageForLogOut);

	}

}
