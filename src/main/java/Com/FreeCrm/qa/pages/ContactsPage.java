package Com.FreeCrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCrm.qa.baseclass.TestBase;

public class ContactsPage  extends TestBase 
{
	
	
	
	
	
    public ContactsPage()
    {
    	PageFactory.initElements(driver, this);
    }
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement ClickonAddContactBtn;
	
	
	public AddnewContactPage VerifyAddContactBtn()
	{
		ClickonAddContactBtn.click();
		return new AddnewContactPage();
	}
	
	
	
	
	
	
    
   
    
    
    
    
    
    
    
    
}
