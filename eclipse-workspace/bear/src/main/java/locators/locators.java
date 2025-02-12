package locators;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseFile.basefile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class locators extends basefile
{
	public AndroidDriver driver;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement Okbutton;

	public locators(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


public void modalclose()
{
	Okbutton.click();
}
}