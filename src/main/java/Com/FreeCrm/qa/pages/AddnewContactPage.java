package Com.FreeCrm.qa.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

import com.sun.glass.events.KeyEvent;

import Com.FreeCrm.qa.baseclass.TestBase;

public class AddnewContactPage extends TestBase  
{
	//Select sel;
	
	 Robot r=null;
   public AddnewContactPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//input[@name='first_name']")
   WebElement firstnam;
   
   @FindBy(xpath="//button[@class='ui linkedin button']")
   WebElement savbtn;
   
   
   @FindBy(xpath="//input[@name='last_name']")
   WebElement Lastnam;
   
   @FindBy(xpath=" //input[@placeholder='Email address']")
   WebElement Enteremail;
   
   

   public void CreateAddnewcontactwithfnameandall(String fname,String lname,String emai)
   {
	   firstnam.sendKeys(fname);
	   Lastnam.sendKeys(lname);
	   Enteremail.sendKeys(emai);
	   
	  // sel=new Select(driver.findElement(By.name("status")));
	   //sel.selectByVisibleText(status);
       savbtn.click();
   }
   
   public void VerifyStatusBtn()
   {
	  try {
		r=new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//1
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//2
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//3
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//4
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//5
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//6
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);//7
	  Select sc=new Select(driver.findElement(By.xpath("//div[@name='status']")));
	  List<WebElement> lis=sc.getOptions();
	  for(WebElement web:lis)
	  {
		  String Tex=web.getText();
		  System.out.println("the names under status are "+Tex);
		  if(Tex.equals("New"))
		  {
			  web.click();
		  }
	  }
	  
	   
	   
   }
   
   
}
