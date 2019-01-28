package finding_methods;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility_pkg.*;

public class Knowing_methods
{

	@Test(enabled = false)
	public void Get_Methods()
	{
		WebDriver driver = Util.LaunchChromeBrowser();
		driver.get("http://www.facebook.com");
	
		System.out.println("getPageSource "+driver.getPageSource());
		
		System.out.println("getCurrentUrl "+driver.getCurrentUrl());
		
		System.out.println("getTitle "+driver.getTitle());
		
		System.out.println("getWindowHandle "+driver.getWindowHandle());
		
	}
	
	
	@Test(enabled = false)
	public void Popup_Test_Methods() throws InterruptedException
	{
		WebDriver driver = Util.LaunchChromeBrowser();
		
		driver.get("http://www.popuptest.com/popuptest2.html");
		
		String parent = driver.getWindowHandle();
		
		System.out.println("Its a Parent Window"+parent);

		driver.close();
		
		Thread.sleep(2000);
		
		Set<String> windowslist = driver.getWindowHandles();
		
		System.out.println(windowslist.size());
		
		driver.quit();
		
	}

	@Test(enabled = false)
	public void Navigate_Methods() throws MalformedURLException
	{
		WebDriver driver = Util.LaunchChromeBrowser();

		System.out.println("getTitle "+driver.getTitle());
		
		//driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com"); // pass as string
		
		System.out.println("getCurrentUrl "+driver.getCurrentUrl());
		
		driver.navigate().to(new URL("https://www.guru99.com"));

		driver.navigate().to("http://www.google.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
			
	}
	@Test(enabled = false)
	public void SwitchTo_Frames() throws InterruptedException
	{
		WebDriver driver = Util.LaunchChromeBrowser();
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		
		List<WebElement> allFrames =driver.findElements(By.tagName("frame"));
		
		for(WebElement ele : allFrames)
		{
			System.out.println("Frame name is "+ele.getAttribute("name"));
		}
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.linkText("Action")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Actions")).click();
		
		driver.switchTo().frame("classFrame");
		
	}
	@Test
	public void SwitchTo_Alerts() throws InterruptedException
	{
		WebDriver driver = Util.LaunchChromeBrowser();
		
		Thread.sleep(2000);
		
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		
		//String parent = driver.getWindowHandle();
		
		WebElement ele1 = driver.findElement(By.xpath("//button[@onclick='pushAlert()']"));
		
		//My_Utilities_Methods.Scroll_Till_Element_Visible(driver, ele1);
		
		ele1.click();
		
		Thread.sleep(2000);
		
		Alert alertsimple = driver.switchTo().alert();
		
		System.out.println(alertsimple.getText());
		
		Thread.sleep(2000);
		
		alertsimple.accept();
		
		WebElement ele2 = driver.findElement(By.xpath("//button[@onclick='pushConfirm()']"));
		
		//My_Utilities_Methods.Scroll_Till_Element_Visible(driver, ele2);
		
		ele2.click();
		
		Thread.sleep(2000);
		
		Alert alertconfirm = driver.switchTo().alert();
		
		System.out.println(alertconfirm.getText());
		
		Thread.sleep(2000);
		
		alertconfirm.accept();
		
		WebElement ele3 = driver.findElement(By.xpath("//button[@onclick='promptConfirm()']"));
		
		//My_Utilities_Methods.Scroll_Till_Element_Visible(driver, ele3);
		
		ele3.click();
		
		Thread.sleep(2000);
		
		Alert promptalert = driver.switchTo().alert();
		
		promptalert.sendKeys("Keerthi");
		
		Thread.sleep(2000);
		
		System.out.println(promptalert.getText());
		
		Thread.sleep(2000);
			
		promptalert.dismiss();
		
	}
	
	
	@Test(enabled = false)
	public void WebElement_Methods()
	{
		
		WebDriver driver = Util.LaunchChromeBrowser();
		driver.get("http://www.facebook.com");
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='email']"));
		
		ele.clear();
		
		System.out.println("getAttribute= "+ele.getAttribute("type"));
		
		System.out.println("ele location = "+ele.getLocation());
		
		System.out.println("getTagName= "+ele.getTagName());
		
		System.out.println("getText= "+ele.getText());
		
		System.out.println("getRect= "+ele.getRect());
	
	    System.out.println("font-size = "+ele.getCssValue("font-size"));
        
        System.out.println("background = "+ele.getCssValue("background"));
        
        System.out.println("line-height = "+ele.getCssValue("line-height"));
        
        System.out.println("color = "+ele.getCssValue("color"));
        
        System.out.println("font-family = "+ele.getCssValue("font-family"));
        
	}
	
}
