package com.societymanagement.genrics;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.societymanagement.genrics.DataBaseUtility;
import com.societymanagement.genrics.ExcelUtility;
import com.societymanagement.genrics.FileUtility;
import com.societymanagement.genrics.WebDriverUtility;
import com.societymanagement.pom.HomePage;
import com.societymanagement.pom.LoginPage;
import com.societymanagement.pom.OptionsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  WebDriver driver=null;
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility flib=new FileUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		Reporter.log("Connecting to Data Base", true);
		dlib.connectToDB("projects");
	}
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException {
		Reporter.log("launching Browser",true);
		//String Browser=flib.commonData("browser");
		String Browser=System.getProperty("browser")!=null ? System.getProperty("browser"):flib.commonData("browser");
		if(Browser.contains("chrome")) {
			ChromeOptions opt=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(Browser.contains("headless")) {
				opt.addArguments("HEADLESS");
			}
			driver=new ChromeDriver(opt);
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageLaod(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException {
		Reporter.log("login",true);
		driver.get(flib.commonData("url"));
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(flib.commonData("username"), flib.commonData("password"));
	}
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		Reporter.log("logout",true);
		OptionsPage op=new OptionsPage(driver);
		HomePage hp=new HomePage(driver);
		hp.clickOnoptionPage();
		op.logout();
	}
	public  String takeScreenShot(String testCaseName) throws IOException {
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".PNG");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".PNG";

	}
	@AfterClass(alwaysRun = true)
	public void tearDownApplication() {
		Reporter.log("closing Browser",true);
		driver.close();
	}
	@AfterSuite(alwaysRun = true)
	public void tearDownDb() throws SQLException {
		Reporter.log("Closing Data Base", true);
		dlib.tearDownDB();
	}
}
