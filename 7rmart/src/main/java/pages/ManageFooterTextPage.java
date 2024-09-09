package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement MoreinfoField;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss' and @role='button' and @class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement actionField;
	@FindBy(xpath = "// textarea[@placeholder='Enter the Address']" )
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//button[@name='Update' and @type='submit']")
	WebElement updateField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertField;
	
	public void clickOnMoreinfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, MoreinfoField);
		//MoreinfoField.click();
	}
	public void clickOnActionField() {
		
		actionField.click();
	}
	public void enterAddressOnAddressField(String address) {
		addressField.sendKeys(address);
	}
	public void enterEmailOnEmailField(String email) {
		emailField.sendKeys(email);
	}
	public void enterPhoneOnPhoneField(String phone) {
		phoneField.sendKeys(phone);
	}
	public void clickOnUpdateField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScroll(driver);
		//pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, updateField);

		//updateField.click();
	}
	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);

	}
	public void clearThePhoneField() {
		phoneField.clear();
	}
	public void clearTheEmailField() {
		emailField.clear();
	}
	public void clearTheAddressField() {
		addressField.clear();
	}
	
	
	

}
