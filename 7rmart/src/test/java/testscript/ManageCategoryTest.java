package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	public AdminUserPage admin;
	public ManageCategoryPage managecategory;
	public ManageContactPage contact;
	public LoginPage login;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToAddNewCategory")
	public void verifyTheUserIsAbleToAddNewCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String category = ExcelUtility.getStringData(1, 0, "ManageCategoryPage");
		 login=new LoginPage(driver);
		 login.enterUsername(username).enterPassword(password);
		 admin= login.clickOnSignInButton();
		//admin = new AdminUserPage(driver);
		//managecategory = admin.cl
		 //managecategory=login.clickOnMoreinfoField();
		contact = managecategory.clickOnMoreinfoField().clickOnNewField().enterTheCategoryOnCategoryField(category).selectGroupFromSelectGroupField().imageField().clickOnTopMenu().clickOnLeftMenu().clickOnSaveField();

		boolean isalertFieldDisplayed = managecategory.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessage);

	}

}
