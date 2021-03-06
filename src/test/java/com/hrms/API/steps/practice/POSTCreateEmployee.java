package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

public class POSTCreateEmployee {

	private static RequestSpecification request;
	public static Object employee_ID;
	private Response response;

	@Given("user calls createEmployee API to verify that an employee was created")
	public void user_calls_createEmployee_API_to_verify_that_an_employee_was_created() {

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);

		request.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
	}

	@When("User retrieves response for createEmployee API")
	public void user_retrieves_response_for_createEmployee_API() {

		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
		response.prettyPrint(); // pretty print prints out response
	}

	@Then("status code is {int} for createEmployeeAPI")
	public void status_code_is_for_createEmployeeAPI(int int1) {
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates employee was created")
	public void user_validates_employee_was_created() {
		response.then().body("Message ", equalTo("Entry Created"));
		response.then().body("Employee[0].emp_firstname", equalTo("Jason"));
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		employee_ID = jsonPathEvaluator.getString("Employee[0].employee_id");
		System.out.println("Employee ID is equal to " + employee_ID);
		//create an instance of jsonPath to be able to get/read the response
		/*JsonPath is an alternative to using XPath for easily getting values from a Object document.
		 * You can regard it as an alternative to XPath for JSON.
		 */
	}
}