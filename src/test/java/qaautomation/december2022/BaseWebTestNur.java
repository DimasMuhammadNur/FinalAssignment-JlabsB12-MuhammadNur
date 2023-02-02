package qaautomation.december2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTestNur {
	//WebDriver driver digunakan untuk navigate to Browser
	//Untuk code "WebDriver Driver" ini digunakan untuk 1 TestCase
	//WebDriver driver;
	
	//Untuk testsuite menggunakan hal berikut yaitu thread local
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); 
	//Terakhir belajar sampai sini 
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		//Code dibawah ini get chrome driver browser untuk 1 Test Case atau tidak pakai test suite
		//driver = new ChromeDriver();
		driver.set(new ChromeDriver());
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(5)));
		//Code dibawah ini untuk navigate to url jika tidak menggunakan test suite
		//driver.get("https://the-internet.herokuapp.com/login");
		driver.get().get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		//Code dibawah ini untuk close browser jika tidak menggunakan test suite
		//driver.quit();
		
		driver.get().quit();
	}
}
