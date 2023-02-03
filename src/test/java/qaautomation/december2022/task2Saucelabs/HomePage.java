package qaautomation.december2022.task2Saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseAction{
	By titleHomePage = By.xpath("//span[@class='title']");
	
	public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public String getProfileText() {
		return getText(titleHomePage); 
	}
}
