package com.societymanagement.pom;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.societymanagement.genrics.WebDriverUtility;

public class StudentPage {

	@FindBy(id="add_student")
	private WebElement addStudentBtn;

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtArea;

	@ FindBy(xpath="//a[.=' Update']")
	private WebElement updateButton;

	@FindBy(xpath="//a[.=' Delete']")
	private WebElement deleteButton;

	@FindBy(name="student_id")
	private WebElement idTxtArea;

	@FindBy(name="firstname")
	private WebElement nameTxtArea;

	@FindBy(name="middlename")
	private WebElement middleName;

	@FindBy(name="lastname")
	private WebElement lastNAmeTxtArea;

	@FindBy(name="year")
	private WebElement yearDD;

	@FindBy(name="section")
	private WebElement sectionTxtArea;

	@FindBy(name="save_student")
	private WebElement saveButton;

	@ FindBy(name="image")
	private WebElement fileUpload;
	
	@FindBy(name="table_length")
	private WebElement dropdown;
	
	@FindBy(xpath="//a[@class='btn btn-danger delete_student']")
	private WebElement deletewarningbutton;

	public StudentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddStudentBtn() {
		return addStudentBtn;
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

	public WebElement getIdTxtArea() {
		return idTxtArea;
	}

	public WebElement getNameTxtArea() {
		return nameTxtArea;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastNAmeTxtArea() {
		return lastNAmeTxtArea;
	}

	public WebElement getYearDD() {
		return yearDD;
	}

	public WebElement getSectionTxtArea() {
		return sectionTxtArea;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}
	public void createStudent(String path,int index,String id,String firstName,String midName,String lastName,String sec,WebDriverUtility wul) {
		addStudentBtn.click();
		File f=new File(path);
		String absPath = f.getAbsolutePath();
		fileUpload.sendKeys(absPath);
		idTxtArea.sendKeys(id);
		nameTxtArea.sendKeys(firstName);
		middleName.sendKeys(midName);
		lastNAmeTxtArea.sendKeys(lastName);
		wul.select(yearDD, index);
		sectionTxtArea.sendKeys(sec);
		saveButton.click();
	}
	public boolean verifyStudent(WebDriver driver,String id,WebDriverUtility wlib) {
		wlib.select(dropdown, 3);
		boolean expdata = driver.findElement(By.xpath("//td[.='"+id+"']")).isDisplayed();
		return expdata;
	}
	
	public void searchStudent(String id,WebDriver driver,WebDriverUtility wlib) {
		searchTxtArea.sendKeys(id);
			driver.findElement(By.xpath("//td[.='"+id+"']/parent::tr/child::td/descendant::a[.=' Delete']")).click();
			
			deletewarningbutton.click();
	}
}
