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
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage.clickOnManageProductField();
		manageproductpage.clickOnDeleteField();
		boolean isalertfielddisplayed = manageproductpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed,"alert  is not displayed when user gives confirmation on delete action");
	}

}
