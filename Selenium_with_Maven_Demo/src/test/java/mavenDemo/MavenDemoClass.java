package mavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenDemoClass
{

	WebDriver driver;
	@Test(priority =1)
	public void OpenTestSite()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Keerthi\\SeleniumDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.itelearn.com");
		
		driver.manage().window().maximize();
		
	}
	
	@Test(priority =2)
	public void CloseTestSite()
	{
		driver.quit();
	}


}
