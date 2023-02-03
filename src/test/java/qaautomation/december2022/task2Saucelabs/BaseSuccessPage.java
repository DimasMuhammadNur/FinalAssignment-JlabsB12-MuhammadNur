package qaautomation.december2022.task2Saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSuccessPage extends BaseAction {
	By titlePage = By.xpath("//span[@class='title']");
	By title = By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']");
	By successDesc = By.xpath("//div[@class='complete-text']");
	By successImage = By.xpath("//img[@alt='Pony Express']");
	By backBtn = By.id("back-to-products");
	Boolean hasil;
	
	public BaseSuccessPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public String getTitlePage() {
		return getText(titlePage); 
	}
	
	public String getTitleDesc() {
		return getText(title); 
	}
	
	public String getSuccessDesc() {
		return getText(successDesc); 
	}
	
	public void backToHome() {
		ClickAndWait(backBtn);
	}
	
	public void getSuccessImage() {
		WebElement imageSuccess = driver.get().findElement(successImage);
		if (imageSuccess.isDisplayed()) {
			System.out.println("Gambar transaksi sukses muncul");
		}
		else {
			System.out.println("Gambar Transaksi Sukses tidak muncul");
		}
	}
}
