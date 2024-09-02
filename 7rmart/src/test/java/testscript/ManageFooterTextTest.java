package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToUpdateFooterText")
	public void verifyTheUserIsAbleToUpdateFooterText() throws IOException  {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String address = ExcelUtility.getStringData(1, 0, "ManageFooterPage");
		String email = ExcelUtility.getStringData(1, 1, "ManageFooterPage");
		String phone = ExcelUtility.getIntegerData(1, 2, "ManageFooterPage");

		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.enterUsernameOnUsernameField(username);
		managefootertextpage.enterPasswordOnPasswordField(password);
		managefootertextpage.clickOnSignInButton();
		managefootertextpage.clickOnMoreinfoField();
		managefootertextpage.clickOnActionField();
		managefootertextpage.clearTheAddressField();
		managefootertextpage.enterAddressOnAddressField(address);
		managefootertextpage.clearTheEmailField();
		managefootertextpage.enterEmailOnEmailField(email);
		managefootertextpage.clearThePhoneField();
		managefootertextpage.enterPhoneOnPhoneField(phone);
		managefootertextpage.clickOnUpdateField();
		boolean isalertFieldDisplayed = managefootertextpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert not displayed");

	}

}
