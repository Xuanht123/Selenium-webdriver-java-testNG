package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Exercise_Xpath_Css {
    WebDriver driver;
	//String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Register_Empty_data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("");
		sleepInSecond(2);
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
       
	}

	@Test
	public void TC_02_Invalid_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Xuân");
		driver.findElement(By.id("txtEmail")).sendKeys("132543@tyuuy@67676");
		driver.findElement(By.id("txtCEmail")).sendKeys("xuanht@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Xuanht1234");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("Xuanht1234");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987654321");
		sleepInSecond(2);
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
	}

	@Test
	public void TC_03_Incorrect_ConfirmEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Xuân");
		driver.findElement(By.id("txtEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("xuanht@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Xuanht1234");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("Xuanht1234");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987654321");
		sleepInSecond(2);
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Password_Less_than_6Characters() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Xuân");
		driver.findElement(By.id("txtEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Xua");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("Xua");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987654321");
		sleepInSecond(2);
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_05_Incorrect_Confirm_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Xuân");
		driver.findElement(By.id("txtEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Xuan12345");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("Xua4354365");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987654321");
		sleepInSecond(2);
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_Invalid_Phonenumber() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Xuân");
		driver.findElement(By.id("txtEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Xuanht1234@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Xuan12345");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("Xuan12345");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0000000000000");
		sleepInSecond(2);
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
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