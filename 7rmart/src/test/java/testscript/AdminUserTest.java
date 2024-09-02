package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToAddNewAdminUser")
	public void verifyTheUserIsAbleToAddNewAdminUser() throws IOException  {
		//String usename = "admin";
	//	String password = "admin";
	//	String adminusername="jose thomas cp";
		//String adminpassword="1234567";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		String adminusername=ExcelUtility.getStringData(1, 0, "AdminUserPage");
		String adminpassword=ExcelUtility.getIntegerData(1, 1, "AdminUserPage");
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.enterUsernameOnUsernameField(username);
		adminuserpage.enterPasswordOnPasswordField(password);
		adminuserpage.clickOnSignInButton();
		adminuserpage.clickOnMoreinfoField();
		adminuserpage.clickOnNewField();
		
		adminuserpage.enterUserNameOnAdminUsernameField(adminusername);
		adminuserpage.enterPasswordOnAdminPasswordField(adminpassword);
		adminuserpage.selectUserTypeField();
		adminuserpage.clickOnSaveField();
		boolean isalertfielddisplayed = adminuserpage.isAlertfieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert is not dispayed when user click on save button");
	}

}
