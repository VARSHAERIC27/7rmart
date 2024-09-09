package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToAddNewCategory")
	public void verifyTheUserIsAbleToAddNewCategory() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		String category=ExcelUtility.getStringData(1, 0, "ManageCategoryPage");
		LoginPage loginPage=new LoginPage(driver);
	    loginPage.enterUsernameOnUsernameField(username);
	    loginPage.enterPasswordOnPasswordField(password);
	    loginPage.clickOnSignInButton();
		ManageCategoryPage managecategoryPage=new ManageCategoryPage(driver);
		managecategoryPage.clickOnMoreinfoField();
		managecategoryPage.clickOnNewField();
		managecategoryPage.enterTheCategoryOnCategoryField(category);
		managecategoryPage.selectGroupFromSelectGroupField();
		managecategoryPage.imageField();
		managecategoryPage.clickOnTopMenu();
		managecategoryPage.clickOnLeftMenu();
		managecategoryPage.clickOnSaveField();
		managecategoryPage.isAlertFieldDisplayed();
		boolean isalertFieldDisplayed = managecategoryPage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertMessage);

	}

}
