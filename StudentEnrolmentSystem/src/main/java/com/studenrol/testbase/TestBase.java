package com.studenrol.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase 
{

	//PARENT CLASS which contains INITIALIZE PROPERTIES, SETUP BROWSER, GET URL(), MAXIMIZE WINDOW, IMPLICITWAIT(), DELETE COOKIES...

	public static WebDriver driver;
	public static Properties prop;
	public static String driverPathC =System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
	public static String driverPathF =System.getProperty("user.dir") + "\\driver\\geckodriver.exe";


	//Creating a Constructor of the Class TestBase -public
	//1) This is the Function for READING Properties File
	public void TestBase()
	{

		//2) Creating OBJECT for PROPERTIES CLASS.
		prop = new Properties();

		//3) Create an OBJECT for INPUTSTREAM CLASS + Location of config.properties File
		//		Surround it with [TRY CATCH]
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");


			//4) LOAD PROPERTIES FILE using load() and PROPERTIES OBJECT
			prop.load(ip);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}


	@BeforeTest
	public  void browserSetup() 
	{
		TestBase();
		//get browser value from config.properties file using prop obj &getProperty()
		String browserName= prop.getProperty("browser");

		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", driverPathC);
			driver=new ChromeDriver();

		}

		else if (browserName.equals("firefox")) 
		{
			//gecko driver
			System.setProperty("webdriver.gecko.driver", driverPathF);
			driver = new FirefoxDriver();
		}


		//Driver Maximize, Implicite Time, delete cookies...
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Launch URL
		driver.get(prop.getProperty("url"));

	}
	
	
	@AfterMethod
    public void tearDown(ITestResult TestResStatus) throws IOException {
        if (TestResStatus.getStatus()==TestResStatus.FAILURE) {
        	System.out.println(TestResStatus.getName());
        	takeScreenshot(TestResStatus.getName());
        }
    }
	
	//1) Create a method for Screenshot + arg as filename (filename.jpg)
		public String takeScreenshot(String fileName) throws IOException
		{
			//2) To take Screenshot & store it as image file format
				//2a. Convert driver-->TakeScreenshot interface (TypeCasting)
				File sourceLoc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				
				//2b. Setting the Image: "Location/Filename+Date.png
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				String destination= System.getProperty("user.dir") + "\\target\\" + fileName + dateName+ ".png";
				File destinationLoc = new File(destination);
				
				//Copy the Screenshot to desired Location using "copyFile()"
				FileUtils.copyFile(sourceLoc, destinationLoc);//or FileUtils.copyFile import org.apache.commons.io.FileUtils;
		        return destination; 
		}
	

	@AfterTest
	public void quitBrowser() throws IOException 
	{
		driver.quit();
	}
}
