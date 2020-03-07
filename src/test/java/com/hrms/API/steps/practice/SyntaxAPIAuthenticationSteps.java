package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

public class SyntaxAPIAuthenticationSteps {

	private Response response;
	public static String Token;
	private static RequestSpecification request;
	String generateTokenURI = "http://18.232.148.34/syntaxapi/api/generateToken.php";

	@Given("user generates token")
	public void user_generates_token() {

		request = given().header("Content-Type", "application/json"); // specifying content type stored into request
																		// specification

		System.out.println(request.log().all()); // which will print out the logs headers, etc
		// everything that we requested that was sent will be printed

		// called on readJson method(in CommonMethods class) which is static and to
		// convert it into string to be ale to read
		response = request.body(CommonMethods.readJson(APIConstants.GENERATE_TOKEN_JSON))
				.when().post(generateTokenURI); // sending																																																			// call
		System.out.println(response.prettyPrint());

		Token = "Bearer "+response.jsonPath().getString("token");

		System.out.println(Token);

	}
}
