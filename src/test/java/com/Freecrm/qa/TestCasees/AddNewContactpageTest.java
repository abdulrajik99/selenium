package com.Freecrm.qa.TestCasees;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import Com.FreeCrm.qa.Utill.TestUtill;
import Com.FreeCrm.qa.baseclass.TestBase;
import Com.FreeCrm.qa.pages.AddnewContactPage;
import Com.FreeCrm.qa.pages.ContactsPage;
import Com.FreeCrm.qa.pages.DealsPage;
import Com.FreeCrm.qa.pages.HomePage;
import Com.FreeCrm.qa.pages.LoginPage;
import Com.FreeCrm.qa.pages.TasklinksPage;

public class AddNewContactpageTest  extends TestBase
{
	
	LoginPage lp;
	ContactsPage contactpag;
	DealsPage dealpage;
	AddnewContactPage addnewcont;
	HomePage hompg;
	public static Logger log;

    TasklinksPage taskpage;
	TestUtill testutill;
    String sheetname="contacts";

	 public AddNewContactpageTest()
	   {
		   super();
		   
	   }
	 
	 @BeforeMethod
	   public void setup() 
	   {
	 	  try {
			initialization();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	  log.debug("initializing the setup");
	 	  lp=new LoginPage();
	 	  
	 	  contactpag=new ContactsPage();
	 	  dealpage =new DealsPage();
	 	  taskpage=new TasklinksPage();
	 	  	hompg=lp.login(prop.getProperty("email"), prop.getProperty("password"));//login method
	 	  	log.debug("login sucess");
	 	  			}
	 @DataProvider
	 public Object[][] getcrmtestdata()
	 {
		 
		 
		Object[][] data= testutill.getTestData(sheetname);
		return data;
	 }
	 
	 @Test(priority=1,dataProvider="getcrmtestdata")
	 public void ValidateAddnewcontactTest(String fname,String lname,String emai)
	 {
		 log.debug("navigating to contacts links");
		 contactpag= hompg.ClickonContactsLinks();// contact page is loaded
	 	 log.debug("verifying add contact");   
		 addnewcont= contactpag.VerifyAddContactBtn();//add new contact page loaded
         addnewcont.CreateAddnewcontactwithfnameandall(fname, lname, emai);
         log.debug("verified add new contact");
	 }
	 
	 @Test(priority=2)
	 public void VerifyStatusTest()
	 {
		 addnewcont.VerifyStatusBtn();
	 }
	 
	 
	 @AfterMethod
	 public void shut()
	 {
		 driver.close();
	 }
}
