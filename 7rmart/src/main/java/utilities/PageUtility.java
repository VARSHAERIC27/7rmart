package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void javaSriptClick(WebDriver  driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void javaScriptScroll(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
	}
	public void javaScriptScrollToEnd(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

    }
	public void acceptAlert(WebDriver driver) {
		//String alerttext=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

	}
	public void dismissAlert(WebDriver driver) {
		//String alerttext=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();

	}
	public void selectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
		}
	public void selectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);

	}
	public void MoveToElementAction(WebDriver driver,WebElement drag) {
		Actions action =new Actions(driver);
		action.moveToElement(drag);
	}
	public void rightClickAction(WebDriver driver,WebElement drag) {
		Actions action =new Actions(driver);
		action.contextClick(drag);

		
	}
	public void doubleClickAction(WebDriver driver,WebElement drag) {
		Actions action =new Actions(driver);
		action.doubleClick(drag);
		

	}
	public void dragAndDropAction(WebDriver driver,WebElement drag,WebElement drop) {
		Actions action =new Actions(driver);
		action.dragAndDrop(drag, drop);
	
	}
	public boolean isAnElementDisplayed(WebElement element) {
		return element.isDisplayed();
		
	}
	public boolean isAnElementEnabled(WebElement element) {
		return element.isEnabled();
		
	} 
	public boolean isAnElementSelected(WebElement element) {
		return element.isSelected();
		
	} 
	public void frameHandling(WebDriver driver,WebElement iframe) {
		driver.switchTo().frame(iframe);

		
	}

}
