package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillRary 
{
	@FindBy(id = "email")
	private WebElement un;
	
	@FindBy(id = "password")
	private WebElement pw;
	
	@FindBy(id = "last")
	private WebElement login;
	
	public SkillRary(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void username(String u)
	{
		un.sendKeys(u);
	}
	public void pass(String p)
	{
		pw.sendKeys(p);
	}
	public void click()
	{
		login.click();
	}
	

}
