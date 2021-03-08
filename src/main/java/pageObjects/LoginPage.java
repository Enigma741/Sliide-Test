package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.DataProvider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	public LoginPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	// Enter UserName
	@AndroidFindBy(id="com.test.news:id/editTextUserName")
	public WebElement UserName;
	
	// Enter Password
	@AndroidFindBy(id="com.test.news:id/editTextPassword")
	public WebElement Password;
	
	@AndroidFindBy(id="com.test.news:id/buttonLogin")
	public WebElement LogIn;
	
	public WebElement EnterUserName()
	{
		
		return UserName;
	}
	
	public WebElement EnterPassword()
	{
		
		return Password;
	}
	
	public WebElement HitLogin()
	{
		
		return LogIn;
	}
	
	
	
	
}
