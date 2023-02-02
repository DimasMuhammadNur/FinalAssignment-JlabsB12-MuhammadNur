package qaautomation.december2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	By username = By.id("username");
	By password = By.id("password");
	By btnClick = By.xpath("//button[@type='submit']");
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
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
