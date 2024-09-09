package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToDeleteTheProduct")
	public void verifyTheUserIsAbleToDeleteTheProduct() throws IOException {
		// String username = "admin";
		// String password = "admin";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage.clickOnManageProductField();
		manageproductpage.clickOnDeleteField();
		boolean isalertfielddisplayed = manageproductpage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertForManageProduct);
	}

}
