package Com.FreeCrm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCrm.qa.baseclass.TestBase;

public class CalenderPage extends TestBase
  {

	public CalenderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='rbc-toolbar-label']")
	WebElement currentmonth;

	
	public void Verifymonth()
	{
		 String actualmonth="December 2019";
		String mnth= currentmonth.getText();
		while(true)
		{
			if(mnth.equals(actualmonth))
			{
				System.out.println("the current month is  "+actualmonth);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[1]//button[3]")).click();
			}
		}
		
	}
		
		
	public void VerifyCalender()
	{
		boolean flag=false;
		WebElement table=driver.findElement(By.xpath("//div[@class='rbc-calendar']"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		for(WebElement row:rows)
		{
			List<WebElement> colu=row.findElements(By.tagName("td"));
			for(WebElement c:colu)
			{
				
				String text=c.getText();
				System.out.println("the dates are"+text);
				if(text.contains("10"))
				{
					c.click();
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				break;
			}
		}
		
	}

















}
