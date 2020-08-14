package com.Freecrm.qa.TestCasees;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import Com.FreeCrm.qa.baseclass.TestBase;
import Com.FreeCrm.qa.pages.HomePage;
import Com.FreeCrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage lp;
	Logger log=Logger.getLogger(LoginPageTest.class);
	LoginPageTest lpt;
	HomePage hmp;
	 // create constructor of loginpageTest and call super() method as it calls all properties files inTestBase 
	 public LoginPageTest() 
	 {
	   super();//it loads all property files 
	}
	
	
	
  @BeforeMethod
  public void setup()
  {
	  try {
		initialization();
		log.info("initializing the browser");
	} catch (TimeoutException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// it calls  browser, and maximize the window and delete all cookies
	  lp= new LoginPage();// to access all the functions and methods of loginclass
	   lpt=new LoginPageTest();
  }
  @Test(priority=1)
  public void VerifyloginPageTitleTest()
  {
   String title=  lp.CheckloginPageTitle();
  Assert.assertEquals(title, "Cogmento CRM");
  
  
  
  }
  
     @Test(priority=2)
     public void UserloginTest()
     {
		hmp= lp.login(prop.getProperty("email"), prop.getProperty("password"));
			
     }
		
     

     @AfterMethod
     public void closedown()
     {
    	 driver.quit();
     }
}
