package PrallelExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test2 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	
	@BeforeSuite
	public void connect()
	{
		Reporter.log("Connect to the Site", true);
	}
	@BeforeMethod
	public void openurl()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Site Opened", true);
		
	}
	@Test
	public void onsite() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(3000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void closeurl()
	{
		driver.close();
		Reporter.log("Site cloased", true);
	}
	@AfterSuite
	public void disconnect()
	{
		Reporter.log("Dsiconnected from the site" , true);
	}


}
