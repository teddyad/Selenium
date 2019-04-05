package craftsvilla.generic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class BasePage {
	
	public WebDriver driver = null;
	public Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyTitle(String expected_title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String actual_title = null;
		
		try {
			wait.until(ExpectedConditions.titleIs(expected_title));
			actual_title = driver.getTitle();
			
			Assert.assertEquals(actual_title, expected_title);
			log.info(actual_title + " and " + expected_title + " matched");
		} catch (Exception exception) {
			log.error(expected_title + " and " + actual_title + " didn't match: " + exception);
		}
	}
	
	
	public void verifyElementPresent(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info(element + " if found");
		} catch(Exception exception) {
			log.error(element + " is not found!");
		}
	} 
}
