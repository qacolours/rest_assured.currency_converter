package resources;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.response.*;
import io.restassured.RestAssured.*;

public class reusables {

	public String getDataProperties(String propertyName) throws Exception {
		
		FileInputStream oFile = new FileInputStream("C:\\learning\\rest_assured\\currency_converter\\src\\main\\java\\resources\\data.properties");
		Properties oProp = new Properties();
		oProp.load(oFile);
		
		String propertyValue = oProp.getProperty(propertyName);
		
		return propertyValue;
	}
	
	
	public Response processGetCall(String apiExtension) throws Exception {

		Response oResp = given().
							get(apiExtension);
		
		return oResp;
	}
	
	public void validateJsonSchema(Response obj_response) {
		
		obj_response
				.then()
				.assertThat()
				.body(matchesJsonSchemaInClasspath("currencyConverter_schema.json"));
		
		System.out.println("The JSON Schema for the Response JSON has been validated successfully");
	}
	
	public int getStatusCodeOfResponse(Response obj_response) {
		int statusCode = obj_response.
								getStatusCode();
		
		return statusCode;
	}
}
