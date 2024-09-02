package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToCreateNews")
	public void verifyTheUserIsAbleToCreateNews() throws IOException {
		//String username = "admin";
		//String password = "admin";
		//String news="wayanad landslides";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		String news=ExcelUtility.getStringData(1, 0, "ManageNewsPage");

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.enterUsernameOnUsernameField(username);
		managenewspage.enterPasswordOnPasswordField(password);
		managenewspage.clickOnSignInButton();
		managenewspage.clickOnMoreinfoField();
		managenewspage.clickOnsNewField();
		managenewspage.enterTheNewsOnEnterNewsField(news);
		managenewspage.clickOnSaveField();
		boolean isalertFieldDisplayed = managenewspage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert  is not displayed when user click on save button");

	}

}
