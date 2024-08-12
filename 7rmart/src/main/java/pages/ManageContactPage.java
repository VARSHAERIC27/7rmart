package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinField;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement moreinfoField;
	@FindBy(xpath = "//i[@class='fas fa-edit']//parent::a")
	WebElement actionField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailField;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliverytimeField;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliverychargelimitField;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info' and @name='Update']")
	WebElement updateField;
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

	public void clickOnMoreinfoField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", moreinfoField);
		//moreinfoField.click();
	}

	public void clickOnActionField() {
		actionField.click();
	}

	public void enterPhoneNumberOnPhoneField() {
		phoneField.sendKeys("1234567");

	}

	public void enterEmailOnEmailField() {
		EmailField.sendKeys("abcn@gmail.com");

	}

	public void enterAddressOnAddressField() {
		addressField.sendKeys("youth nagar,kerala");
	}

	public void enterDeliveryTimeOnDeliveryTimeField() {
		deliverytimeField.sendKeys("5 pm");
	}

	public void enterDeliverychargelimitOnDeliverychargelimitField() {
		deliverychargelimitField.sendKeys("100");
	}

	public void clickOnupdateField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",updateField );
		//updateField.click();
	}

	public boolean isAlertFieldDisplayed() {
		return alertField.isDisplayed();
	}
	public void clearThePhoneField() {
		phoneField.clear();
	}
	public void clearTheEmailField() {
		EmailField.clear();
	}
	public void clearTheAddressField() {
		addressField.clear();
	}

	public void clearTheDeliveryTimeField() {
		deliverytimeField.clear();
	}
	public void clearTheDeliverychargelimitField() {
		deliverychargelimitField.clear();
	}




}
