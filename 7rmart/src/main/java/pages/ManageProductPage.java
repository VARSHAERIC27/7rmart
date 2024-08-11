package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinField;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageproductField;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
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

	public void clickOnManageProductField() {
		manageproductField.click();
	}

	public void clickOnDeleteField() {
		deleteField.click();
		driver.switchTo().alert().accept();
	}

	public boolean isAlertFieldDisplayed() {
		return alertField.isDisplayed();
	}
}
