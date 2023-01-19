package com.societyManagment.accounts.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.societymanagement.genrics.BaseClass;
import com.societymanagement.pom.AccountsPage;
import com.societymanagement.pom.HomePage;
import com.societymanagement.pom.LoginPage;
import com.societymanagement.pom.StudentPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.societymanagement.genrics.LIsteners.class)
public class createSearchAndDeleteStudentTest extends BaseClass {
	@Test
	public void createStudent() throws IOException, InterruptedException {
		String actstdId = elib.readDataFromExcel("createStudent", 0, 1);
		String firstName = elib.readDataFromExcel("createStudent", 1, 1);
		String middleName = elib.readDataFromExcel("createStudent", 2, 1);
		String lastname = elib.readDataFromExcel("createStudent", 3, 1);
		String sec = elib.readDataFromExcel("createStudent", 4, 1);
		HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickstudentPage();
		StudentPage sp=new StudentPage(driver);
		sp.createStudent("./src/test/resources/PHOTO.jpg",3, actstdId, firstName, middleName, lastname, sec, wlib);
		Thread.sleep(1000);
		boolean expdata = sp.verifyStudent(driver,actstdId, wlib);
		Assert.assertTrue(expdata);
		System.out.println("Student created succssesfully");
	}
	@Test
	public void searchAndDeleteStudent() throws IOException {
		String actstdId = elib.readDataFromExcel("createStudent", 0, 1);
		HomePage hp=new HomePage(driver);
		hp.clickOnaccountsPage();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickstudentPage();
		StudentPage sp=new StudentPage(driver);
		sp.searchStudent(actstdId, driver, wlib);
	}
}
