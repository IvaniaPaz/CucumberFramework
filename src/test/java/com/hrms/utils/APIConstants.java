package com.hrms.utils;

public class APIConstants {

	public static final String CREATE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/createEmployee.php";

	public static final String GET_ONE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/getOneEmployee.php";
	
	public static final String UPDATE_EMPLOYEE_URI="http://18.232.148.34/syntaxapi/api//updateEmployee.php";
	
	public static final String GET_ALL_EMPLOYEES_URI="http://18.232.148.34/syntaxapi/api/getAllEmployees.php";
	
	public static final String GET_ALL_JOB_TITLE_URI= "http://18.232.148.34/syntaxapi/api/jobTitle.php";
	
	public static final String GET_ALL_EMPLOYEE_STATUS_URI="http://18.232.148.34/syntaxapi/api/employeeStatus.php";
	 
	public static final String UPDATE_EMPLOYEE_JSON= System.getProperty("user dir")
			+"src/test/resources/JsonFiles/updateEmployee.json";

	public static final String CREATE_EMPLOYEE_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createEmployee.json";
	public static final String GENERATE_TOKEN_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/generateToken.json";

}
