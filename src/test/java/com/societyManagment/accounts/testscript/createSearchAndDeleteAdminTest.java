package com.societyManagment.accounts.testscript;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.societymanagement.genrics.BaseClass;
import com.societymanagement.genrics.ExcelUtility;
import com.societymanagement.genrics.FileUtility;
import com.societymanagement.genrics.JavaUtility;
import com.societymanagement.genrics.WebDriverUtility;
import com.societymanagement.pom.AccountsPage;
import com.societymanagement.pom.AdministratorPage;
import com.societymanagement.pom.HomePage;
import com.societymanagement.pom.LoginPage;
import com.societymanagement.pom.OptionsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.societymanagement.genrics.LIsteners.class)
public class createSearchAndDeleteAdminTest extends BaseClass{
	@Test
	public void createAdministrator() throws Throwable {
		String username = elib.readDataFromExcel("CreateAdmin", 0, 1);
		String password = elib.readDataFromExcel("CreateAdmin", 1, 1);
		String Name = elib.readDataFromExcel("CreateAdmin", 2, 1);
		HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickOnAdministrator();
		Thread.sleep(3000);
		AdministratorPage adp=new AdministratorPage(driver);
		adp.createAdmin(username,password,Name);
		String actualName = adp.verifyAdmin(driver, elib);
		Assert.assertEquals(actualName, username);
		System.out.println("Admin is created Succssesfully");
	}
	@Test(dependsOnMethods="createAdministrator")
	public void searchAdmin() throws IOException, InterruptedException {
		String username = elib.readDataFromExcel("CreateAdmin", 0, 1);
		HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickOnAdministrator();
		AdministratorPage adp=new AdministratorPage(driver);
		boolean expectedName = adp.serchAdmin(driver, username);
		Assert.assertTrue(expectedName);
	}
	@Test(dependsOnMethods="searchAdmin")
	public void deleteAdmin() throws IOException {
		String eusername = elib.readDataFromExcel("CreateAdmin", 0, 1);
			HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickOnAdministrator();
		AdministratorPage adp=new AdministratorPage(driver);
		adp.handleDropDown(driver, wlib, 3);
		adp.deleteAdmin(eusername, driver, wlib);
		System.out.println("admin deleted succssesfully");
	
	}
	//@Test(retryAnalyzer=com.societymanagement.genrics.RetryImpclass.class)
	@Test
	public void printAllAdmin() throws IOException {
			HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickOnAdministrator();
		AdministratorPage adp=new AdministratorPage(driver);
	    adp.printAdmin();
	   
	}
}
