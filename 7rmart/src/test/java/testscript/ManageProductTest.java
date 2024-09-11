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
import pages.ManageProductPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	public ManageContactPage contact;
	public LoginPage login;
	public ManageFooterTextPage footer;
	public AdminUserPage admin;
	public ManageNewsPage newspage;
	public ManageProductPage product;
	public SubCategoryPage SubCategory;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToDeleteTheProduct")
	public void verifyTheUserIsAbleToDeleteTheProduct() throws IOException {
		// String username = "admin";
		// String password = "admin";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		 login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		//loginPage.enterPasswordOnPasswordField(password);
		admin=login.clickOnSignInButton();
		product=login.clickOnManageProductField();
		SubCategory= product.clickOnDeleteField();
		//ManageProductPage manageproductpage = new ManageProductPage(driver);
		//manageproductpage.clickOnManageProductField();
		//manageproductpage.clickOnDeleteField();
		boolean isalertfielddisplayed = product.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertForManageProduct);
	}

}
