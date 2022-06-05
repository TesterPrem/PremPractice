package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatadrivenProperties {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		Properties p = new Properties();
		p.load(new FileInputStream("./prem.properties"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(p.getProperty("username"));
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(p.getProperty("password"));
		Thread.sleep(3000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
