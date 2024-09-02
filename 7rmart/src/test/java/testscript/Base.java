package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;

public class Base {
	WebDriver driver;
	public Properties properties;
	public ScreenShotUtility scrShot;
	public FileInputStream fileinputstream;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initiliseBrowser(String browser) throws Exception {
		try {
			properties=new Properties();
		    fileinputstream=new FileInputStream(Constants.CONFIGFILE);
		    properties.load(fileinputstream);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
	
		}
		else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}
		else {
			throw new Exception("incorrect browser");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			 scrShot=new ScreenShotUtility();
			 scrShot.getScreenShot(driver,iTestResult.getName());
		}
		driver.quit();
	}

}
