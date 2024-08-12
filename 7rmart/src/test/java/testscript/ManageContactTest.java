package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageContactPage;

public class ManageContactTest extends Base {
	@Test
	public void verifyTheUserIsAbleToUpdateContact() {
		String username="admin";
		String password="admin";
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.enterUsernameOnUsernameField(username);
		managecontactpage.enterPasswordOnPasswordField(password);
		managecontactpage.clickOnSignInButton();
		managecontactpage.clickOnMoreinfoField();
		managecontactpage.clickOnActionField();
		managecontactpage.clearThePhoneField();
		managecontactpage.enterPhoneNumberOnPhoneField();
		managecontactpage.clearTheEmailField();
		managecontactpage.enterEmailOnEmailField();
		managecontactpage.clearTheAddressField();
		managecontactpage.enterAddressOnAddressField();
		managecontactpage.clearTheDeliveryTimeField();
		managecontactpage.enterDeliveryTimeOnDeliveryTimeField();
		managecontactpage.clearTheDeliverychargelimitField();
		managecontactpage.enterDeliverychargelimitOnDeliverychargelimitField();
		managecontactpage.clickOnupdateField();
		boolean isalertfielddisplayed= managecontactpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert field is not displayed when user click on update button");
	}

}
