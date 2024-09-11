package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinField;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement adminimageField;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertField;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	WebElement contactmoreinfoField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement FooterMoreinfoField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement newsmoreinfoField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
	WebElement manageproductField;

	public LoginPage enterUsername(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUserPage clickOnSignInButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, signinField);
		signinField.click();
		return new AdminUserPage(driver);
	}
	
	public ManageContactPage clickOncontactMoreinfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaSriptClick(driver, newsmoreinfoField);
		return new ManageContactPage(driver);

		
		//moreinfoField.click();
	}
	public ManageFooterTextPage clickOnFooterMoreinfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, FooterMoreinfoField);
		//MoreinfoField.click();
		return new ManageFooterTextPage(driver);
	}
	public ManageNewsPage clickOnnewsMoreinfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScroll(driver);
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, newsmoreinfoField);
		return new ManageNewsPage(driver);
		
	}
	public ManageProductPage clickOnManageProductField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, manageproductField);
		//manageproductField.click();
		return new ManageProductPage(driver);
	}

	public boolean isHomePageLoaded() {
		PageUtility pageutility = new PageUtility();
		return pageutility.isAnElementDisplayed(adminimageField);

	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility = new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);

	}

}
