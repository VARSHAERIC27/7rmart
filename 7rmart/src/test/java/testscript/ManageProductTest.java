package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;

public class ManageProductTest extends Base {
	@Test
	public void verifyTheUserIsAbleToDeleteTheProduct() {
		String username = "admin";
		String password = "admin";

		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage.enterUsernameOnUsernameField(username);
		manageproductpage.enterPasswordOnPasswordField(password);
		manageproductpage.clickOnSignInButton();
		manageproductpage.clickOnManageProductField();
		manageproductpage.clickOnDeleteField();
		boolean isalertfielddisplayed = manageproductpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed,"alert  is not displayed when user gives confirmation on delete action");
	}

}
