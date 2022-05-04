package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement login_id;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement login_pass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_click;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement confirm_account;
	
	public void setEmail(String mail)
	{
		login_id.sendKeys(mail);
	}
	
	public void setPassword(String pass)
	{
		login_pass.sendKeys(pass);
	}
	
	public void clickButton()
	{
		btn_click.click();
	}
	
	public boolean confirmAccount()
	{
		try
		{
		return confirm_account.isDisplayed();
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	

}
