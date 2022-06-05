package Practice1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PRINTONLYDUPLICATE {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("file:///C:/Users/DRPK/OneDrive/Desktop/WEB%20TECHNOLOGY%2010%2030/MTR.html");
		WebElement mtrlis = driver.findElement(By.id("mtr"));
		Select s = new Select(mtrlis);
		
		List<WebElement> opt = s.getOptions();
		int tot = opt.size();
		System.out.println(tot);
		
		HashSet<String> h = new HashSet<>();
		
		for(int i = 0; i < tot-1 ; i++) {
			WebElement ind = opt.get(i);
			String txt = ind.getText();
						
			if(h.add(txt)==false) {
				System.out.println(txt);
			}
		}

	}

}
