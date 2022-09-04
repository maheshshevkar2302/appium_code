package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class appium_test_1 {
	
	public class DemoApp{
		AndroidDriver driver;
		@BeforeTest
		public void SplashScreen() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Redmi Note 9 Pro"); //obtained from the command "adb devices"
		capabilities.setCapability("no", true);
		capabilities.setCapability("newCommandTImeout", 10000);
		//capabilities.setCapability("browserName", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "10");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.vending");
		capabilities.setCapability("appActivity", "com.avegen.together.together");
		capabilities.setCapability("noRest", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		@Test
		public void Login(){
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'mas_account_verification_country')]")).click(); //Open drop down country menu
		driver.findElement(By.name("India")).click(); //Select one country
		driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'et_account_verification_phone_number')]")).sendKeys("9999999999"); //Enter Mobile No
		driver.hideKeyboard(); //Hide keyboard
		driver.findElement(By.name("Enter your name")).sendKeys("Parul"); //Enter name
		driver.hideKeyboard(); //Hide keyboard
		driver.findElement(By.className("android.widget.Button")).click(); //Click on submit button
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123456"); //Enter password in next screen
		driver.hideKeyboard(); //Hide Keyboard, since keyboard hides the Submit button in this case
		driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click(); //Click on submit button
		}

		//@AfterTest
		public void end()
		{
		driver.quit(); //Close application
		}
		}

}
