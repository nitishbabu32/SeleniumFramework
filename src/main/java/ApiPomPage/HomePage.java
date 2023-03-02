package ApiPomPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

	@FindBy(xpath="//a[.='Projects']")
	private WebElement projects;
	
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement createBtn;
	
	@FindBy (name="projectName")
	private WebElement projectName;
	
	@FindBy(name="teamSize")
	private WebElement teamsize;
	
	@FindBy (name="createdBy")
	private WebElement createdBy;
	
	@FindBy (name="status")
	private WebElement st;
	
	@FindBy(xpath="//input[@value='Add Project']")
	private WebElement sbBtn;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyProject(String projectName,WebDriver driver) {
		projects.click();
		boolean confirmation = driver.findElement(By.xpath("//td[text()='"+projectName+"']")).isDisplayed();
		return confirmation;
	}
	
	public void createProject(String project_name,String createdBy1) {
		projects.click();
		createBtn.click();
		projectName.sendKeys(project_name);
		//teamsize.sendKeys(team);
		createdBy.sendKeys(createdBy1);
		WebElement projectStatus = st;
		Select s=new Select(projectStatus);
		s.selectByVisibleText("Created");
		sbBtn.submit();
	}
}
