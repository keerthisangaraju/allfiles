package logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginfo
{

	static WebDriver driver;
	public static void main(String[] args)
	{
		
		Logger log = Logger.getLogger("Loginfo");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Keerthi\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("instantiate driver");
		driver.close();
		log.info("driver close");
	}

}
