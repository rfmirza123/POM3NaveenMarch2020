package com.qa2.hubspot2.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa2.hubspot2.base.BasePage;
import com.qa2.hubspot2.pages.LoginPage;
import com.qa2.hubspot2.utils.Constants;

public class LoginPageTest {	
	WebDriver driver;			//WebDriver class Reference created for the Object
	
	BasePage basePage;			//BasePage class Reference created and Object created inside setUp method
	LoginPage loginPage;		//LoginPage class Reference created for the Object
	Properties prop;
	
	@BeforeTest 
	public void setUp(){			//inside setUp method we have to Launch (browser) and enter (url) from BasePage
									//To call BasePage method have to create object. Ref created above
		basePage = new BasePage();							//Object created
		prop =basePage.init_prop();							//Added this and add prop=	
		driver = basePage.init_driver(prop);			//using Ref(driver) from above we call init_driver
		
		loginPage = new LoginPage(driver);
		
	//We create Object of Login P	age so we can call all the methods from loginPage class
	//when you call the object of loginPage Class. But when I get there the class says wait.I have a Constructor
	//the constructor needs a driver.  So we have to pass the driver to LoginPage Class(driver) 
	}
	
	@Test(priority=2) 
	public void verifyLoginPageTitleTest(){		//we already have getTitle in LoginPage so we donot create another  
		String title = loginPage.getLoginPageTitle();		//so we just call by using object reference created: loginPage		
		System.out.println("loginPage title is : " + title);
	
		//As Constants method is static use Constants.LOGIN_PAGE_TITLE (class name.method		
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page is not matching...");		
		
	}		
	@Test(priority=1)
	public void verifySignUpLink(){
		Assert.assertTrue(loginPage.verifySignUpLink(),"Sign up link is NOT displayed...");
	}
	@Test(priority=3)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}	
		
		
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}


