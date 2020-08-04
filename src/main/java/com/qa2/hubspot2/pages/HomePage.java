package com.qa2.hubspot2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa2.hubspot2.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;	
	
	By header = By.xpath("//i18n-string[@data-key='app.header.title']");
	By accountName = By.xpath("//img[@class=' nav-avatar ']");
	
	public HomePage(WebDriver driver){				//Create Constructor
		this.driver = driver;
	}
	//create Page Action
	public String getHomePageTitle(){
		return driver.getTitle();		
	}
	//verify Header
	public String getHomePageHeaderText(){
		if(driver.findElement(header).isDisplayed()){
		return driver.findElement(header).getText();
	}
		return null;
	}
	public String getLoggerInUser(){
		if(driver.findElement(accountName).isDisplayed()){
		return driver.findElement(accountName).getText();
	}
		return null;
	}
}

	
	
	
	
	
	
	