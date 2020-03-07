package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITest {

	@Test
	public void getAllJobTitles() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzMzMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODUwOCwidXNlcklkIjoiNzQifQ.rau3mll0O7EJaj8a3XyQfEhlH4RTwlm0QEIOJVinD34")
				.when().get("http://18.232.148.34/syntaxapi/api/jobTitle.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}

	@Test
	public void getOneEmployee() {
		Response response = RestAssured.given().param("employee_id", "05633A").contentType("application/json").header(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzMzMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODUwOCwidXNlcklkIjoiNzQifQ.rau3mll0O7EJaj8a3XyQfEhlH4RTwlm0QEIOJVinD34")
				.when().get("http://18.232.148.34/syntaxapi/api/getOneEmployee.php");
		response.prettyPrint();

		int actualResponse = response.getStatusCode();
		System.out.println(actualResponse);

	}

	@Test
	public void getAllEmployeeStatus() {
		Response rep = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzMzMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODUwOCwidXNlcklkIjoiNzQifQ.rau3mll0O7EJaj8a3XyQfEhlH4RTwlm0QEIOJVinD34")
				.when().get("http://18.232.148.34/syntaxapi/api/employeeStatus.php");
		rep.prettyPrint();

		int actualResponse = rep.getStatusCode();
		System.out.println(actualResponse);
	}

	@Test
	public void createEmployee() {
		Response rep = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzMzMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODUwOCwidXNlcklkIjoiNzQifQ.rau3mll0O7EJaj8a3XyQfEhlH4RTwlm0QEIOJVinD34")
				.param("emp_firstname", "Brad")
				.param("emp_lastname", "Pitt")
				.param("emp_middle_name", "M")
				.param("emp_gender", "1")
				.param("emp_birthday", "1995-08-30")
				.param("emp_status", "Employee")
				.param("emp_job_title", "Developer")
				.when()
				.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");

		rep.prettyPrint();
		int actStatusCode = rep.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(201, actStatusCode);
	}
	
	@Test
	public void getAllEmployees() {
		Response rep=RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzMzMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODUwOCwidXNlcklkIjoiNzQifQ.rau3mll0O7EJaj8a3XyQfEhlH4RTwlm0QEIOJVinD34")
		.when().get("http://18.232.148.34/syntaxapi/api/getAllEmployees.php");
		rep.prettyPrint();
		int actualCode=rep.getStatusCode();
		System.out.println(actualCode);
	}
	
	
	
}

