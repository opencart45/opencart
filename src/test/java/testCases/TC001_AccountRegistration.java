package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass
{
	@Test(groups= {"regression","master"})		
	public void testAccountRegister() throws InterruptedException
	{
		try
		{
		driver.get(rb.getString("appURL"));
		logger.info("home page display");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickRegister();
		logger.info("clicked on register account");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName("alina");
		logger.info("provide first name");
		
		regpage.setLastName("smith");
		logger.info("provide last name");
		
		regpage.setEmail(randomestring()+"@gmali.com");
		logger.info("enter email");
		
		regpage.setTelephone("456899");
		logger.info("provide telephone");
		
		regpage.setAddress("london");
		logger.info("enter address");
		
		regpage.setCity("london");
		logger.info("enter city");
		
		regpage.setPostcode("56273");
		logger.info("provide postcode");
		
		Thread.sleep(3000);
		regpage.setCountry("United Kingdom");
		logger.info("provide country name");
		
		Thread.sleep(3000);
		regpage.setRegion("Bristol");
		logger.info("provide region");
		
		regpage.setPassword("alina123");
		logger.info("enter password");
		regpage.setconfirmPass("alina123");
		logger.info("enter confirm password");
		
		regpage.agreeCondition();
		logger.info("clicked term and condition");
		
		regpage.clickContinue();
		logger.info("click on continue button");
		
		String confmsg=regpage.confirmMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account registration success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account registration failed");
			captureScreen(driver,"testAccountRegister");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.error("Account registration failed");
			Assert.fail();
			
		}
		logger.info(" test case TC001_AccountRegistration complete");
				
	}

}
