package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	public ManageContactPage contact;
	public LoginPage login;
	public ManageFooterTextPage footer;
	public AdminUserPage admin;
	public ManageNewsPage news;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToUpdateFooterText")
	public void verifyTheUserIsAbleToUpdateFooterText() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String address = ExcelUtility.getStringData(1, 0, "ManageFooterPage");
		String email = ExcelUtility.getStringData(1, 1, "ManageFooterPage");
		String phone = ExcelUtility.getIntegerData(1, 2, "ManageFooterPage");
		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		admin = login.clickOnSignInButton();
		footer = login.clickOnFooterMoreinfoField();
		news = footer.clickOnActionField().clearTheAddressField().enterAddressOnAddressField(address)
				.clearTheEmailField().enterEmailOnEmailField(email).clearThePhoneField().enterPhoneOnPhoneField(phone)
				.clickOnUpdateField();
		boolean isalertFieldDisplayed = footer.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessage);

	}

}
