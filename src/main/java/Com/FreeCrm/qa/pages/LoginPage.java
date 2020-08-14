package Com.FreeCrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FreeCrm.qa.baseclass.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement Loginbtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement singupbtn;
	
	public  LoginPage()
	{
		PageFactory.initElements(driver, this);//this means current class object this=LoginPage.class
	}
     public String CheckloginPageTitle()
     {
    	 return driver.getTitle();
     }
     
     public HomePage login(String em,String pass) 
     {
    	 
      email.sendKeys(em);
      password.sendKeys(pass);
      Loginbtn.click();
      
       return new HomePage();
     }
     
     
}
