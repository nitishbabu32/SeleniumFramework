package practice_package;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createProjectUsingApiVerifyUsingJDBC {
	@Test(priority =1)
	public void createProject(ITestContext context) {
		
		
			baseURI="http://rmgtestingserver";
			port =8084;
			
			
			Random rand=new Random();
			int value = rand.nextInt(50);
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
			res.then().assertThat().statusCode(201).assertThat().time(Matchers.lessThan(15000l),TimeUnit.MILLISECONDS).log().body();
			String pname=res.jsonPath().get("projectName");
			context.setAttribute("project_name", pname);
			
		}
		@Test(priority =2)
		 public void VerifyProject(ITestContext context) throws SQLException {
			String projectName =(String) context.getAttribute("project_name");
			 Connection con=null;
				//Step 1: Register the database
				try {
					Driver driver1=new Driver();
					DriverManager.registerDriver(driver1);
					//Step 2: get connection for the database
					con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
					//Step 3: Issue create statment
					Statement stmt = con.createStatement();
					String query = "select * from project;";
					//Step4: Execute query
					ResultSet rs = stmt.executeQuery(query);
					boolean flag=false;
					while(rs.next()) {
						String actualProject=rs.getString(4);
						System.out.println(actualProject);
						if(actualProject.equalsIgnoreCase(projectName)) {
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
