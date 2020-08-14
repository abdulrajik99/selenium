package Com.FreeCrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCrm.qa.baseclass.TestBase;

public class HomePage  extends TestBase 
{
   @FindBy(xpath="//span[@class='user-display']")
   WebElement usernamelabel; //to know my name
   
   @FindBy(xpath="//span[contains(text(),'Contacts') and @class='item-text']")
   WebElement contactslink;
   
   @FindBy(xpath="//span[contains(text(),'Calendar')]")
   WebElement calenderlink;
   
   
   @FindBy(xpath="//span[contains(text(),'Deals')]")
   WebElement dealslink;
   
   @FindBy(xpath="//span[contains(text(),'Tasks')]")
   WebElement tasklink;
   
   @FindBy(xpath="//div[@class='ui header item mb5 light-black']")
   WebElement ContactpageHeading;
   
   // create constructor ,to initialize page objects
   public HomePage()
   {
	    PageFactory.initElements(driver, this);
	    
   }
   
   public String verifyhomepageTitle()
   {
	   return driver.getTitle();
   }
   
   public boolean verifyusernamelabel()
   {
	   return usernamelabel.isDisplayed();
   }
   
   
   public ContactsPage ClickonContactsLinks()
   {
	   contactslink.click();
	   return new ContactsPage();
   }
   
   public CalenderPage ClickonCalenderlink()
   {
	   calenderlink.click();
	   return new CalenderPage();
   }
   
   
   
   
   
   public DealsPage ClickonDealsLink()
   {
	   dealslink.click();
	   return new DealsPage();
	   
   }
   public TasklinksPage ClickonTasklink()
   {
	   tasklink.click();
	   return new TasklinksPage();
   }
   public boolean Verifycontactlabel()
   {
	   return ContactpageHeading.isDisplayed();
   }
   
   
   
   
}
