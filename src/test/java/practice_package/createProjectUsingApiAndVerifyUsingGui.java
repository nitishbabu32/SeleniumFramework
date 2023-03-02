package practice_package;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.societymanagement.genrics.IPathConstant;

import ApiPomPage.HomePage;
import ApiPomPage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createProjectUsingApiAndVerifyUsingGui {
	@Test(priority =1)
	public void createProject(ITestContext context) {
		
		
			baseURI="http://rmgtestingserver";
			port =8084;
			
			Random rand=new Random();
			int value = rand.nextInt(500);
			String project_name="FlareHr"+value;
			JSONObject obj=new JSONObject();
			obj.put("createdBy","Nitish Babu");
			obj.put("projectName",project_name);
			obj.put("status","Ongoing");
			obj.put("teamSize",12);
			Response res = given()
			.body(obj)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject");
			String pname	=res.jsonPath().get("projectName");
			System.out.println(pname);
			res.then().assertThat().statusCode(201).assertThat().time(Matchers.lessThan(15000l),TimeUnit.MILLISECONDS).log().body()
			.statusCode(201).contentType(ContentType.JSON).log().body();
			context.setAttribute("project_name", pname);
		}
		@Test(priority = 2)
		public void verifyProject(ITestContext context) throws InterruptedException {
			String projectName =(String) context.getAttribute("project_name");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver:8084/");
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp(IPathConstant.APPUSERNAME,IPathConstant.APPPASSWORD);
			Thread.sleep(3000);
			HomePage hp=new HomePage(driver);
			boolean confirmation = hp.VerifyProject(projectName, driver);
			Assert.assertTrue(confirmation);
			System.out.println("Project is Displayed");

		}
}
