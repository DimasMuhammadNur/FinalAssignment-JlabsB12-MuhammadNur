package qaautomation.december2022.task3Yopmail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverTask3 {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); 
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(5)));
		driver.get().get("https://yopmail.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}

}
