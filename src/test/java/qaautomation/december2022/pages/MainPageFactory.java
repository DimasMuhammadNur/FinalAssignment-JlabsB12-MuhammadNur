package qaautomation.december2022.pages;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import qaautomation.december2022.Utility;



public class MainPageFactory extends BaseMainPageFactory {
	//LoginPage loginPage = new LoginPage(driver, explicitWait);
	//ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	String username = "tomsmith";
	String invusername1 = "invalidtomsmith";
	String password = "SuperSecretPassword!";
	String invpassword1 = "SuperSecretPassword(!)";
	
	
	//TestCase01 Login Logout with valid credential success
	@Test
	public void testSuccessLogin() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//Code contoh untuk HardWait
		Utility.hardWait(3);
		//LoginBaru
		loginPageFactory.inputUsername(username);
		loginPageFactory.inputPassword(password);
		loginPageFactory.loginButton();
		//Profile Page Baru
		String actualText = profilePageFactory.getProfileText();
		String expectedText = ("You logged into a secure area!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	//TestCase02 Invalid Username
	@Test
	public void testInvalidUsername() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		Utility.hardWait(3);
		//LoginBaru
		loginPageFactory.inputUsername(invusername1);
		loginPageFactory.inputPassword(password);
		loginPageFactory.loginButton();
		//Profile Page Baru
		String actualText = profilePageFactory.getProfileText();
		String expectedText = ("Your username is invalid!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	
	//TestCase03 Invalid Password
	@Test
	public void testInvalidPassword() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		Utility.hardWait(3);
		//LoginBaru
		loginPageFactory.inputUsername(username);
		loginPageFactory.inputPassword(invpassword1);
		loginPageFactory.loginButton();
		//Profile Page Baru
		String actualText = profilePageFactory.getProfileText();
		String expectedText = ("Your password is invalid!");
		System.out.println("Actual: "+ actualText);
		System.out.println("Expected: "+ expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
}
