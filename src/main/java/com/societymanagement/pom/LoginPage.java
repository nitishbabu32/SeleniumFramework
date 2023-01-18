package com.societymanagement.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Declaration
@FindBy(id="username")
private WebElement usernameEdt;

@FindBy(id="password")
private WebElement passwordEdt;

@FindBy(id="login")
private WebElement loginButton;
// Initialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Utilization
public WebElement getUsernameEdt() {
	return usernameEdt;
}
public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getLoginButton() {
	return loginButton;
}

// Bussiness Library
public void setLogin(String username,String password) {
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginButton.click();
}

}
