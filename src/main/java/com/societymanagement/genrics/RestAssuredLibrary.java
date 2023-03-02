package com.societymanagement.genrics;

import io.restassured.response.Response;

public class RestAssuredLibrary {
/**
 * consist of Methods of RestAssured
 * @author hp
 */
	public String getJsonData(Response resp,String path) {
		
	String data=	resp.jsonPath().get(path);
		
		
		return data ;
		
	}
}
