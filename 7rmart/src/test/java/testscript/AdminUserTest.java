package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToAddNewAdminUser")
	public void verifyTheUserIsAbleToAddNewAdminUser() throws IOException {
		// String usename = "admin";
		// String password = "admin";
		// String adminusername="jose thomas cp";
		// String adminpassword="1234567";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String adminusername = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		String adminpassword = ExcelUtility.getIntegerData(1, 1, "AdminUserPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnMoreinfoField();
		adminuserpage.clickOnNewField();
		adminuserpage.enterUserNameOnAdminUsernameField(adminusername);
		adminuserpage.enterPasswordOnAdminPasswordField(adminpassword);
		adminuserpage.selectUserTypeField();
		adminuserpage.clickOnSaveField();
		boolean isalertfielddisplayed = adminuserpage.isAlertfieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertMessageForAdmin);
	}

}
