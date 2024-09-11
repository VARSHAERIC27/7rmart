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
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public ManageContactPage contact;
	public LoginPage login;
	public ManageFooterTextPage footer;
	public AdminUserPage admin;
	public ManageNewsPage newspage;
	public ManageProductPage product;
	@Test(retryAnalyzer = retry.Retry.class, description = "verifyTheUserIsAbleToCreateNews")
	public void verifyTheUserIsAbleToCreateNews() throws IOException {
		// String username = "admin";
		// String password = "admin";
		// String news="wayanad landslides";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		 login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		//loginPage.enterPasswordOnPasswordField(password);
		admin=login.clickOnSignInButton();
		newspage=login.clickOnnewsMoreinfoField();
		product=newspage.clickOnsNewField().enterTheNewsOnEnterNewsField(news).clickOnSaveField();
		/*ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickOnMoreinfoField();
		managenewspage.clickOnsNewField();
		managenewspage.enterTheNewsOnEnterNewsField(news);
		managenewspage.clickOnSaveField();*/
		boolean isalertFieldDisplayed = newspage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertFieldDisplayed, Constants.AlertForManageNews);
	}

}
