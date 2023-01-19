package com.societyManagment.expensses.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.societymanagement.genrics.BaseClass;
import com.societymanagement.pom.ExpenssesPage;
import com.societymanagement.pom.HomePage;
import com.societymanagement.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.societymanagement.genrics.LIsteners.class)
public class createSearchAndDeleteExpenssesTest extends BaseClass {
	@Test
public void createExpensses() throws IOException {
	String details = elib.readDataFromExcel("createExpensses", 0, 1);
	String price = elib.readDataFromExcel("createExpensses", 1, 1);
	String start = elib.readDataFromExcel("createExpensses", 2, 1);
	String end = elib.readDataFromExcel("createExpensses", 3, 1);
	String deadline = elib.readDataFromExcel("createExpensses", 4, 1);
	HomePage hp=new HomePage(driver);
	hp.clickOnExpenssesPage();
	ExpenssesPage ep=new ExpenssesPage(driver);
	ep.setNewExpensses(details, price, start, end, deadline, wlib, 2);
	boolean actualexp = ep.verifyExpensses(driver, details);
	Assert.assertTrue(actualexp);
	Reporter.log("Expensses created Successfully",true);
}
	@Test
	public void searchAndDeleteExpensses() throws IOException {
		String details = elib.readDataFromExcel("createExpensses", 0, 1);
		HomePage hp=new HomePage(driver);
		hp.clickOnExpenssesPage();
		ExpenssesPage ep=new ExpenssesPage(driver);
		ep.searchDeleteExpensses(details);
		Reporter.log("Expensses deleted Successfully",true);
		
	}
}
