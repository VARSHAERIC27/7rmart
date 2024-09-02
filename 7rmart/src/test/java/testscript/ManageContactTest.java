package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToUpdateContact")
	public void verifyTheUserIsAbleToUpdateContact() throws IOException {
		//String username="admin";
		//String password="admin";
		//String phone="1234567890";
		//String email="abc@gmail.com";
		//String address="youth nagar,kerala";
		//String time="5 pm";
		//String charge="100";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	    String phone=ExcelUtility.getIntegerData(1, 0, "ManageContactPage");
		String email=ExcelUtility.getStringData(1, 1, "ManageContactPage");
		String address=ExcelUtility.getStringData(1, 2, "ManageContactPage");
		String time=ExcelUtility.getStringData(1, 3, "ManageContactPage");
		String charge=ExcelUtility.getIntegerData(1, 4, "ManageContactPage");

		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.enterUsernameOnUsernameField(username);
		managecontactpage.enterPasswordOnPasswordField(password);
		managecontactpage.clickOnSignInButton();
		managecontactpage.clickOnMoreinfoField();
		managecontactpage.clickOnActionField();
		managecontactpage.clearThePhoneField();
		managecontactpage.enterPhoneNumberOnPhoneField(phone);
		managecontactpage.clearTheEmailField();
		managecontactpage.enterEmailOnEmailField(email);
		managecontactpage.clearTheAddressField();
		managecontactpage.enterAddressOnAddressField(address);
		managecontactpage.clearTheDeliveryTimeField();
		managecontactpage.enterDeliveryTimeOnDeliveryTimeField(time);
		managecontactpage.clearTheDeliverychargelimitField();
		managecontactpage.enterDeliverychargelimitOnDeliverychargelimitField(charge);
		managecontactpage.clickOnupdateField();
		boolean isalertfielddisplayed= managecontactpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert field is not displayed when user click on update button");
	}

}
