package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogOutPage {
	WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-angle-left right']//parent::p)[5]")
	WebElement settingsField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logoutField;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement logintext;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement adminimageField;

	public LogOutPage clickOnAdminImageField() {
		adminimageField.click();
		return this;
	}

	public LogOutPage clickOnSettingsField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);

		settingsField.click();
		return this;
	}

	public LogOutPage clickOnLogOutField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, logoutField);
		return this;

	}

	public String getTextFromLogOutField() {
		return logintext.getText();
	}

}
