package practice_package;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.societymanagement.genrics.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecBuil {
@Test
public void reqSpecBuil() {
	RequestSpecification reqst = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
			.setContentType(ContentType.JSON).build();
	 ResponseSpecification resp = new ResponseSpecBuilder().expectContentType("application/json").build();
	 JavaUtility jlib=new JavaUtility();
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
