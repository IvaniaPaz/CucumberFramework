package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hmrs.testbase.BaseClass;

public class CommonMethods extends BaseClass {

	/**
	 * use this method in need of opening browser and target url
	 * 
	 * @param browser The desired browser
	 * @param url     The desired url
	 * @return
	 */

	/**
	 * This method will accept the alert
	 *
	 * @throws will throw an NoAlertPresentException if alert is not present
	 */

	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}

	/**
	 * This method will dismiss the alert
	 *
	 * @throws will throw an NoAlertPresentException if alert is not present
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}

	/**
	 * This method will get a text from the alert
	 * 
	 * @return text of the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not present");
			return null;
		}

	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will click on the element using JSExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will scroll page until specified element
	 * 
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll page up
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will take a screenshot
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		// creates picture in the form of byte so we can attach it to our scenario
		byte[] picture = ts.getScreenshotAs(OutputType.BYTES);// output in a form of byte that stored in array of bytes

		// taking a picture in the form of file
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMdd_HHmmss");
		String timeStamp = sdf.format(date.getTime());

		File file = ts.getScreenshotAs(OutputType.FILE);
		String scrnshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + timeStamp + ".png";
		try {
			FileUtils.copyFile(file, new File(scrnshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
		return picture;
	}

	/**
	 * This method will enter text
	 * 
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_LOAD_TIME);
		return wait;
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForInvisability(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * This method will select value from DropDown DD
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDdValue(WebElement element, String visibleText) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("Value" + visibleText + " was not found in the drop down");
		}
	}

	/**
	 * This method will select value from the Drop Down DD
	 * 
	 * @param element
	 * @param index
	 */

	public static void selectDdValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isFound = false;
		if (options.size() > index) {
			select.selectByIndex(index);
			isFound = true;
		}
		if (!isFound) {
			System.out.println("Value with index" + index + " was not selected");
		}
	}

	/**
	 * This method will click on the radio based on the text
	 * 
	 * @param elements
	 * @param radioText
	 */
	public static void clickRadio(List<WebElement> elements, String radioText) {
		for (WebElement el : elements) {
			if (el.getText().equals(radioText)) {
				el.click();
				break;
			}
		}
	}

	static String jsonFile; //created global variable, it gets assigned 
// this will read Json file, it will read and convert it 
	public static String readJson(String fileName) {
		try {

			jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}
}