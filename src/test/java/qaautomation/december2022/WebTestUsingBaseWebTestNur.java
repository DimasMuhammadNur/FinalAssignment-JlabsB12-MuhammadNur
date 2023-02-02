package qaautomation.december2022;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import qaautomation.december2022.pages.LoginPage;
import qaautomation.december2022.pages.ProfilePage;

public class WebTestUsingBaseWebTestNur extends BaseWebTestNur{
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	String username = "tomsmith";
	String passwordString = "SuperSecretPassword";
	
	
	//TestCase01 Login Logout with valid credential success
	@Test
	public void testSuccessLogin() {
		//Code contoh untuk explicit Wait
		//WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		//Code diatas ini kena error java.lang.ClassCastException: java.lang.ThreadLocal cannot be cast to org.openqa.selenium.WebDriver
		
		//Code contoh untuk HardWait
		Utility.hardWait(3);
		//LoginBaru
		loginPage.inputUsername(username);
		loginPage.inputPassword(passwordString);
		loginPage.loginButton();
		
		//Login
		//driver.get().findElement(By.id("username")).sendKeys("tomsmith");
		//driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		//driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		//Profile Page Baru
		String actualText = profilePage.getProfileText();
		
		//Profile 
		//String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = ("You logged into a secure area!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	//TestCase02 Invalid Username
	@Test
	public void testInvalidUsername() {
		driver.get().findElement(By.id("username")).sendKeys("Muhammad Nur");
		driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = ("Your username is invalid!");
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	
	//TestCase03 Invalid Password
	@Test
	public void testInvalidPassword() {
		driver.get().findElement(By.id("username")).sendKeys("tomsmith");
		driver.get().findElement(By.name("password")).sendKeys("Muhammad Nur");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = ("Your password is invalid!");
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
}
