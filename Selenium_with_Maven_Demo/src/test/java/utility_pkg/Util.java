package utility_pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Util
{
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	//Path for the ChromeDriver
	public static final String Chrome_Path = "C:\\Users\\Keerthi\\SeleniumDrivers\\chromedriver.exe";
	public static final String FireFox_Path = "C:\\Users\\Keerthi\\SeleniumDrivers\\geckodriver.exe";
	
	// Setting the Base URL
	public static final String GoBranded_URL="https://surveys.gobranded.com/users/login";
	public static final String FusionCash_URL="https://www.fusioncash.net/login.php";
	public static final int WAIT_TIME = 20;
	
	// Login Credentials
	public static final String Branded_Username="keerthisvarma@gmail.com";
	public static final String Branded_Password="Mint@1234";
	public static final String Fusion_Username="sridhardvarma@gmail.com";
	public static final String Fusion_Password="Fusion@1234";
	
	public static WebDriver LaunchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", Util.Chrome_Path);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
		System.out.println("Launching the Chrome Browser");
		
		return driver;

	
	}
	
	public static void CloseChromeBrowser()
	{
		System.out.println("Closing the Chrome Browser");
		
		driver.close();
		
	}
	
	public static void Scroll_Till_Element_Visible(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].scrollIntoView(true)", ele);
		
	}
	
}
