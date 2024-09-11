package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement MoreinfoField;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss' and @role='button' and @class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement actionField;
	@FindBy(xpath = "// textarea[@placeholder='Enter the Address']")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//button[@name='Update' and @type='submit']")
	WebElement updateField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertField;

	public ManageFooterTextPage clickOnMoreinfoField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, MoreinfoField);
		return this;
	}

	public ManageFooterTextPage clickOnActionField() {

		actionField.click();
		return this;
	}

	public ManageFooterTextPage enterAddressOnAddressField(String address) {
		addressField.sendKeys(address);
		return this;
	}

	public ManageFooterTextPage enterEmailOnEmailField(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public ManageFooterTextPage enterPhoneOnPhoneField(String phone) {
		phoneField.sendKeys(phone);
		return this;
	}

	public ManageNewsPage clickOnUpdateField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScroll(driver);
		pageutility.javaSriptClick(driver, updateField);
		return new ManageNewsPage(driver);

	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility = new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);

	}

	public ManageFooterTextPage clearThePhoneField() {
		phoneField.clear();
		return this;
	}

	public ManageFooterTextPage clearTheEmailField() {
		emailField.clear();
		return this;
	}

	public ManageFooterTextPage clearTheAddressField() {
		addressField.clear();
		return this;
	}

}
