package com.qa2.hubspot2.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa2.hubspot2.base.BasePage;
import com.qa2.hubspot2.pages.HomePage;
import com.qa2.hubspot2.pages.LoginPage;
import com.qa2.hubspot2.utils.Constants;

public class HomePageTest {
	
	WebDriver driver;			//WebDriver class Reference created for the Object
	Properties prop;
	
	BasePage basePage;			//BasePage class Reference created and Object created inside setUp method
	LoginPage loginPage;		//LoginPage class Reference created for the Object
	HomePage homePage;			//Created HomePage Reference 
	
	@BeforeTest 
	public void setUp(){			//inside setUp method we have to Launch(browser) and enter (url) from BasePage
									//To call BasePage method have to create object. Reference created above
		basePage = new BasePage();							//Object created
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);			//using Reference(driver) from above we call init_driver
		
		loginPage = new LoginPage(driver);		//call doLogin method(below
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=3)
	public void verifyHomePageTitle(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page title is not matching...");
	}
	@Test(priority=1)
	public void verifyHomePageHeader(){
		String header = homePage.getHomePageHeaderText();
		System.out.println("HomePage header is : " + header );
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);		
		
	}
	@Test(priority=2)
	public void verifyLoggedInUserTest(){
		String loggedInUser = homePage.getLoggerInUser();
		System.out.println("LoggedIn user is : " + loggedInUser);
		//Assert.assertEquals(loggedInUser, "", "logged in user Not matched...");
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "logged in user Not matched...");
		
	}	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
