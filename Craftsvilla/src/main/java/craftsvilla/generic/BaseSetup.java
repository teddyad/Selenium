package craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseSetup extends AutoConst{
	
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	@Parameters("browser")
	@BeforeMethod
	public void launchApplication(String browser) {
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty(CHROME_DRIVER, CHROME_PATH);
			driver = new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("GECKO")) {
			System.setProperty(GECKO_DRIVER, GECKO_PATH);
			driver = new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty(IE_DRIVER, IE_PATH);
			driver = new InternetExplorerDriver();
		} else {
			Reporter.log("Invalid browser selection");
		}
		
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(APP_URL);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
