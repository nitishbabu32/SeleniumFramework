package ApiPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="usernmae")
	private WebElement usernameTxt;
	
	@FindBy(id="inputPassword")
	 private WebElement passwordTxt;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToapp(String un,String pw) {
		usernameTxt.sendKeys(un);
		passwordTxt.sendKeys(pw);
		signBtn.submit();
	}
}
