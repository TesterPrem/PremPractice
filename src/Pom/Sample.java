package Pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample 
{
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	
	
	
 

}
