package com.SocietyManagementSystem.Activities.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.societymanagement.genrics.BaseClass;
import com.societymanagement.genrics.ExcelUtility;
import com.societymanagement.genrics.FileUtility;
import com.societymanagement.genrics.JavaUtility;
import com.societymanagement.genrics.WebDriverUtility;
import com.societymanagement.pom.ActivitiesPage;
import com.societymanagement.pom.HomePage;
import com.societymanagement.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.societymanagement.genrics.ListenersImplimentationForExtentReport.class)
public class createSearchAndDeleteActivitiesTest extends BaseClass{
	@Test(groups="Smoke")
	public void createActivites() throws IOException {
		String titles = elib.readDataFromExcel("createActivites", 0, 1);
		String desc = elib.readDataFromExcel("createActivites", 1, 1);
		String start = elib.readDataFromExcel("createActivites", 2, 1);
		String end = elib.readDataFromExcel("createActivites", 3, 1);
		HomePage hp=new HomePage(driver);
		hp.clickonActivitesPage();
		ActivitiesPage ap=new ActivitiesPage(driver);
		ap.setExpensses(titles, desc, start, end);
		Reporter.log("Activites created Succesfully", true);
	}
	@Test(groups={"Regression","Smoke"})
	public void searchActivites() throws IOException {
		String titles = elib.readDataFromExcel("createActivites", 0, 1);
		// oppening Browser
		HomePage hp=new HomePage(driver);
		hp.clickonActivitesPage();
		ActivitiesPage ap=new ActivitiesPage(driver);
		ap.searchAndDeleteActivites(titles);
		Reporter.log("Activites deleted Succesfully", true);
	}
}
