package ApiPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReactAppHOMEPage {
	@FindBy(xpath = "//a[.='Projects']")
	private WebElement projects;
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutbtn;
	public ReactAppHOMEPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProjects() {
		return projects;
	}
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public void logout() {
		getLogoutbtn().click();
	}

}
