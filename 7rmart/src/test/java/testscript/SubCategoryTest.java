package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import pages.ManageNewsPage;
import pages.ManageProductPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public ManageContactPage contact;
	public LoginPage login;
	public ManageFooterTextPage footer;
	public AdminUserPage admin;
	public ManageNewsPage newspage;
	public ManageProductPage product;
	public SubCategoryPage subCategory;
	public LogOutPage logout;

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToChangeTheStatus")
	public void verifyTheUserIsAbleToChangeTheStatus() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		admin = login.clickOnSignInButton();
		subCategory = login.clickOnSubMoreInfoField();
		logout = subCategory.clickOnStatusField();
		boolean isalertfielddisplayed = subCategory.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertForSubCategory);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToAddNewSubCategory")
	public void verifyTheUserIsAbleToAddNewSubCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String subcategory = ExcelUtility.getStringData(1, 0, "SubCategoryPage");
		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		admin = login.clickOnSignInButton();
		subCategory = login.clickOnSubMoreInfoField();
		logout = subCategory.clickOnNewField().selectOncategoryField().enterSubcategoryOnSubCategoryField(subcategory)
				.chooseFileOnImageField().clickOnSaveField();
		boolean isAlertFieldDisplayed = subCategory.isAlertFieldDisplayed();
		Assert.assertTrue(isAlertFieldDisplayed, Constants.AlertMessage);

	}
}
