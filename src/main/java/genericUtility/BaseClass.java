package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import fileUtilis.PropertyUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignUpPage;

public class BaseClass {
	
	public WebDriver driver = null;
	PropertyUtility propertyUtility = new PropertyUtility();
	
	public WebDriver initDriver() {
		
//		String BROWSER = "chrome";
		String BROWSER = propertyUtility.getValue("BROWSER");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			setCapabilitiesForChrome(BROWSER);
			
		} else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			setCapabilitiesForFirefox(BROWSER);
			
		}else {
			System.out.println("Please enter the proper browser");
		}
		return driver;
	}
	
	private void setCapabilitiesForChrome(String browser) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		System.out.println(browser+"browser is opened");
	}
	
	private void setCapabilitiesForFirefox(String browser) {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");
		driver = new FirefoxDriver(options);
		System.out.println(browser+"browser is opened");
	}
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("Connect to Data Base");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver =initDriver();
		driver.get(propertyUtility.getValue("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	}
	
//	@AfterMethod
	public void existBrowser() {
		driver.close();	
	}
	
	@AfterSuite
	public void closeDB() {
		System.out.println("Disconnect Data Base");
	}

}
