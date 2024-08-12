package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement MoreInfoField;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a")
	WebElement newField;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminusernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminpasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypeField;
	@FindBy(xpath = "//div[@class='card-footer center']//child::button")
	WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertField;

	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signinField.click();
	}

	public void clickOnMoreinfoField() {
		MoreInfoField.click();
	}

	public void clickOnNewField() {
		newField.click();
	}

	public void enterUserNameOnAdminUsernameField() {
		adminusernameField.sendKeys("ERIC Thomas C");
	}

	public void enterPasswordOnAdminPasswordField() {
		adminpasswordField.sendKeys("9876");
	}

	public void selectUserTypeField() {
		Select user = new Select(usertypeField);
		user.selectByIndex(1);

	}

	public void clickOnSaveField() {
		saveField.click();
	}

	public boolean isAlertfieldDisplayed() {
		return AlertField.isDisplayed();
	}
}
