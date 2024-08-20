package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test
	public void verifyTheUserIsAbleToAddNewCategory() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		String category=ExcelUtility.getStringData(1, 0, "ManageCategoryPage");
		ManageCategoryPage managecategoryPage=new ManageCategoryPage(driver);
		managecategoryPage.enterUsernameOnUsernameField(username);
		managecategoryPage.enterPasswordOnPasswordField(password);
		managecategoryPage.clickOnSignInButton();
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
		Assert.assertTrue(isalertFieldDisplayed, "not displayed");

	}

}
