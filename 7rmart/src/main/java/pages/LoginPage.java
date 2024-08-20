package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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

	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signinField.click();
	}

	public boolean isHomePageLoaded() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(adminimageField);

	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);


	}

}
