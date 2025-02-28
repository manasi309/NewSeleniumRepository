package test.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.pageobject.Landingpage;

public class BaseTest {
	WebDriver driver;
	public Landingpage landingpage;
	public WebDriver initializeDriver() throws IOException 
	{
		WebDriverManager.firefoxdriver().setup();
		Properties prop =new Properties();
		FileInputStream fir = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\test\\resources\\GlobalData.properties");
		prop.load(fir);
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//edge
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			//firefox
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit wait
		return driver;
		
	}
	@BeforeMethod
	public Landingpage LaunchApplication() throws IOException 
	{
	driver=initializeDriver();
	landingpage=new Landingpage(driver);
	landingpage.goTo();
	return landingpage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
