package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;

public class AdminUserTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAddNewAdminUser() {
		String usename = "admin";
		String password = "admin";
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.enterUsernameOnUsernameField(usename);
		adminuserpage.enterPasswordOnPasswordField(password);
		adminuserpage.clickOnSignInButton();
		adminuserpage.clickOnMoreinfoField();
		adminuserpage.clickOnNewField();
		adminuserpage.enterUserNameOnAdminUsernameField();
		adminuserpage.enterPasswordOnAdminPasswordField();
		adminuserpage.selectUserTypeField();
		adminuserpage.clickOnSaveField();
		boolean isalertfielddisplayed = adminuserpage.isAlertfieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert is not dispayed when user click on save button");
	}

}
