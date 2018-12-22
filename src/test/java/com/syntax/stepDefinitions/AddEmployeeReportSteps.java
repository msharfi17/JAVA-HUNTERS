package com.syntax.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.syntax.pages.AddEmployeeReportPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeReportSteps {
	LoginPage login;
	AddEmployeeReportPage report;


@Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" and click$")
	public void i_enter_and_and_click(String userName, String pwd) {
    login= new LoginPage();
    CommonMethods.enterValue(login.username, userName);
    CommonMethods.enterValue(login.password, pwd);
    CommonMethods.click(login.btnLogin);
}

@When("^I click on PIM also I click on Reports$")
public void i_click_on_PIM_also_I_click_on_Reports() {
	 report= new AddEmployeeReportPage();
	 CommonMethods.click(report.linkPIM);
	 CommonMethods.click(report.linkReports);
	
}

@When("^I click add$")
public void i_click_add() throws Throwable {
    CommonMethods.click(report.btnAdd);
}

@When("^I enter \"([^\"]*)\"$")
public void i_enter(String ReportName) throws Throwable {
    CommonMethods.enterValue(report.reportName, ReportName);
    }

@When("^Select \"([^\"]*)\" to SubUnit$")
public void select_to_SubUnit(String SelectionCriteria1)  {
    CommonMethods.selectDropdown(report.selectionCriteria, SelectionCriteria1);
    
}

@When("^click Add Sub Unit$")
public void click_Add_Sub_Unit()  {
   CommonMethods.click(report.btnAddConstraint);
   
}

@When("^Select on \"([^\"]*)\" that matches one of the default employees$")
public void select_on_that_matches_one_of_the_default_employees(String SubUnit)  {
   CommonMethods.selectDropdown(report.subUnit, SubUnit);
}

@When("^Select \"([^\"]*)\" to JobTitle$")
public void select_to_JobTitle(String SelectionCriteria2) {
	CommonMethods.selectDropdown(report.selectionCriteria, SelectionCriteria2);
}

@When("^click Add Job Title$")
public void click_Add_Job_Title()  {
   CommonMethods.click(report.btnAddConstraint);
}

@When("^Select the \"([^\"]*)\" that matches one the default employee$")
public void select_the_that_matches_one_the_default_employee(String JobTitle) {
	CommonMethods.selectDropdown(report.reportJobTitle, JobTitle);
    
}

@When("^Select \"([^\"]*)\" to EmployeeName$")
public void select_to_EmployeeName(String SelectionCriteria3)  {
  
	CommonMethods.selectDropdown(report.selectionCriteria, SelectionCriteria3);
}


@When("^click Add Employee Name$")
public void click_Add_Employee_Name()  {
	CommonMethods.click(report.btnAddConstraint);
 
}

@When("^Enter \"([^\"]*)\" that matches the default employee$")
public void enter_that_matches_the_default_employee(String EmployeeName)  {
	
    CommonMethods.enterValue(report.employeeName, EmployeeName);
    report.employeeName.sendKeys(Keys.ENTER);
}

@Then("^Verify \"([^\"]*)\" Personal is selected$")
public void verify_Personal_is_selected(String DisplayFieldGroups) {
	CommonMethods.selectDropdown(report.displayGroups, DisplayFieldGroups);
    
}

@Then("^Select \"([^\"]*)\" to EmployeeId$")
public void select_to_EmployeeId(String DisplayFields)  {
	CommonMethods.selectDropdown(report.displayFields, DisplayFields);
 
}

@Then("^click Add Employee Id$")
public void click_Add_Employee_Id()  {
  CommonMethods.click(report.btnAddDisply);
  
}

@Then("^Check the box for Display Fields$")
public void check_the_box_for_Display_Fields() {
	CommonMethods.click(report.checkBox);
   
}

@Then("^Click Save$")
public void click_Save() throws InterruptedException {
	Thread.sleep(1000);
	CommonMethods.click(report.saveBtn);
    
}

@Then("^Validate \"([^\"]*)\" appears$")
public void validate_appears(String ReportName)  {
	boolean actualValue = report.resultTable(ReportName);
    Assert.assertTrue(actualValue);
}


@When("^I find existing \"([^\"]*)\" and on click Edit$")
public void i_find_existing_and_on_click_Edit(String reportName)  {
   report.editReport(reportName);
}

@When("^Select on \"([^\"]*)\" that matches a Different default employee$")
public void select_on_that_matches_a_Different_default_employee(String SubUnit1)  {
	CommonMethods.selectDropdown(report.subUnit, SubUnit1);
    
}

@When("^Select the \"([^\"]*)\" that matches the Different default employee$")
public void select_the_that_matches_the_Different_default_employee(String JobTitle1)  {

	CommonMethods.selectDropdown(report.reportJobTitle, JobTitle1);
}


@When("^I find \"([^\"]*)\" and click on Check Box$")
public void i_find_and_click_on_Check_Box(String ReportName) throws InterruptedException  {
    report.deleteReport(ReportName);
}

@Then("^Click Delete$")
public void click_Delete()  {
    CommonMethods.click(report.deleteBtn);
}

@Then("^click Ok$")
public void click_Ok()   {
  CommonMethods.click(report.okConfirmBtn);
}

@Then("^Verify \"([^\"]*)\" does not Exist$")
public void verify_does_not_Exist(String ReportName) throws InterruptedException  {
    report.deleteReport(ReportName);
}



}





