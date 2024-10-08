package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='nav-link']")
	WebElement moreinfoField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")
	WebElement NewField;
	@FindBy(xpath = "//input[@placeholder='Enter the Category' and @id='category']")
	WebElement categoryField;
	@FindBy(xpath = "(//span[text()='discount'])[1]")
	WebElement selectgroupField;
	@FindBy(xpath = "(//ul[@class='ms-list'])[2]")
	WebElement dropField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageField;
	@FindBy(xpath = "(//label[@class='radio-inline']//child::input)[1]")
	WebElement topmenuField;
	@FindBy(xpath = "(//label[@class='radio-inline']//child::input)[3]")
	WebElement leftmenuField;
	@FindBy(xpath = "//button[text()='Save'] ")
	WebElement savefield;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertField;

	public ManageCategoryPage clickOnMoreinfoField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, moreinfoField);
		return this;

	}

	public ManageCategoryPage clickOnNewField() {
		NewField.click();
		return this;

	}

	public ManageCategoryPage enterTheCategoryOnCategoryField(String category) {
		categoryField.sendKeys(category);
		return this;
	}

	public ManageCategoryPage selectGroupFromSelectGroupField() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, selectgroupField);
		pageutility.javaScriptScrollToEnd(driver);
		return this;
	}

	public ManageCategoryPage imageField() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageField, Constants.IMAGE);
		return this;

	}

	public ManageCategoryPage clickOnTopMenu() {
		topmenuField.click();
		return this;
	}

	public ManageCategoryPage clickOnLeftMenu() {
		leftmenuField.click();
		return this;
	}

	public ManageCategoryPage clickOnSaveField() {
		savefield.click();
		return this;
	}

	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility = new PageUtility();
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForAlertToBeVisible(driver);
		return pageutility.isAnElementDisplayed(alertField);

	}

}
