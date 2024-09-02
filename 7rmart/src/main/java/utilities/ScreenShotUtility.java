package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
public void getScreenShot(WebDriver driver,String failedTestCase) throws IOException {
	TakesScreenshot scrShot=(TakesScreenshot) driver; //TakesScreenshot--interface
	File screenShot= scrShot.getScreenshotAs(OutputType.FILE);//file--class
	String timeStamp = new SimpleDateFormat("DD_MM_YYYY_hh_mm_ss").format(new Date());
	File f1= new File(System.getProperty("user.dir")+"//OutputScreenshot");
	if(!f1.exists()) {
		f1.mkdirs();
	}
	String destination= System.getProperty("user.dir")+"//OutputScreenshot//"+failedTestCase+timeStamp+".png";
	File finaldestinaton=new File(destination);
	FileHandler.copy(screenShot, finaldestinaton);
}
}
