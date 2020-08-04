package com.qa2.hubspot2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa2.hubspot2.base.BasePage;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	//1.First thing to remember: Maintain the By locators--called object Repository (OR)
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2.Create constructor... of page class
	
	public LoginPage(WebDriver driver){
		this.driver = driver; 					//You have to add WebDriver driver above for this to work
	}
	
	//3.have to create Page Action 
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}	
	public boolean verifySignUpLink(){
		return driver.findElement(signUpLink).isDisplayed();
	}
	public HomePage doLogin(String username, String password){
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);	//While doing HomePageTest we replace void with return new & Pass a driver 
											 	
		
	}	
	
}
