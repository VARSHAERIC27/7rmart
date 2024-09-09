package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToCreateNews")
	public void verifyTheUserIsAbleToCreateNews() throws IOException {
		// String username = "admin";
		// String password = "admin";
		// String news="wayanad landslides";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickOnMoreinfoField();
		managenewspage.clickOnsNewField();
		managenewspage.enterTheNewsOnEnterNewsField(news);
		managenewspage.clickOnSaveField();
		boolean isalertFieldDisplayed = managenewspage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertForManageNews);
	}

}
