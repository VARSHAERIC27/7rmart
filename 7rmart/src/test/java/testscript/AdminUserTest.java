package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	public AdminUserPage admin;
	public LoginPage login;
	public ManageContactPage contact;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToAddNewAdminUser")
	public void verifyTheUserIsAbleToAddNewAdminUser() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String adminusername = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		String adminpassword = ExcelUtility.getIntegerData(1, 1, "AdminUserPage");
		login = new LoginPage(driver);
		admin = login.enterUsername(username).enterPassword(password).clickOnSignInButton();

		contact = admin.clickOnMoreinfoField().clickOnNewField().enterUserNameOnAdminUsernameField(adminusername)
				.enterPasswordOnAdminPasswordField(adminpassword).selectUserTypeField().clickOnSaveField();

		boolean isalertfielddisplayed = admin.isAlertfieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertMessageForAdmin);
	}

}
