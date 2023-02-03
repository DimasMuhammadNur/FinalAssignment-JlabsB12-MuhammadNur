package qaautomation.december2022.task2Saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLogoutPage extends BaseAction {
	By burgerMenu = By.id("react-burger-menu-btn");
	By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
	
	public BaseLogoutPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void sideBurgerMenu() {
		ClickAndWait(burgerMenu);
	}
	
	public void logout() {
		ClickAndWait(logoutButton);
	}
}
