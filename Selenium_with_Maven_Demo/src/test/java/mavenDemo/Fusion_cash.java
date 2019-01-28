package mavenDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility_pkg.Util;

public class Fusion_cash 
{
	WebDriver driver;
	WebDriverWait wait;
	
	
	@Test(priority=1)
	public void LaunchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", Util.Chrome_Path);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=2)
	public void LoginFusionCash() throws InterruptedException
	{
				
		driver.get(Util.FusionCash_URL);
		
		Thread.sleep(1000);
			
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Util.Fusion_Username);
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(Util.Fusion_Password);
		
		driver.findElement(By.xpath("//a[text()='Login »']")).click();
		
	  	String Actual_Title = driver.getTitle();
		
		System.out.println("Actual title is"+Actual_Title);
	
	}
	@Test(priority=3)
	public void Answer_PaidToClickPage() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'Paid to Click')]")).click();
		
		Thread.sleep(27000);
		
		wait = new WebDriverWait(driver,20);
		
		List<WebElement> No_of_Pages = driver.findElements(By.xpath("//div[@class='eightpxtxt']/a/img"));

		int page_num = 0;
		while(page_num < No_of_Pages.size())
		{
				
			List<WebElement> Pages=	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='eightpxtxt']/a/img")));

			String Page_Name = Pages.get(page_num).getAttribute("alt");
			if(Page_Name.equalsIgnoreCase("Entertainment") ||
					Page_Name.equalsIgnoreCase("Horoscope") ||
					Page_Name.equalsIgnoreCase("Sudoku") ||
					Page_Name.equalsIgnoreCase("Recipes"))
			{
				Pages.get(page_num).click();
				Thread.sleep(30000);
			}
			page_num++;
				
		}
		
		String parent_window = driver.getWindowHandle();
		
		List<WebElement> Text_AD_Pages=	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='ptctextadtxt']/a[1]")));

		Text_AD_Pages.get(0).click();
		
		driver.switchTo().window(parent_window);
		
		WebElement CouponButton = driver.findElement(By.xpath("//a[@class='button linkExternal']"));
		
		CouponButton.click();
		
		driver.switchTo().window(parent_window);
		
		driver.findElement(By.xpath("//a[contains(text(),'Click here to redeem your 15¢ and visit Ipsos Pane')]")).click();
		
		Thread.sleep(15000);
		
						
	}
	
}
