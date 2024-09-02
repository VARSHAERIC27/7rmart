package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToChangeTheStatus")
	public void verifyTheUserIsAbleToChangeTheStatus() throws IOException {
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.enterUsernameOnUsernameField(username);
		subcategorypage.enterPasswordOnPasswordField(password);
		subcategorypage.clickOnSignInButton();
		subcategorypage.clickOnMoreInfoField();
		subcategorypage.clickOnStatusField();
		boolean isalertfielddisplayed=subcategorypage.isAlertFieldDisplayed();
		Assert.assertTrue(isalertfielddisplayed, "alert is not displayed when user click on statusfield");
	}
	@Test(retryAnalyzer=retry.Retry.class,description="verifyTheUserIsAbleToAddNewSubCategory")
	public void verifyTheUserIsAbleToAddNewSubCategory() throws IOException  {
		//String username="admin";
		//String password="admin";
		//String subcategory="goldFanfast";
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	    String password=ExcelUtility.getStringData(1, 1, "LoginPage");	
	    String subcategory=ExcelUtility.getStringData(1, 0, "SubCategoryPage");
		
		SubCategoryPage subcategorynewPage=new SubCategoryPage(driver);
		subcategorynewPage.enterUsernameOnUsernameField(username);
		subcategorynewPage.enterPasswordOnPasswordField(password);
		subcategorynewPage.clickOnSignInButton();
		subcategorynewPage.clickOnMoreInfoField();
		subcategorynewPage.clickOnNewField();
		subcategorynewPage.selectOncategoryField();
		subcategorynewPage.enterSubcategoryOnSubCategoryField(subcategory);
		subcategorynewPage.chooseFileOnImageField();
		//PageUtility pageutility=new PageUtility();
		//pageutility.javaSriptClick(driver, saveField);
        subcategorynewPage.clickOnSaveField();
		boolean isAlertFieldDisplayed=subcategorynewPage.isAlertFieldDisplayed();
		Assert.assertTrue(isAlertFieldDisplayed, "alert not displayed");
	

}
}
