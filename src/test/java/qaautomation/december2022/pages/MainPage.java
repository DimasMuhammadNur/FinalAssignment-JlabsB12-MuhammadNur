package qaautomation.december2022.pages;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import qaautomation.december2022.Utility;



public class MainPage extends BaseMainPage {
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	String username = "tomsmith";
	String invusername1 = "invalidtomsmith";
	String password = "SuperSecretPassword!";
	String invpassword1 = "SuperSecretPassword(!)";
	
	
	//TestCase01 Login Logout with valid credential success
	@Test
	public void testSuccessLogin() {
		//Code contoh untuk HardWait
		Utility.hardWait(3);
		//LoginBaru
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.loginButton();
		//Profile Page Baru
		String actualText = profilePage.getProfileText();
		String expectedText = ("You logged into a secure area!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	//TestCase02 Invalid Username
	@Test
	public void testInvalidUsername() {
		Utility.hardWait(3);
		//LoginBaru
		loginPage.inputUsername(invusername1);
		loginPage.inputPassword(password);
		loginPage.loginButton();
		//Profile Page Baru
		String actualText = profilePage.getProfileText();
		String expectedText = ("Your username is invalid!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	
	//TestCase03 Invalid Password
	@Test
	public void testInvalidPassword() {
		Utility.hardWait(3);
		//LoginBaru
		loginPage.inputUsername(username);
		loginPage.inputPassword(invpassword1);
		loginPage.loginButton();
		//Profile Page Baru
		String actualText = profilePage.getProfileText();
		String expectedText = ("Your password is invalid!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
}
