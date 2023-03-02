package ApiPomPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage {
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement projectName;
	@FindBy(xpath = "//input[@name='createdBy']")
	private WebElement createdBy;
	@FindBy(xpath = "(//select[@name='status'])[2]")
	private WebElement projectStatus;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addProjectbtn;
	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProjectName() {
		return projectName;
	}
	public WebElement getCreatedBy() {
		return createdBy;
	}
	public WebElement getProjectStatus() {
		return projectStatus;
	}
	public WebElement getAddProjectbtn() {
		return addProjectbtn;
	}
	public void addproject(String projname,String createdBy,int value,WebDriver driver) {
		ReactApp_ProjectsPage p=new ReactApp_ProjectsPage(driver);
		p.getCreateProjectbtn().click();
		getProjectName().sendKeys(projname);
		getCreatedBy().sendKeys(createdBy);
		Select s=new Select(getProjectStatus());
		s.selectByIndex(value);
		getAddProjectbtn().click();
		
	}
}
