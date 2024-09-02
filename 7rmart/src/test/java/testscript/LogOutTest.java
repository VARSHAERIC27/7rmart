package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToLogOut",groups= {"Regression"})
	public void verifyTheUserIsAbleToLogOut() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	    LogOutPage logoutpage=new LogOutPage(driver);
	    logoutpage.enterUsernameOnUsernameField(username);
	    logoutpage.enterPasswordOnPasswordField(password);
	    logoutpage.clickOnSignInButton();
	    logoutpage.clickOnAdminImageField();
	    //logoutpage.clickOnSignInButton();

	    //logoutpage.clickOnSettingsField();
	    logoutpage.clickOnLogOutField();
	  String logintext=  logoutpage.getTextFromLogOutField();
	  Assert.assertEquals(logintext, "Sign in to start your session");
	  	
		
	}

}
