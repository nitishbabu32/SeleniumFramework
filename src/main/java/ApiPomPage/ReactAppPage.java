package ApiPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReactAppPage {
	@FindBy(xpath = "//input[@id='usernmae']")
	private WebElement usernametxtfield;
	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement passwordtxtfield;
	@FindBy(xpath = "//button[.='Sign in']")
	private WebElement signinbtn;
	
	public ReactAppPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernametxtfield() {
		return usernametxtfield;
	}

	public WebElement getPasswordtxtfield() {
		return passwordtxtfield;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}
	
	public void reactapplogin(String name,String pwd) {
		getUsernametxtfield().sendKeys(name);
		getPasswordtxtfield().sendKeys(pwd);
		getSigninbtn().click();
	}

}
