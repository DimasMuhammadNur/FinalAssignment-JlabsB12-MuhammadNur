package qaautomation.december2022.task2;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.december2022.Utility;

public class MainTestCase extends BaseDriver{
	BaseLoginPage loginPage = new BaseLoginPage(driver, explicitWait);
	BaseCheckOutPage checkOutPage = new BaseCheckOutPage(driver, explicitWait);
	BaseSuccessPage successPage = new BaseSuccessPage(driver, explicitWait);
	BaseLogoutPage logoutAction = new BaseLogoutPage(driver, explicitWait);
	
	
	String username = "standard_user";
	String password = "secret_sauce";
	String firstname = "muhammad";
	String lastname = "nur";
	String postalcode = "11840";
	
	WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2));
	
	//TestCase01 E2E Transaction Success
	@Test
	public void testCase1() {
		//WebDriverWait wait = new WebDriverWait(WebDriver) driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout-sidebar-link")));
		//Code contoh untuk HardWait
		//Utility.hardWait(3);
		//wait.until(ExpectedConditions.visibilityOf(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']"));
		//Login
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		
		loginPage.loginButton();
		//Wait for succesfully loaded Hompage and Click on 1 Product
		Utility.hardWait(2);
		driver.get().findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).click();
		//Verify Title Product
		String actualText = driver.get().findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
		String ExpectedText = ("Sauce Labs Bike Light");
		AssertJUnit.assertTrue(actualText.contains(ExpectedText));
		Utility.hardWait(2);
		//Add to cart and Click Cart
		String actualPrice = driver.get().findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
		driver.get().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.get().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		//Verify Item Name and Description equals
		String actualTitleCartPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expectedTitleCartPage = ("Sauce Labs Bike Light");
		AssertJUnit.assertTrue(actualTitleCartPage.contains(expectedTitleCartPage));
		String actualDescCartPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String expectedDescCartPage = ("A red light isn't the desired state in testing but it sure helps when riding your bike at night. "
				+ "Water-resistant with 3 lighting modes, 1 AAA battery included.");
		AssertJUnit.assertTrue(actualDescCartPage.contains(expectedDescCartPage));
		Utility.hardWait(2);
		//Verify Price equals
		String expectedEqualPrice = ("$9.99");
		AssertJUnit.assertEquals(actualPrice, expectedEqualPrice);
		driver.get().findElement(By.id("checkout")).click();
		Utility.hardWait(2);
		//Set Information for Checkout
		checkOutPage.inputFirstname(firstname);
		checkOutPage.inputlastName(lastname);
		checkOutPage.inputPostalCode(postalcode);
		checkOutPage.continueButton();
		Utility.hardWait(2);
		//Checkout Overview
		String actualTitleOverviewPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expectedTitleOverviewPage = ("Sauce Labs Bike Light");
		AssertJUnit.assertTrue(actualTitleOverviewPage.contains(expectedTitleOverviewPage));
		String actualDescOverviewPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String expectedDescOverviewPage = ("A red light isn't the desired state in testing but it sure helps when riding your bike at night. "
				+ "Water-resistant with 3 lighting modes, 1 AAA battery included.");
		AssertJUnit.assertTrue(actualDescOverviewPage.contains(expectedDescOverviewPage));
		String actualPaymentInfo = driver.get().findElement(By.xpath("//div[normalize-space()='SauceCard #31337']")).getText();
		String expectedPaymentInfo = ("SauceCard #31337");
		AssertJUnit.assertTrue(actualPaymentInfo.contains(expectedPaymentInfo));
		String actualShipmentInfo = driver.get().findElement(By.xpath("//div[normalize-space()='FREE PONY EXPRESS DELIVERY!']")).getText();
		String expectedShipmentInfo = ("FREE PONY EXPRESS DELIVERY!");
		AssertJUnit.assertTrue(actualShipmentInfo.contains(expectedShipmentInfo));
		driver.get().findElement(By.xpath("//div[@class='summary_tax_label']")).isDisplayed();
		String actualTotalPayment = driver.get().findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		String expectedTotalPayment = ("Total: $10.79");
		AssertJUnit.assertTrue(actualTotalPayment.contains(expectedTotalPayment));
		driver.get().findElement(By.id("finish")).click();
		Utility.hardWait(2);
		//Checkout Success Page
		String actualSuccessTransactionPage= successPage.getTitlePage();
		String expectedSuccessTransactionPage = ("CHECKOUT: COMPLETE!");
		AssertJUnit.assertTrue(actualSuccessTransactionPage.contains(expectedSuccessTransactionPage));
		String actualTitleDesc= successPage.getTitleDesc();
		String expectedTitleDesc = ("THANK YOU FOR YOUR ORDER");
		System.out.println("Actual: "+ actualTitleDesc);
		System.out.println("Expected: "+ expectedTitleDesc);
		AssertJUnit.assertTrue(actualTitleDesc.contains(expectedTitleDesc));
		String actualSuccessDesc= successPage.getSuccessDesc();
		String expectedSuccessDesc = ("Your order has been dispatched, and will arrive "
				+ "just as fast as the pony can get there!");
		System.out.println("Actual: "+ actualSuccessDesc);
		System.out.println("Expected: "+ expectedSuccessDesc);
		AssertJUnit.assertTrue(actualSuccessDesc.contains(expectedSuccessDesc));
		successPage.getSuccessImage();
		successPage.backToHome();
		Utility.hardWait(2);
		logoutAction.sideBurgerMenu();
		Utility.hardWait(2);
		logoutAction.logout();
		Utility.hardWait(2);
	}
	
	@Test
	public void testCase2() {
		//Code contoh untuk HardWait
		Utility.hardWait(3);
		//Login
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.loginButton();
		//Wait for succesfully loaded Hompage and Click on 1 Product, then click cart
		Utility.hardWait(2);
		driver.get().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.get().findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]")).click();
		//Verify Item Name and Description equals
		String actualTitleCartPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expectedTitleCartPage = ("Sauce Labs Bike Light");
		AssertJUnit.assertTrue(actualTitleCartPage.contains(expectedTitleCartPage));
		String actualDescCartPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String expectedDescCartPage = ("A red light isn't the desired state in testing but it sure helps when riding your bike at night. "
				+ "Water-resistant with 3 lighting modes, 1 AAA battery included.");
		AssertJUnit.assertTrue(actualDescCartPage.contains(expectedDescCartPage));
		Utility.hardWait(2);
		//Verify Price equals
		String actualPrice = driver.get().findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
		String expectedEqualPrice = ("$9.99");
		AssertJUnit.assertEquals(actualPrice, expectedEqualPrice);
		driver.get().findElement(By.id("checkout")).click();
		Utility.hardWait(2);
		//Set Information for Checkout
		checkOutPage.inputFirstname(firstname);
		checkOutPage.inputlastName(lastname);
		checkOutPage.inputPostalCode(postalcode);
		checkOutPage.continueButton();
		Utility.hardWait(2);
		//Checkout Overview
		String actualTitleOverviewPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expectedTitleOverviewPage = ("Sauce Labs Bike Light");
		AssertJUnit.assertTrue(actualTitleOverviewPage.contains(expectedTitleOverviewPage));
		String actualDescOverviewPage = driver.get().findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String expectedDescOverviewPage = ("A red light isn't the desired state in testing but it sure helps when riding your bike at night. "
				+ "Water-resistant with 3 lighting modes, 1 AAA battery included.");
		AssertJUnit.assertTrue(actualDescOverviewPage.contains(expectedDescOverviewPage));
		String actualPaymentInfo = driver.get().findElement(By.xpath("//div[normalize-space()='SauceCard #31337']")).getText();
		String expectedPaymentInfo = ("SauceCard #31337");
		AssertJUnit.assertTrue(actualPaymentInfo.contains(expectedPaymentInfo));
		String actualShipmentInfo = driver.get().findElement(By.xpath("//div[normalize-space()='FREE PONY EXPRESS DELIVERY!']")).getText();
		String expectedShipmentInfo = ("FREE PONY EXPRESS DELIVERY!");
		AssertJUnit.assertTrue(actualShipmentInfo.contains(expectedShipmentInfo));
		driver.get().findElement(By.xpath("//div[@class='summary_tax_label']")).isDisplayed();
		String actualTotalPayment = driver.get().findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		String expectedTotalPayment = ("Total: $10.79");
		AssertJUnit.assertTrue(actualTotalPayment.contains(expectedTotalPayment));
		driver.get().findElement(By.id("finish")).click();
		Utility.hardWait(2);
		//Checkout Success Page
		String actualSuccessTransactionPage= successPage.getTitlePage();
		String expectedSuccessTransactionPage = ("CHECKOUT: COMPLETE!");
		AssertJUnit.assertTrue(actualSuccessTransactionPage.contains(expectedSuccessTransactionPage));
		String actualTitleDesc= successPage.getTitleDesc();
		String expectedTitleDesc = ("THANK YOU FOR YOUR ORDER");
		System.out.println("Actual: "+ actualTitleDesc);
		System.out.println("Expected: "+ expectedTitleDesc);
		AssertJUnit.assertTrue(actualTitleDesc.contains(expectedTitleDesc));
		String actualSuccessDesc= successPage.getSuccessDesc();
		String expectedSuccessDesc = ("Your order has been dispatched, and will arrive "
				+ "just as fast as the pony can get there!");
		System.out.println("Actual: "+ actualSuccessDesc);
		System.out.println("Expected: "+ expectedSuccessDesc);
		AssertJUnit.assertTrue(actualSuccessDesc.contains(expectedSuccessDesc));
		successPage.getSuccessImage();
		successPage.backToHome();
		Utility.hardWait(2);
		logoutAction.sideBurgerMenu();
		Utility.hardWait(2);
		logoutAction.logout();
		Utility.hardWait(2);
	}
}
