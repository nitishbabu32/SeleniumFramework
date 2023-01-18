package com.societymanagement.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsPage {
// Declaration
	@FindBy(xpath="//a[.=' Logout']")
	private WebElement logoutbtn;
	// Initialization 
	
	public OptionsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	// Bussiness Library
	
	public void logout() {
		logoutbtn.click();
	}
}
