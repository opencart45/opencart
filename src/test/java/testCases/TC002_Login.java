package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass
{

	@Test(groups= {"sanity","master"})
	public void test_login() throws IOException
	{
		logger.info("starting TC002_Login");
		try
		{
			logger.info("launching appurl");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		HomePage hm=new HomePage(driver);
		logger.info("click on myaccount page");
		hm.clickMyAccount();
		logger.info("click on login button");
		hm.clickLogin();
		
		LoginPage lg=new LoginPage(driver);
		logger.info("enter email");
		lg.setEmail(rb.getString("email"));
		logger.info("enter password");
		lg.setPassword(rb.getString("password"));
		logger.info("click on login button");
		lg.clickButton();
		
		boolean targetpage =lg.confirmAccount();
		
		if(targetpage)
		{
			logger.info("login successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("login fail");
			captureScreen(driver,"test_login");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.fatal("login fail");
			Assert.fail();
		}
		logger.info("finished TC002_Login");
	}

}
