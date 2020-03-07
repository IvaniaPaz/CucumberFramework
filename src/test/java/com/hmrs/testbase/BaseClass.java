package com.hmrs.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {

	public static WebDriver driver;
	
	public static void setUp() { // precondition

		ConfigsReader.readProperties(com.hrms.utils.Constants.CREDENTIALS_FILEPATH);
		switch (ConfigsReader.getProperties("browser").toLowerCase()) { // browser is indicated in our constant class
																		// and
																		// we are converting it to lowercase
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("Browser is not supported");
		}
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperties("url"));
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}