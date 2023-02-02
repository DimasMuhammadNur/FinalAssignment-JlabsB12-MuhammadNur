package qaautomation.december2022;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebTestNur {
	//Berikut ini adalah testing untuk membuka google chrome
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSuccessLogin() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String ExpectedText = ("You logged into a secure area!");
		//String ExpectedText2 = ("You logged into a secure area");
		Assert.assertTrue(actualText.contains(ExpectedText));
		//Code dibawah ini akan error karena actual dan expected tidak sesuai.
		//Assert.assertEquals(actualText, ExpectedText2);
	}
}
