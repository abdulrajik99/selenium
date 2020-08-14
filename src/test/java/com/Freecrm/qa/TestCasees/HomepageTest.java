package com.Freecrm.qa.TestCasees;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import Com.FreeCrm.qa.baseclass.TestBase;
import Com.FreeCrm.qa.pages.CalenderPage;
import Com.FreeCrm.qa.pages.ContactsPage;
import Com.FreeCrm.qa.pages.DealsPage;
import Com.FreeCrm.qa.pages.HomePage;
import Com.FreeCrm.qa.pages.LoginPage;
import Com.FreeCrm.qa.pages.TasklinksPage;

public class HomepageTest extends TestBase
{
	LoginPage lp;
	ContactsPage contactpag;
	CalenderPage calenderpag;
	HomePage hompg;
	DealsPage dealpage;
	TasklinksPage taskpage;
  public HomepageTest()
  {
	  super();// it calls all property files
  }
  @BeforeMethod
  public void setup() 
  {
	  try {
		initialization();
	} catch (TimeoutException e) {
				e.printStackTrace();
	}
	  
	  lp=new LoginPage();
	  contactpag=new ContactsPage();
	  dealpage =new DealsPage();
	  taskpage=new TasklinksPage();
	  	hompg=lp.login(prop.getProperty("email"), prop.getProperty("password"));//login method
	}
  
  //test cases schould be separated -independent with each other
  //before each test case launch the browser login 
  //@test execute the test case
  //@after method close the browser 
  
  
  @Test(priority=1)
  public void VerifyHomepagetitleTest()
  {
	     String title=  hompg.verifyhomepageTitle();
	     Assert.assertEquals(title, "Cogmento CRM","home page title is not matched");
	}
  @Test(priority=2)
  public void VerifyUsernameTest()
  {
	 Assert.assertTrue(hompg.verifyusernamelabel());
  }
   @Test(priority=3)
   public void VerifyContactsLinkTest()
   {	  
	   contactpag= hompg.ClickonContactsLinks();   
   }
   
  @Test(priority=4)
  public void VerifyDealspageTest()
  {
	 dealpage= hompg.ClickonDealsLink();
	 
  }
   
  @Test(priority=5)
  public void VerifyTaskpageTest()
  {
	  taskpage= hompg.ClickonTasklink();
	  
  }
  
   @Test(priority=6)
   public void VerifyCalenderpageTest()
   {
	   calenderpag= hompg.ClickonCalenderlink();
	   
   }
   
  
  @AfterMethod
  public void closedown()
  {
	driver.quit();  
  }








}
