package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SubCategoryPage;

public class SubCategoryTest extends Base {
	@Test
	public void verifyTheUserIsAbleToChangeTheStatus() {
		String username="admin";
		String password="admin";
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.enterUsernameOnUsernameField(username);
		subcategorypage.enterPasswordOnPasswordField(password);
		subcategorypage.clickOnSignInButton();
		subcategorypage.clickOnMoreinfoField();
		subcategorypage.clickOnStatusField();
		boolean isalertfielddisplayed=subcategorypage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert is not displayed when user click on statusfield");
	}

}
