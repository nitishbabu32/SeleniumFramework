package com.societymanagement.genrics;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiBaseClass {
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public   RequestSpecification reqst ;
	public ResponseSpecification resp;
	public DataBaseUtility dlib=new DataBaseUtility();

	@BeforeSuite
	public void bsConfig() throws SQLException {
		dlib.connectToDB("projects");
		reqst = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		resp = new ResponseSpecBuilder().expectContentType("application/json").build();
	}

	@AfterSuite
	public void asConfig() throws SQLException {
		dlib.tearDownDB();
		
	}
}
