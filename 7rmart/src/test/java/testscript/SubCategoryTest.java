package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToChangeTheStatus")
	public void verifyTheUserIsAbleToChangeTheStatus() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnSignInButton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
        subcategorypage.clickOnMoreInfoField();
		subcategorypage.clickOnStatusField();
		boolean isalertfielddisplayed = subcategorypage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, Constants.AlertForSubCategory);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToAddNewSubCategory")
	public void verifyTheUserIsAbleToAddNewSubCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String subcategory = ExcelUtility.getStringData(1, 0, "SubCategoryPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickOnSignInButton();
		SubCategoryPage subcategorynewPage = new SubCategoryPage(driver);
		subcategorynewPage.clickOnMoreInfoField();
		subcategorynewPage.clickOnNewField();
		subcategorynewPage.selectOncategoryField();
		subcategorynewPage.enterSubcategoryOnSubCategoryField(subcategory);
		subcategorynewPage.chooseFileOnImageField();
		subcategorynewPage.clickOnSaveField();
		boolean isAlertFieldDisplayed = subcategorynewPage.isAlertFieldDisplayed();
		Assert.assertTrue(isAlertFieldDisplayed, Constants.AlertMessage);

	}
}
