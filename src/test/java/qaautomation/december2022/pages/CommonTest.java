package qaautomation.december2022.pages;

import org.testng.annotations.Test;


public class CommonTest extends BaseMainPageFactory{
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Test
	public void testSwitching() {
		commonPage.openUrl("https://facebook.com");
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://twitter.com");
		commonPage.openNewWindow();
		commonPage.openUrl("https://instagram.com");
	}
}


	

