package qaautomation.december2022.task2Saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction extends BaseDriver{
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); 
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BaseAction(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	public void ClickAndWait(By locator) {
		driver.get().findElement(locator).click();
	}
	
	public void setText(By locator, String text) {
		 driver.get().findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		 return driver.get().findElement(locator).getText();
	}
	
}
