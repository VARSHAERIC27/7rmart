package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
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

	

	public ManageContactPage clickOnMoreinfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaSriptClick(driver, moreinfoField);
		return this;

		
		//moreinfoField.click();
	}

	public ManageContactPage clickOnActionField() {
		actionField.click();
		return this;
	}

	public ManageContactPage enterPhoneNumberOnPhoneField(String phone) {
		phoneField.sendKeys(phone);
		return this;

	}

	public ManageContactPage enterEmailOnEmailField(String email) {
		EmailField.sendKeys(email);
		return this;

	}

	public ManageContactPage enterAddressOnAddressField(String address) {
		addressField.sendKeys(address);
		return this;
	}

	public ManageContactPage enterDeliveryTimeOnDeliveryTimeField(String time) {
		deliverytimeField.sendKeys(time);
		return this;
	}

	public ManageContactPage enterDeliverychargelimitOnDeliverychargelimitField(String charge) {
		deliverychargelimitField.sendKeys(charge);
		return this;
	}

	public ManageFooterTextPage clickOnupdateField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaSriptClick(driver, updateField);
		return new ManageFooterTextPage(driver);

		
		//updateField.click();
	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);

	}
	public ManageContactPage clearThePhoneField() {
		phoneField.clear();
		return this;
	}
	public ManageContactPage clearTheEmailField() {
		EmailField.clear();
		return this;
	}
	public ManageContactPage clearTheAddressField() {
		addressField.clear();
		return this;
	}

	public ManageContactPage clearTheDeliveryTimeField() {
		deliverytimeField.clear();
		return this;
	}
	public ManageContactPage clearTheDeliverychargelimitField() {
		deliverychargelimitField.clear();
		return this;
	}




}
