package ApiPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReactApp_ProjectsPage {
	@FindBy(xpath = "//div[@class='container']/div/table/tbody/tr/td[1]")
	private WebElement projectId;
	@FindBy(xpath = "//div[@class='container']/div/table/tbody/tr/td[2]")
	private WebElement projectName;
	@FindBy(xpath = "//span[.='Create Project']")
	private WebElement createProjectbtn;
	public ReactApp_ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProjectId() {
		return projectId;
	}
	public WebElement getProjectName() {
		return projectName;
	}
	public WebElement getCreateProjectbtn() {
		return createProjectbtn;
	}
	
}
