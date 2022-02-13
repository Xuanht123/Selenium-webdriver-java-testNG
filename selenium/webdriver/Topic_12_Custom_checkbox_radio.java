package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Custom_checkbox_radio {
    WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
    driver.get("https://material.angular.io/components/radio/examples");
    
    By winterRadio = By.xpath("//input[@value='Winter']");
    
    //Verify click chưachon
    Assert.assertFalse(driver.findElement(winterRadio).isSelected());
    driver.findElement(winterRadio ).click();
    sleepInSecond(10);
    
    //k verify được
    Assert.assertTrue(driver.findElement(winterRadio).isSelected());
	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}