package swiggyApp.assignment;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SwiggyApp_Assignment_Project001 {

	public static String BooleanTF = "true";
	public static int NumberOrder = 1;
	public static String TextAttr = "text";
	public static String BurgerName = "Veg Crunchy Volcano";

	public static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		URL URL = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("appPackage", "in.swiggy.android");
		capabilities.setCapability("appActivity", ".activities.HomeActivity");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("udid", "DQSCRWA6JZY9UWNV");
		capabilities.setCapability("newCommandTimeout", "300");
		capabilities.setCapability("skipDeviceInitialization", BooleanTF);
		capabilities.setCapability("noReset", BooleanTF);

		driver = new AndroidDriver<MobileElement>(URL, capabilities);
		System.out.println(driver.getSessionId());

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// start Swiggy App & go to main page
		System.out.println(" ----- Swiggy started! ----- ");
		Thread.sleep(1500);

		System.out.println(NumberOrder++ + " - Click on location dropdown button");
		driver.findElement(By.id("in.swiggy.android:id/arrow_imageview")).click();

		System.out.println(NumberOrder++ + " - Enter location name");
		driver.findElement(By.id("in.swiggy.android:id/location_description")).sendKeys("India Gate");

		System.out.println(NumberOrder++ + " - Select location India Gate");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India Gate']")).click();

		System.out.println(" ----- 1st part is DONE! ----- ");
		System.out.println(" ----- ----- ----- ----- ----- ");
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
	public void AfindProductBurger() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(" ----- Find product Burger ----- ");
		System.out.println(NumberOrder++ + " - Click search bar");
		driver.findElement(By.id("in.swiggy.android:id/disc_search_bar_container")).click();

		System.out.println(NumberOrder++ + " - Input product name");
		driver.findElement(By.id("in.swiggy.android:id/et_search_query_v2")).sendKeys("Burger");
		driver.hideKeyboard();

		System.out.println(NumberOrder++ + " - Choose Burger King");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Burger King']")).click();

		System.out.println(" ----- 2nd part is DONE! ----- ");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Test
	public void BfindBurgerKing() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(" ----- Find Burger King ----- ");
		MobileElement BK001 = driver.findElement(By.xpath("//android.widget.TextView[@text='Burger King']"));
		MobileElement BKOrigin001 = driver.findElement(By.xpath("//android.widget.TextView[@text='American']"));
		MobileElement BKState001 = driver.findElement(By.xpath("//android.widget.TextView[@text='Connaught Place']"));

		if (BK001.getAttribute(TextAttr).equals(BK001.getText())) {
			System.out.println(BK001.getText());
			if (BKOrigin001.getAttribute(TextAttr).equals(BKOrigin001.getText())) {
				System.out.println(BKOrigin001.getText());
				if (BKState001.getAttribute(TextAttr).equals(BKState001.getText())) {
					System.out.println(BKState001.getText());
					BK001.click();
				}
			}
		}

		System.out.println(" ----- 3rd part is DONE! ----- ");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Test
	public void CfindChooseBurger() throws InterruptedException {
		Thread.sleep(1500);
		System.out.println(" ----- Choose Burger ----- ");

		for (int ScrollUpTimes = 1; ScrollUpTimes <= 2; ScrollUpTimes++) {
			ScrollUp();
			System.out.println("*** ScrollUp : " + ScrollUpTimes);
		}

		MobileElement BKName = driver.findElement(By.xpath("//android.widget.TextView[@text='Veg Crunchy Volcano']"));
		if (BKName.getAttribute(TextAttr).equalsIgnoreCase(BurgerName)) {
			System.out.println(NumberOrder++ + " - Add to cart");
			System.out.println(BKName.getAttribute(TextAttr));
			driver.findElement(By.xpath(
					"(//android.view.ViewGroup[@content-desc=\"add button\"])[3]/android.view.ViewGroup/android.widget.TextSwitcher/android.widget.TextView"))
					.click();
		}

		System.out.println(NumberOrder++ + " - Add item");
		driver.findElement(By.xpath("//android.widget.Button[@text='Add Item to Cart']")).click();

		System.out.println(" ----- 4th part is DONE! ----- ");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Test
	public void DfindCheckoutAmount() throws InterruptedException {
		System.out.println(NumberOrder++ + " - Go to Checkout");
		driver.findElement(By.id("in.swiggy.android:id/tv_checkout")).click();

		System.out.println(NumberOrder++ + " - Remove from cart");
		driver.findElement(By.xpath("//android.widget.Button[@text='Decrease Quantity to 0']")).click();

		Thread.sleep(2000);
		System.out.println(NumberOrder++ + " - Close app");
		driver.closeApp();
		
		System.out.println(" ----- 5th part is DONE! ----- ");
		System.out.println(" ----- ----- END OF TASK ----- ----- ");
	}

	public void ScrollUp() {
		// get the height of the Mobile Real Device
		int height = driver.manage().window().getSize().getHeight();
		System.out.println(height);

		// get the width of the Mobile Real Device
		int width = driver.manage().window().getSize().getWidth();
		System.out.println(width);

		// will start in mid of screen width
		int startWidthX = (int) (0.5 * width);
		int endWidthX = startWidthX;

		// will drag from bottom to top of height of Mobile Real Device
		int startHeightY = (int) (0.8 * height);
		int endHeightY = (int) (0.1 * height);

		TouchAction action = new TouchAction(driver);

		// -------------------------------//0.5 width----//0.9
		// height--------------------------//0.5 width--//0.1 height
		action.longPress(PointOption.point(startWidthX, startHeightY)).moveTo(PointOption.point(endWidthX, endHeightY))
				.release().perform();
	}

}
