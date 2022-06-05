package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatadrivenExcel {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("E:\\SELENIUM FROM 12 04 2022    LOHITH CHETHAN\\Book3.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String un = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pw = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(un);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		Thread.sleep(3000);
		
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		driver.close();
		
		

	}

}
