package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="address_1")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="postcode")
	WebElement txtPostcode;
	
	@FindBy(xpath="//select[@id='input-country']")
	WebElement dropdnCountryele;
	 
	
	@FindBy(xpath="//select[@id='input-zone']")
	WebElement dropdnRegionele;
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtPass2;
	
	@FindBy(name="agree")
	WebElement termCondition;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		txtEmail.sendKeys(mail);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setAddress(String add)
	{
		txtAddress.sendKeys(add);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setPostcode(String code)
	{
		txtPostcode.sendKeys(code);
	}
	
	public void setCountry(String con)
	{
		 Select dropdnCountry=new Select(dropdnCountryele);
		 dropdnCountry.selectByVisibleText(con);
	}
	
	public void setRegion(String reg)
	{
		Select dropdnRegion=new Select(dropdnRegionele);
		dropdnRegion.selectByVisibleText(reg);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setconfirmPass(String cnfpwd)
	{
		txtPass2.sendKeys(cnfpwd);
	}
	
	public void agreeCondition()
	{
		termCondition.click();
	}
	
	public void  clickContinue()
	{
		btnContinue.click();
	}
	
	public String confirmMsg()
	{
		try
		{
		return confirmMsg.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
	
}
