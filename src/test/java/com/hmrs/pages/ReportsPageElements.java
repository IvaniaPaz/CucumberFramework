package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPageElements {
	
	@FindBy(xpath="//input[@value='Reset']") //resetbtn
	public WebElement resetBtn;

	@FindBy(xpath="//input[@value='Reset']") //delete button
	public WebElement deleteBtn;
	
	@FindBy(id="//input[@value='Add']") //add button
	public WebElement AddBtn;
	
	@FindBy(id="//input[@value='Search']") //search button 
	public WebElement searchBtn;
	
	@FindBy(id="//input[@id='search_search']") //report tab
	public WebElement reprt;
	
	@FindBy(id="ohrmList_chkSelectAll") 
	public WebElement selectAll;
	
	@FindBy(xpath="//a[text()='Report Name']") //report name
	public WebElement searchResultReportname;
	
}
