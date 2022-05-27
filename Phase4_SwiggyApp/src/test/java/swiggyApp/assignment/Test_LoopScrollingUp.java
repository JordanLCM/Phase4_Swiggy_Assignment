package swiggyApp.assignment;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;


public class Test_LoopScrollingUp {

	public static AndroidDriver<MobileElement> driver;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		URL URL = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("udid", "DQSCRWA6JZY9UWNV");
		capabilities.setCapability("newCommandTimeout", "300");
		capabilities.setCapability("skipDeviceInitialization", "true");
		capabilities.setCapability("noReset", "true");
		
		driver = new AndroidDriver<MobileElement>(URL, capabilities);
		System.out.println(driver.getSessionId());

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		for(int ScrollUpTimes = 1; ScrollUpTimes <= 4; ScrollUpTimes++) {
			ScrollUp();
			System.out.println("*** ScrollUp : " + ScrollUpTimes);
		}
		System.out.println("Loop is completed! Total 4 times!");
	}

	public void ScrollUp() {
		//get the height of the Mobile Real Device
		int height = driver.manage().window().getSize().getHeight();
		System.out.println("Screen : " + height + "px");

		//get the width of the Mobile Real Device
		int width = driver.manage().window().getSize().getWidth();
		System.out.println("Screen : " + width + "px");

		//will start in mid of screen width
		int startWidthX = (int) (0.5 * width);
		int endWidthX = startWidthX;

		//will drag from bottom to top of height of Mobile Real Device
		int startHeightY = (int) (0.85 * height);
		int endHeightY = (int) (0.15 * height);

		TouchAction action = new TouchAction(driver);

		//-------------------------------//0.5 width----//0.9 height--------------------------//0.5 width--//0.1 height
		action.longPress(PointOption.point(startWidthX, startHeightY)).moveTo(PointOption.point(endWidthX, endHeightY)).release().perform();
	}
}
