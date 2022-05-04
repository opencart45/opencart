package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC003_LoginDDT extends BaseClass 
{
	WebDriver driver;
	
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email,String password,String exp)
	{
		logger.info("starting testcase TC003_LoginDDT ");
		try
		{
			logger.info("launching opencart ");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		HomePage hm=new HomePage(driver);
		logger.info("clicked myaccount button");
		hm.clickMyAccount();
		logger.info("clicked login");
		hm.clickLogin();
		
		LoginPage lg=new LoginPage(driver);
		logger.info("entered email  ");
		lg.setEmail(rb.getString("email"));
		logger.info("entered password");
		lg.setPassword(rb.getString("password"));
		logger.info("clicked login button");
		lg.clickButton();
		
		boolean status=lg.confirmAccount();
		if (exp.equals("Valid"))
		{
			if(status==true)
			{
				logger.info("login success");
				MyAccountPage my=new MyAccountPage(driver);
				my.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.info("login failed ");
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(status==true)
			{
				
				MyAccountPage my=new MyAccountPage(driver);
				my.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				logger.info("login failed ");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
		}
		
		logger.info("finished testcase TC003_LoginDDT ");
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
	}

}
