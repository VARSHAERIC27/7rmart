package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ManageContactTest extends Base {
	public LoginPage login;
	public AdminUserPage admin;
	public ManageContactPage contact;
	public ManageFooterTextPage footer;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToUpdateContact")
	public void verifyTheUserIsAbleToUpdateContact() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String phone = ExcelUtility.getIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.getStringData(1, 1, "ManageContactPage");
		String address = ExcelUtility.getStringData(1, 2, "ManageContactPage");
		String time = ExcelUtility.getStringData(1, 3, "ManageContactPage");
		String charge = ExcelUtility.getIntegerData(1, 4, "ManageContactPage");
		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		admin = login.clickOnSignInButton();
		contact = login.clickOncontactMoreinfoField();
		footer = contact.clickOnActionField().clearThePhoneField().enterPhoneNumberOnPhoneField(phone)
				.clearTheEmailField().enterEmailOnEmailField(email).clearTheAddressField()
				.enterAddressOnAddressField(address).clearTheDeliveryTimeField()
				.enterDeliveryTimeOnDeliveryTimeField(charge).clearTheDeliverychargelimitField()
				.enterDeliverychargelimitOnDeliverychargelimitField(charge).clickOnupdateField();
		boolean isalertfielddisplayed = contact.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertMessageForManageContact);
	}

}
