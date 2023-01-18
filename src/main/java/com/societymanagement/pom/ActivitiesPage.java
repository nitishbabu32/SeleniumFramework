package com.societymanagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage {
	@FindBy(id="add_activity")
	private WebElement addBtn;
	@FindBy(name="title")
	private WebElement titleTxtArea;

	@FindBy(name="description")
	private WebElement description;

	@FindBy(name="start")
	private WebElement startTxtArea;

	@FindBy(name="end")
	private WebElement endTxtArea;

	@FindBy(name="save_activity")
	private WebElement saveButn;

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtArea;

	@ FindBy(xpath="//a[.=' Update']")
	private WebElement updateButton;

	@FindBy(xpath="//a[.=' Delete']")
	private WebElement deleteButton;
	@FindBy(xpath="//a[@class='btn btn-danger delete_activity']")
	private WebElement yesBtn;

	public ActivitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyActivities(WebDriver driver,String name) {
		boolean expdata = driver.findElement(By.xpath("//td[.='"+name+"']")).isDisplayed();
		return expdata;
	}
	public void setExpensses(String title,String desc,String start,String end) {
		addBtn.click();
		titleTxtArea.sendKeys(title);
		description.sendKeys(desc);
		startTxtArea.sendKeys(start);
		endTxtArea.sendKeys(end);
		saveButn.click();

	}
	public void searchAndDeleteActivites(String name) {
		searchTxtArea.sendKeys(name);
		deleteButton.click();
		yesBtn.click();
	}


}
