package scenario1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Senario1Automationpractise
{
	public static void main(String args[]) throws InterruptedException
	{
		 
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abdul Rajik shaik\\Desktop\\eclipse\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("jetblue@grr.la");
		driver.findElement(By.id("passwd")).sendKeys("jetblue");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		//login as a user
		System.out.println("logined "+driver.getTitle());
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a")).click();
		System.out.println("title of page is  "+driver.getTitle());
		String t="T-shirts - My Store";
		Assert.assertEquals(t, "T-shirts - My Store","true");
		js.executeScript("window.scrollBy(0,400)");
		 driver.findElement(By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 // clicking on add to cart
	//	driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]//parent::button[@type='submit']")).click();
	
		
		
		
	}
}
