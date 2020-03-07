package com.hrms.utils;

public class Constants {
//	public static final String HRMS_URL = "http://166.62.36.207/Syntax_HRM/symfony/web/index.php/auth/login";
//	public static final String BROWSER = "chrome";
	public static final String AMAZON_URL = "https://www.amazon.com/";
	public static final String TOOLSQA_URL = "https://www.toolsqa.com/automation-practice-switch-windows/";

	// specify path to chrome & gecko driver

	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/drivers/chromedriver.exe";

	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/drivers/geckodriver.exe";

	public static final int PAGE_LOAD_TIME = 30;

	public static final int IMPLICIT_LOAD_TIME = 10;

	public static final int EXPLICIT_LOAD_TIME = 30;
	
	public static final String CREDENTIALS_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/Configs/Configuration.properties";

	public static final String  XL_DATA_FILEPATH="C:\\Users\\Ivania Paz\\eclipse-workspace\\HRMS\\src\\test\\resources\\Testdata\\Book1.xlsx";
	
	public static final String REPORT_FILEPATH="C:\\Users\\Ivania Paz\\eclipse-workspace\\HRMS\\target\\report\\Hrms.html";
	
	public static final String OS_NAME=System.getProperty("os.name");
	
	public static final String USER_NAME=System.getProperty("user.name");
	
	public static final String SCREENSHOTS_FILEPATH=System.getProperty("user.dir")+"/target/screenshots/";
}