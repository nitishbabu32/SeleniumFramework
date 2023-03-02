package practice_package;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.societymanagement.genrics.ApiBaseClass;
import com.societymanagement.genrics.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecUsingBaseTest extends ApiBaseClass{
	@Test
	public void reqSpecBuil() {
		 JSONObject job=new JSONObject();
		 job.put("createdBy", "Nitish Singh");
		 job.put("projectName", "FlareHr"+jlib.getRandom());
		 job.put("status", "Completed");
		 job.put("teamSize", 12);
		 given().spec(reqst).body(job)
		 .when().post("/addProject")
		 .then().spec(resp).log().all();
	}
}
