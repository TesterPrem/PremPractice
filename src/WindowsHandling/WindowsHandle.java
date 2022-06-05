package WindowsHandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle 
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		}

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://letcode.in/windows");
		String par = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();	
		Thread.sleep(3000);
		
		String tit = driver.getTitle();
		System.out.println(tit);
		driver.findElement(By.id("multi")).click();
		Thread.sleep(3000);
		Set<String> whs = driver.getWindowHandles();
		int tot = whs.size();
		System.out.println(tot);
		
		for(String all : whs)
		{
			driver.switchTo().window(all);
			String tita = driver.getTitle();
			System.out.println(tita);
			
			if(all.equals(par))
			{
				driver.close();
				
			}
			else
			{
				
			}
			
		}
		Thread.sleep(3000);
		driver.quit();
		
		 

	}

}
