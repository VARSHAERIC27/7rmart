
package pages;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement moreinfoField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")
	WebElement NewField;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement EnterNewsField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement SaveField;
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
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScroll(driver);
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaSriptClick(driver, moreinfoField);
		
	}

	public void clickOnsNewField() {
		NewField.click();
	}

	public void enterTheNewsOnEnterNewsField(String news) {
		EnterNewsField.sendKeys(news);
	}

	public void clickOnSaveField() {
		SaveField.click();
	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);
	}

}
