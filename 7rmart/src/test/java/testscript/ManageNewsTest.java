package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	@Test
	public void verifyTheUserIsAbleToCreateNews() {
		String username = "admin";
		String password = "admin";

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.enterUsernameOnUsernameField(username);
		managenewspage.enterPasswordOnPasswordField(password);
		managenewspage.clickOnSignInButton();
		managenewspage.clickOnMoreinfoField();
		managenewspage.clickOnsNewField();
		managenewspage.enterTheNewsOnEnterNewsField();
		managenewspage.clickOnSaveField();
		boolean isalertFieldDisplayed = managenewspage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, "alert  is not displayed when user click on save button");

	}

}
