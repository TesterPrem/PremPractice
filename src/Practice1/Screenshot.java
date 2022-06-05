package Practice1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./imgs/2.png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='_6luv _52jv']"));
		File elesrc = ele.getScreenshotAs(OutputType.FILE);
		File eledest = new File("./imgs/3.png");
		org.openqa.selenium.io.FileHandler.copy(elesrc, eledest);
		
	}

}
