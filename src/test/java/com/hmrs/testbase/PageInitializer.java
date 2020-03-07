package com.hmrs.testbase;


import com.hmrs.pages.AddEmployeePageElements;
import com.hmrs.pages.DashBoardPageElements;
import com.hmrs.pages.LeaveListPageElements;
import com.hmrs.pages.LoginPageElements;
import com.hmrs.pages.PersonalDetailsPageElements;
import com.hmrs.pages.ReportsPageElements;
import com.hrms.utils.CommonMethods;

public class PageInitializer extends CommonMethods {
	
	protected static LoginPageElements login;
	protected static DashBoardPageElements dashboard;
	protected static AddEmployeePageElements addEmp;
	protected static LeaveListPageElements leaveList;
	protected static PersonalDetailsPageElements pdetails;
	protected static ReportsPageElements report;
	
	public static void initializeAllPages() {
		login=new LoginPageElements(); 
		dashboard=new DashBoardPageElements();
		addEmp=new AddEmployeePageElements();
		leaveList=new LeaveListPageElements();
		pdetails=new PersonalDetailsPageElements();
		report=new ReportsPageElements();
		
	}

}
