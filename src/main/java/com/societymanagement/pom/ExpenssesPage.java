package com.societymanagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.societymanagement.genrics.WebDriverUtility;

public class ExpenssesPage {
	@FindBy(id="add_expenses")
	private WebElement addExpenssBtn;

	@FindBy(name="detail")
	private WebElement detailsTxtArea;

	@FindBy(name="price")
	private WebElement priceTxtArea;

	@FindBy(name="ay1")
	private WebElement acadmicStartTxtArea;

	@FindBy(name="ay2")
	private WebElement acadmicEndTxtArea;

	@FindBy(name="deadline")
	private WebElement deadlineTxtArea;

	@FindBy(name="sem")
	private WebElement semDD;

	@FindBy(name="save_expenses")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtArea;

	@ FindBy(xpath="//a[.=' Update']")
	private WebElement updateButton;

	@FindBy(xpath="//a[.=' Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//a[@class='btn btn-danger delete_expenses']")
	private WebElement yesBtn;
	public ExpenssesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyExpensses(WebDriver driver,String details) {
		boolean expcdata = driver.findElement(By.xpath("//td[.='"+details+"']")).isDisplayed();
		return expcdata;
	}

	public void setNewExpensses(String details,String price,String start,String end,String deadline,WebDriverUtility wul,int index) {
		addExpenssBtn.click();
		detailsTxtArea.sendKeys(details);
		priceTxtArea.sendKeys(price);
		acadmicStartTxtArea.sendKeys(start);
		acadmicEndTxtArea.sendKeys(end);
		deadlineTxtArea.sendKeys(deadline);
		wul.select(semDD, index);
		saveBtn.click();
	}
	public void searchDeleteExpensses(String details) {
		searchTxtArea.sendKeys(details);
		deleteButton.click();
		yesBtn.click();
		
	}
}
