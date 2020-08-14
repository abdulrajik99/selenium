package com.Freecrm.qa.TestCasees;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

//import org.testng.Assert;
import Com.FreeCrm.qa.Utill.TestUtill;
import Com.FreeCrm.qa.baseclass.TestBase;
import Com.FreeCrm.qa.pages.AddnewContactPage;
import Com.FreeCrm.qa.pages.ContactsPage;
import Com.FreeCrm.qa.pages.DealsPage;
import Com.FreeCrm.qa.pages.HomePage;
import Com.FreeCrm.qa.pages.LoginPage;
import Com.FreeCrm.qa.pages.TasklinksPage;

public class ContactspageTest extends TestBase 
{
	LoginPage lp;
	ContactsPage contactpag;
	DealsPage dealpage;
	AddnewContactPage addnewcont;
	HomePage hompg;
    TasklinksPage taskpage;
	TestUtill testutill;
   public ContactspageTest()
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
 	  
 	  lp=new LoginPage();
 	  contactpag=new ContactsPage();
 	  dealpage =new DealsPage();
 	  taskpage=new TasklinksPage();
 	  	hompg=lp.login(prop.getProperty("email"), prop.getProperty("password"));//login method
 	  	contactpag= hompg.ClickonContactsLinks();// contact page is loaded
 	    
 	}

    @Test(priority=1)
    public void VerifyAddcontactlinkTest()
    {
        addnewcont=	contactpag.VerifyAddContactBtn();
    }
   
  
   @AfterMethod
   public void shutdo()
   {
	  driver.close();
   }
   
   
   
   
   
   
   
   
   
   
   
}
