package com.societymanagement.pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.societymanagement.genrics.ExcelUtility;
import com.societymanagement.genrics.WebDriverUtility;

public class AdministratorPage {
	// Declaration
	public WebDriver driver;
	@FindBy(id="add_admin")
	private WebElement addAdminButton;

	@FindBy(name="username")
	private WebElement newusername;

	@FindBy(name="password")
	private WebElement newpassword;

	@FindBy(name="name")
	private WebElement name;

	@FindBy(name="save_admin")
	private WebElement savebutton;

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtArea;

	@ FindBy(xpath="//a[.=' Update']")
	private WebElement updateButton;

	@FindBy(xpath="//a[.=' Delete']")
	private WebElement deleteButton;

	@FindBy(name="update_admin")
	private WebElement savechangesButton;

	@FindBy(xpath="//select[@name='table_length']")
	private WebElement dropdown;
	@FindBy(xpath="//a[@class='btn btn-danger delete_admin']")
	private WebElement deletewarningbutton;

	@FindBy(xpath="//td[@class='sorting_1']")
	private List<WebElement> adminList;
	// Initialization

	public WebElement getDeletewarningbutton() {
		return deletewarningbutton;
	}
	public AdministratorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization
	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getAddAdminButton() {
		return addAdminButton;
	}

	public WebElement getNewusername() {
		return newusername;
	}

	public WebElement getNewpassword() {
		return newpassword;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getSearchTxtArea() {
		return searchTxtArea;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public void createAdmin(String username,String password,String Name) {
		addAdminButton.click();
		newusername.sendKeys(username);
		newpassword.sendKeys(password);
		name.sendKeys(Name);
		savebutton.click();
	}
	public void updateAdmin(String adminName,String nusername,String password,String Name, WebDriver driver,WebDriverUtility wlib) {
		driver.findElement(By.xpath("//td[.='"+adminName+"']/parent::tr/child::td/descendant::a[.=' Update']")).click();
		newusername.clear();

		newusername.sendKeys(nusername);
		newpassword.clear();
		newpassword.sendKeys(password);
		name.clear();
		name.sendKeys(Name);

		try {
			savechangesButton.click();
			wlib.acceptAlert(driver);
		}catch(Exception e) {
			wlib.acceptAlert(driver);
			e.printStackTrace();
		}

	}
	public void deleteAdmin(String adminName,WebDriver driver,WebDriverUtility wlib) {
		driver.findElement(By.xpath("//td[.='"+adminName+"']/parent::tr/child::td/descendant::a[.=' Delete']")).click();
		deletewarningbutton.click();
	}
	public void handleDropDown(WebDriver driver,WebDriverUtility wul,int index) {
		wul.select(dropdown, index);
	}
	public String verifyAdmin(WebDriver driver,ExcelUtility eul) throws IOException {
		String actualname = driver.findElement(By.xpath("//td[.='"+eul.readDataFromExcel("CreateAdmin", 0, 1)+"']")).getText();
		return actualname;
	}
	public boolean serchAdmin(WebDriver driver,String name) {
		searchTxtArea.sendKeys(name);
		boolean actualName = driver.findElement(By.xpath("//td[@class='sorting_1']")).isDisplayed();
		return actualName;
	}
	public void printAdmin() {
		//adminList.stream().forEach(e->System.out.println(e.getText()));
		adminList.stream().forEach(e->Reporter.log(e.getText(),true));
	}
}
