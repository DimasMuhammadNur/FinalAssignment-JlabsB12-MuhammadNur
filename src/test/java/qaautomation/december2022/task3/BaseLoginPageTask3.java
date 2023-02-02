package qaautomation.december2022.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLoginPageTask3 extends BaseActionTask3 {
	By inputMail = By.id("login");
	By btnLoginMail = By.cssSelector(".material-icons-outlined.f36");
	
	public BaseLoginPageTask3(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void inputMail(String emailInput) {
		setText(inputMail, emailInput);
	}
	
	public void loginButton() {
		ClickAndWait(btnLoginMail);
	}
}
