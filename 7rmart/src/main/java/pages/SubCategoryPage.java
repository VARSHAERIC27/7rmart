package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
public class SubCategoryPage {
	WebDriver driver;
	public SubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='nav-link']")
	WebElement moreinfoField;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newField;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	WebElement categoryField;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement subcategoryField;
	@FindBy(xpath="//input[@id='main_img' and @ type='file']")
	WebElement imageField;
	@FindBy(xpath="//button[text()='Save' and @ type='submit']")
	WebElement saveField;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertField;
	@FindBy(xpath = "//span[@class='badge bg-warning' or @class='badge bg-success']")
	WebElement statusField;
	
	
	public void clickOnMoreInfoField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaSriptClick(driver, moreinfoField);
		//moreinfoField.click();
	}
	public void clickOnStatusField() {
		statusField.click();
	}

	public void clickOnNewField() {
		newField.click();
	}
	public void selectOncategoryField() {
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndex(categoryField, 3);
		
	}
	public void enterSubcategoryOnSubCategoryField(String subcategory)  {
		subcategoryField.sendKeys(subcategory);
		
		
	}
	
	public void chooseFileOnImageField()  {
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageField , Constants.IMAGE);
		
		
	}
	public void clickOnSaveField() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptScrollToEnd(driver);
		pageutility.javaScriptScroll(driver);
		pageutility.javaSriptClick(driver, saveField);
        //saveField.click();
	}
	public boolean isAlertFieldDisplayed() {
		PageUtility pageutility=new PageUtility();
		return pageutility.isAnElementDisplayed(alertField);

	}
	
	
	

}
