package testphp.phpproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AboutLink {
	ChromeDriver driver;

	@BeforeMethod
	public void Launch() {
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://18.220.177.49:8001/project/website/");
	}

	@Test
	public void ClickAboutUs() {
		driver.findElementByLinkText("About Us").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String textValue = driver.findElementByXPath("//*[@id=\"PID-ab2-pg\"]/b").getText();
		Assert.assertEquals("about",textValue); 
	}

	@AfterMethod
	public void close() {
		driver.close();
	}	
}
