package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;

public class GETOneEmployeeAPISteps {
	private static RequestSpecification request;
	private Response response;

	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {
		request = given().header("Content-Type", "application/json")
				.header("Authorization", SyntaxAPIAuthenticationSteps.Token)
				.param("employee_id", POSTCreateEmployee.employee_ID);
	}

	@When("User retrieves response for getOneEmployee API")
	public void user_retrieves_response_for_getOneEmployee_API() {
		response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
		response.prettyPrint();
	}

	@Then("status code is {int} for getOneEmployee API")
	public void status_code_is_for_getOneEmployee_API(int int1) {
		response.then().assertThat().statusCode(int1);
		
	}

	@Then("user validates created employee exists")
	public void user_validates_created_employee_exists() {
		
		//1st way - using Matchers
		response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployee.employee_ID));

		//2nd way - To assert 
		/*first create instance of Json path variable we created we can get
		 * 
		 */
		JsonPath jsonPathEvaluator = response.jsonPath();

		String actualEmployeeID = jsonPathEvaluator.getString("employee[0].employee_id");
		System.out.println("Actual Employee ID is: " + actualEmployeeID);
		
		//Assert.assertEquals("Verifying Employee IDs", POSTCreateEmployeeAPI.employee_ID, actualEmployeeID);

		//3rd way - try catch block (optional)
		try {
			Assert.assertEquals("Verify Employee ID's", POSTCreateEmployee.employee_ID, actualEmployeeID);
		} catch (AssertionError e) {
			System.out.println("Employee ID's DO NOT MATCH");
		}
		System.out.println("EMPLOYEE ID's MATCH");

	}
}
