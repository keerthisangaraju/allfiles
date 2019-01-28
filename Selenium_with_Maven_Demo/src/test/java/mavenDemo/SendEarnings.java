package mavenDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility_pkg.Util;

public class SendEarnings {
	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	public void LoginSendEarnings() {
		driver = Util.LaunchChromeBrowser();

		driver.get("https://www.sendearnings.com/");

		driver.findElement(By.xpath("//a[contains(text(),'Member Login')]")).click();

		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("keerthisvarma@gmail.com");

		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Send@1234");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		System.out.println("Logged into Send Earnings");
	}

	@Test(priority = 2, enabled = false)
	public void AnswerPoll() {

		List<WebElement> Radiolist = driver.findElements(By.xpath("//input[@type='radio'][@class='memberInput']"));

		for (WebElement ele : Radiolist) {
			ele.click();
			break;
		}

		driver.findElement(By.xpath("//input[@id='learnAndEarnSubmitButton']")).click();

		System.out.println("Answered the poll question");

		driver.switchTo().defaultContent();
		
		System.out.println("Swithc to default content");


	}

	@Test(priority = 3)
	public void ReadDailyPaidEmail() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='emailsBlock']//span[@class='iconBox']")).click();

		List<WebElement> unread_mail_list = driver
				.findElements(By.xpath("//div[@id='mailbox_items']/div[contains(@id,mail_line_unconfirmed)]"));
		if (unread_mail_list.size() == 0)
			System.out.println("No Emails to Read");
		else {
			for (WebElement ele : unread_mail_list) {
				ele.click();

				driver.switchTo().frame("mail_display_iframe");

				System.out.println("Switched to the frame");

				String parentwindow = driver.getWindowHandle();

				try {
					driver.findElement(By.xpath("//a[@href='#']//img")).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("//a[@href='#']")).click();
					System.out.println("Clicked the link");

				}

				driver.switchTo().window(parentwindow);
			}
		}
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Yes, Log Out')]")).click();

		Util.CloseChromeBrowser();

	}

}
