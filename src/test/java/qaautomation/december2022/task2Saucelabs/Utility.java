package qaautomation.december2022.task2Saucelabs;

public class Utility {
	public static void hardWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
