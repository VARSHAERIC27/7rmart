package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

	public AdminUserPage clickOnMoreinfoField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, MoreInfoField);
		return this;

		// MoreInfoField.click();
	}

	public AdminUserPage clickOnNewField() {
		newField.click();
		return this;
	}

	public AdminUserPage enterUserNameOnAdminUsernameField(String adminusername) {
		adminusernameField.sendKeys(adminusername);
		return this;
	}

	public AdminUserPage enterPasswordOnAdminPasswordField(String adminpassword) {
		adminpasswordField.sendKeys(adminpassword);
		return this;
	}

	public AdminUserPage selectUserTypeField() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(usertypeField, 1);
		return this;

	}

	public ManageContactPage clickOnSaveField() {
		saveField.click();
		return new ManageContactPage(driver);
}

	public boolean isAlertfieldDisplayed() {
		PageUtility pageutility = new PageUtility();
		return pageutility.isAnElementDisplayed(AlertField);

	}
}
