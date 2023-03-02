package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.societymanagement.genrics.IPathConstant;

import ApiPomPage.HomePage;
import ApiPomPage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createProjectUsingSeleniumVerifyUsingJdbc {
	public static void main(String[] args) throws InterruptedException, SQLException {
		String project_name="FlareHrNi44tish1255355";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(IPathConstant.APPUSERNAME,IPathConstant.APPPASSWORD);
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		hp.createProject(project_name, "Nitish Babu");
		Connection con=null;
		//Step 1: Register the database
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
			//Step 2: get connection for the database
			con = DriverManager.getConnection(IPathConstant.RMGDBURL,IPathConstant.RMGUSERNAME,IPathConstant.RMGPASSWORD);
			//Step 3: Issue create statment
			Statement stmt = con.createStatement();
			String query = "select * from project;";
			//Step4: Execute query
			ResultSet rs = stmt.executeQuery(query);
			boolean flag=false;
			while(rs.next()) {
				String actualProject=rs.getString(4);
				System.out.println(actualProject);
				if(actualProject.equalsIgnoreCase(project_name)) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println("Project is created");
			}else {
				System.out.println("Project is not created");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

	}
}
