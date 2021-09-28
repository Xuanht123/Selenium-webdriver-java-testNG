package webdriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_Selenium_Locator {
	// Khai báo 1 biến đại diện cho Selenium Webdriver
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Mở trình suyệt Firefox lên
		driver = new FirefoxDriver();

		// Set timout để tìm element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Mở application lên (AUT/SUT)
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}

	public void TC_01() {
		// Single element: WebElement
		driver.findElement(By.className("")).click();
		driver.findElement(By.className("")).getText();
	}

	// findElement: tìm element
	// By.xxx: với locator nào
	// Action gì lên element đó: click/sendkey/getText/...

	// Multiple element: ListElement
	// List<WebElement> buttons = driver.findElements(By.className(""));
	// buttons.get(0).click();

	// }

	
	public void TC_02_ID() {

		// Selenium Locator
		driver.findElement(By.id("send2")).click();

		// Verify email error message
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
	}

	
	public void TC_03_Class() {
		driver.navigate().refresh();
		driver.findElement(By.className("validate-password")).sendKeys("123456789");
	}

	
	public void TC_04_Name() {
		driver.navigate().refresh();
		driver.findElement(By.name("send")).click();

		// Verify email error message
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
	}

	
	public void TC_05_Tagname() {
		driver.navigate().refresh();
		// Lấy hết tất cả các đường link tại màn hình này sau đó getText ra
		List<WebElement> loginPageLinks = driver.findElements(By.tagName("a"));

		for (WebElement webElement : loginPageLinks) {
			System.out.println(webElement.getText());
		}
	}

	public void TC_06_LinkText() {
		driver.navigate().refresh();
		driver.findElement(By.linkText("Forgot Your Password?")).click();

		// Verify 
				Assert.assertTrue(driver.findElement(By.id("email_address")).isDisplayed());
	}

	
	public void TC_07_PartialLinkText() {
		driver.findElement(By.partialLinkText("Back to")).click();

		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
	}

	@Test
	public void TC_08_Css() {

		// Selenium Locator
		driver.findElement(By.cssSelector("#email")).sendKeys("xuanht@gmail.com");
		driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys("12345678");
		
	}

	@Test
	public void TC_09_Xpath() {
		driver.navigate().refresh();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xuanht@gmail.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("12345678");
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

};