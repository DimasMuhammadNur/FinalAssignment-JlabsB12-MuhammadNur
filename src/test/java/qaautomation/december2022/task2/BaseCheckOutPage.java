package qaautomation.december2022.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCheckOutPage extends BaseAction {
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By zipPostal = By.id("postal-code");
	By continueBtn = By.id("continue");
	
	public BaseCheckOutPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void inputFirstname(String FirstnameInput) {
		setText(firstName, FirstnameInput);
	}
	
	public void inputlastName(String LastnameInput) {
		setText(lastName, LastnameInput);
	}
	
	public void inputPostalCode(String PostalCodeInput) {
		setText(zipPostal, PostalCodeInput);
	}
	
	public void continueButton() {
		ClickAndWait(continueBtn);
	}
}
