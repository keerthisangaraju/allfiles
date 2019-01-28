package mavenDemo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility_pkg.Util;

public class BrandedSurveys_poll 
{

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void StartBrandedProject()
	{
		System.out.println("Started GoBranded");
	}
	
	@AfterTest
	public void EndBrandedProject()
	{
		System.out.println("Ended GoBranded");
	}
	
	@Test(priority=2)
	public void LoginBrandedSite() throws InterruptedException
	{
		
		driver = Util.LaunchChromeBrowser();
		
		driver.get(Util.GoBranded_URL);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
		
		driver.findElement(By.id("UserEmail")).sendKeys(Util.Branded_Username);
		
		driver.findElement(By.id("UserPassword")).sendKeys(Util.Branded_Password);
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
	  	String Actual_Title = driver.getTitle();
		
		System.out.println("Actual title is"+Actual_Title);
		
		System.out.println("Login into BrandedSite");

	}
	
	@Test(priority=3)
	public void Answer_Poll_GoBrandedSite() throws InterruptedException
	{

		wait = new WebDriverWait(driver,Util.WAIT_TIME);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Daily Poll')]")));
		
		/* To Scroll to the Daily poll section */
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		/* Get the list of radio buttons for Daily poll */
		List<WebElement> radiolist = driver.findElements(By.xpath("//label[starts-with(@for,'PollAnswer')]"));	
		Thread.sleep(500);
		
		/* Click on the first radio button and exit the loop */
		for(WebElement ele1 : radiolist)
		{
			ele1.click();
			break;
		}
				
		/* Submitting the Daily poll */
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Thread.sleep(10000);
		
		System.out.println("Answered the Poll");

	}
	
	@Test(priority=4)
	public void LogoutBrandedSite() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@id='profile-widget']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		Thread.sleep(1000);
		
		System.out.println("Logout BrandedSite");

		Util.CloseChromeBrowser();
		
	}
		
}
