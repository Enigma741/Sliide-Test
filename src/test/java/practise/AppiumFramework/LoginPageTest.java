package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LoginPage;
import pageObjects.NewsPage;


public class LoginPageTest extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	@Test(dataProvider="getData")
	public void LogInValidation(String username, String Password ) throws IOException, InterruptedException
	{
		
		service=startServer();
		
		log.info("Server started");
		AndroidDriver<AndroidElement> driver=capabilities("SliideApp");
		log.info("Driver is initialized");
		 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     LoginPage loginPageTest=new LoginPage(driver);
	     
	     loginPageTest.UserName.isDisplayed();
	     log.info("UserName field is displayed");
	     loginPageTest.EnterUserName().sendKeys(username);
	     
	     loginPageTest.Password.isDisplayed();
	     log.info("Password field is displayed");
	     loginPageTest.EnterPassword().sendKeys(Password);
	     
	     loginPageTest.LogIn.isDisplayed();
	     log.info("LogIn button is displayed");
	     loginPageTest.HitLogin().click();
	     
	     NewsPage newspage= new NewsPage(driver);
	     newspage.HitImage().click();
	     
	     
	     
         service.stop();




	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="password";
		data[0][1]="password";
		//1st row
		data[1][0]="user1";
		data[1][1]="password";
		
		return data;
			
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	
	
}
