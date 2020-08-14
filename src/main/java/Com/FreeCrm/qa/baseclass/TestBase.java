package Com.FreeCrm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import Com.FreeCrm.qa.Utill.TestUtill;
import Com.FreeCrm.qa.Utill.WebEventListener;

public class TestBase 
{
  //maximize window delete all cookies , initialize webdriver
	public static Properties prop;
	public static String classname="AddNewContactpageTest.java";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static Logger log;
	public static WebEventListener eventlistner;
	public TestBase() // reading from properties files
	{
		try
		{
	  	prop=new Properties();
	  	FileInputStream fip=new FileInputStream("C:\\Users\\Abdul Rajik shaik\\Desktop"
	  			+ "\\Abdul\\FreeCrmTest\\src\\main\\java\\Com\\FreeCrm\\qa\\Config\\Config.properties");
	  	prop.load(fip);
		}catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}	
		public static void initialization() throws TimeoutException
		{
		    log	=Logger.getLogger(classname);
		    BasicConfigurator.configure();
		   log.debug("hello");
			String browserName=   prop.getProperty("browser");
			  if(browserName.equals("chrome"))
			  {
				  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abdul Rajik shaik"
				  		+ "\\Desktop\\eclipse\\chromedriver_win32 (1)\\chromedriver.exe");
			      driver=new ChromeDriver();
			       		log.info("launching chrome browser");
			  }
	      
	      
	      
	      
	      
	      
	      e_driver=new EventFiringWebDriver(driver);
	      eventlistner=new WebEventListener();
	      e_driver.register(eventlistner);
	      driver=e_driver;
	      driver.manage().window().maximize();
	      log.info("maximiz the browser");
	      
	      wait=new WebDriverWait(driver, 10);
	      driver.manage().deleteAllCookies();
	      log.info("deleting all cookies");
	      driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	      log.info("page load timeout");
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      log.info("implicity waiting");
	      driver.get(prop.getProperty("url"));	      
	      log.info("opening url");
		}
		
		
		
		
	
}
