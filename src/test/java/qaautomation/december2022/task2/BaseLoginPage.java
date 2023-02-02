package qaautomation.december2022.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLoginPage extends BaseAction {
	By username = By.id("user-name");
	By password = By.id("password");
	By btnClick = By.id("login-button");
	
	public BaseLoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void inputUsername(String usernameInput) {
		setText(username, usernameInput);
	}
	
	public void inputPassword(String passwordInput) {
		setText(password, passwordInput);
	}
	
	public void loginButton() {
		ClickAndWait(btnClick);
	}
}
