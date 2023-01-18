package com.societymanagement.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
// Declaration
@FindBy(xpath="//a[.=' Administrator']")
private WebElement administratorPage;

@FindBy(xpath="//a[.=' Student']")
private WebElement studentPage;

//Intialization
public  AccountsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
// Utilization
public WebElement getAdministratorPage() {
	return administratorPage;
}

public WebElement getStudentPage() {
	return studentPage;
}
// Bussiness Library
public void clickOnAdministrator() {
	administratorPage.click();
}
public void clickstudentPage() {
	studentPage.click();
}
}