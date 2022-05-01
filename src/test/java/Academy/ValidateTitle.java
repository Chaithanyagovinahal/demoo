package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;


public class ValidateTitle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Homepage");
		
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
	Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("Successfully validated");
	 
		 
		
	//	l.getLogin().click();
	//	LoginPage lp=new LoginPage(driver);
	//	lp.getEmail().sendKeys(Username);
	//	lp.getPassword().sendKeys(Password);
	//	System.out.println(text);
	//	lp.getLogin().click();
	}
	//@DataProvider
	//public Object[][] getData() {
	//	Object[][] data=new Object[2][3];
	//	data[0][0]="nonrestricted@gmail.com";
	//	data[0][1]="123456";
	//	data[0][2]="Restricted user";
		
	//	data[1][0]="restricted@gmail.com";
	//	data[1][1]="45678";
	//	data[1][2]="Nonrestricted user";
	//	return data;
		
	//}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
