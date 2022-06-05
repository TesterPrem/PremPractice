package PrallelExecution;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	public static WebDriver driver;
	
	@BeforeSuite
	public void connect()
	{
		Reporter.log("Connect to the Site", true);
	}
	
	@Parameters({"browsername"})
	@BeforeMethod
	public void openurl(String brow)
	{
		if(brow.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapp.skillrary.com/index.php");
		Reporter.log("Site Opened", true);
		
	}
	@Test
	public void run() throws InterruptedException
	{
		WebElement ele1 = driver.findElement(By.id("course"));
		Actions a = new Actions(driver);
		a.moveToElement(ele1).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Selenium Training'])[1]")).click();
		Thread.sleep(3000);
		WebElement ele2 = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		a.doubleClick(ele2).perform();
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void closeurl()
	{
		Reporter.log("Close the Site", true);
		driver.close();
	}
	@AfterSuite
	public void disconnect()
	{
		Reporter.log("Disconnect from the site", true);
		Reporter.log("Hi", true);
	}

}

