package com.Freecrm.qa.TestCasees;

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

public class CalenderPageTest extends TestBase
{
	LoginPage lp;
	ContactsPage contactpag;
	CalenderPage calenderpag;
	HomePage hompg;
	DealsPage dealpage;
	TasklinksPage taskpage;
	public CalenderPageTest()
	{
		super();
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
		  	 calenderpag= hompg.ClickonCalenderlink();
		}

	 @Test(priority=1)
	 public void VerifyCalenderMonthTest()
	 {
		 calenderpag.Verifymonth();
		
	 }
	 
	 @Test(priority=2)
	 public void VerifycalendatesTest()
	 {
		 calenderpag.VerifyCalender();
	 }
	
	 
	 
	 
	 
	
	
	
	
}
