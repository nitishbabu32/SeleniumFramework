package com.societymanagement.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// DeclarationPage
@FindBy(xpath="//a[.=' Accounts']")
private WebElement accountpage;

@FindBy(xpath="//a[.=' Activities']")
private WebElement activitespage;

@FindBy(xpath="//a[.=' Expenses']")
private WebElement expenssespage ;

@FindBy(xpath="//a[.=' Transaction']")
private WebElement transactionPage;

@FindBy(xpath="//a[.=' Options']")
private WebElement optionPage;
// intialization

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
// Utilization
public WebElement getAccountpage() {
	return accountpage;
}

public WebElement getActivitespage() {
	return activitespage;
}

public WebElement getExpenssespage() {
	return expenssespage;
}

public WebElement getTransactionPage() {
	return transactionPage;
}

public WebElement getOptionPage() {
	return optionPage;
}
// BussinessLibrary
public void clickOnaccountsPage() {
	accountpage.click();
}
public void clickonActivitesPage() {
	activitespage.click();
	
}
public void clickOnExpenssesPage() {
	expenssespage.click();
}
public void clickontransactionPage() {
	transactionPage.click();
}
public void clickOnoptionPage() {
	optionPage.click();
}
}
