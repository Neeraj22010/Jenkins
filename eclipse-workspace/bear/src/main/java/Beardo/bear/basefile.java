package Beardo.bear;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
 
import com.google.common.collect.ImmutableMap;
 
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
 
public class basefile {
	public AndroidDriver driver;
	public AppiumServiceBuilder service;
// For IOS Device	
//	public IOSDriver driver;
//	public AppiumDriverLocalService Service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
		//AppiumServiceBuilder and AppiumDriverLocalService do the job for you.
		//Starting Appium server Programmatically	   
		service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\neeraj.tiwari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		service.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.build();
	//	service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DemoTesting");  // Emulator
//		options.setChromedriverExecutable("C:\\Users\\kislay\\chromedriver_win32");
//		options.setCapability("browserName","Chrome");
//      options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
	  //  options.setApp("C:\\Users\\kislay\\eclipse-workspace\\YartriPulseMobileApp\\src\\test\\java\\resources\\General-Store.apk");
	    options.setApp("C:\\Users\\neeraj.tiwari\\eclipse-workspace\\bear\\src\\test\\java\\resource\\Beardo_1.9_APKPure (1).apk");
	 // options.setApp("C:\\Users\\kislay\\eclipse-workspace\\YartriPulseMobileApp\\src\\test\\java\\resources\\Purplle Online Beauty Shopping_2.1.74_APKPure.apk");
		 driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 
		 
	}
//	@BeforeClass
//	public class IOSAutomation {
//		@Test
//		public void AppiumTest() throws MalformedURLException {
//		//Starting Appium server Programmatically
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
//		//Create object of XCUITestOptions
//		XCUITestOptions options = new XCUITestOptions();
//		//Set Device Name
//		options.setDeviceName("iPhone 12");
//	    // set app location
//		options.setApp("Location_of_UIKitCatalog.app");
//		//Version of iOS in which we are automating
//		options.setPlatformVersion("16.2");
//		//Wait - because in ios,webdriver agent will first install in your phone and this will further lets you automate ios apps, however in android it is not required
//		options.setAvdLaunchTimeout(Duration.ofSeconds(20));
//		//Create object of iOS driver
//		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
//		//Stop the Appium Server
//		service.stop();
//		driver.quit();
//		}
//	
		public void longPressAction(WebElement ele) {
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
					    "duration",2000));			    
		}
		public void swipeAction(WebElement ele, String direction) {
			((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
					    "direction",direction,
					    "percent",0.75
					    ));		
		}
			public void scrollToEndAction()
			{
				boolean canScrollMore;
				do
				{
				 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 3.0
					));
				}while(canScrollMore);
			}

			public void scrollToText(String text)
			{
				driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
			}


 
					

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
//		service.
	}
 
}