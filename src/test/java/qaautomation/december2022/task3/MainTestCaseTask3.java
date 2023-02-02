package qaautomation.december2022.task3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import qaautomation.december2022.Utility;


public class MainTestCaseTask3 extends BaseDriverTask3{
	BaseLoginPageTask3 loginMailPage = new BaseLoginPageTask3(driver, explicitWait);
	
	String email = "automationtest";
	String password = "secret_sauce";
	
	
	//TestCase01 E2E Transaction Success
	@Test
	public void testSuccessLogin() {
		//Code contoh untuk HardWait
		Utility.hardWait(1);
		//Login
		loginMailPage.inputMail(email);
		loginMailPage.loginButton();
		driver.get().switchTo().frame("ifinbox");
		WebElement elementMail = driver.get().findElement(By.tagName("button"));
		elementMail.click();
		driver.get().switchTo().defaultContent();
		
		driver.get().switchTo().frame("ifmail");
		WebElement getBodyMail = driver.get().findElement(By.xpath(" (//p)[2]"));
		//WebElement getBodyMail = driver.get().findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[1]"));
		System.out.println(getBodyMail.getText());
		driver.get().switchTo().defaultContent();
		Utility.hardWait(3);		
		
		//driver.get().findElement(By.xpath("(//button[@class='lm'])[2]")).click();
		//driver.get().findElement(By.cssSelector("main[class='yscrollbar']")).sendKeys();
		//driver.get().switchTo().frame(driver.get().findElement(By.cssSelector("main[class='yscrollbar']")));
		//String actualTitleMail = driver.get().findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[1]")).getText();
		//String expectedTitleMail = ("Thanks for connecting!");
		//Assert.assertTrue(actualTitleMail.contains(expectedTitleMail));
		//Wait for succesfully loaded Hompage and Click on 1 Product
		
	}
}
