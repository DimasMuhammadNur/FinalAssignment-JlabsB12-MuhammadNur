package qaautomation.december2022.task3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class MainTestCaseTask3 extends BaseDriverTask3{
	BaseLoginPageTask3 loginMailPage = new BaseLoginPageTask3(driver, explicitWait);
	
	String email = "automationtest";
	
	@Test
	public void testCaseGetBodyMail2() {
		//Code contoh untuk HardWait
		Utility.hardWait(1);
		//Login
		loginMailPage.inputMail(email);
		loginMailPage.loginButton();
		driver.get().switchTo().frame("ifmail");
		WebElement getBodyMail = driver.get().findElement(By.id("mail"));
		System.out.println(getBodyMail.getText());
		driver.get().switchTo().defaultContent();
		Utility.hardWait(2);		
	}
}
