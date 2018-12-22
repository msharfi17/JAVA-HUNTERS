package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeeReportPage extends BaseClass {

	@FindBy(linkText = "PIM")
	public WebElement linkPIM;

	@FindBy(linkText = "Reports")
	public WebElement linkReports;

	@FindBy(id = "report_report_name")
	public WebElement reportName;

	@FindBy(id = "btnAdd")
	public WebElement btnAdd;

	@FindBy(id = "report_criteria_list")
	public WebElement selectionCriteria;

	@FindBy(id = "btnAddConstraint")
	public WebElement btnAddConstraint;

	@FindBy(id = "report_sub_unit")
	public WebElement subUnit;

	@FindBy(id = "report_job_title")
	public WebElement reportJobTitle;

	@FindBy(id = "btnAddDisplayField")
	public WebElement btnAddDisply;

	@FindBy(id = "employee_name_empName")
	public WebElement employeeName;

	@FindBy(id = "report_display_groups")
	public WebElement displayGroups;

	@FindBy(id = "report_display_field_list")
	public WebElement displayFields;

	@FindBy(id = "report_display_field_list")
	public WebElement addButton;

	@FindBy(id = "display_group_1")
	public WebElement checkBox;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(id = "search_search")
	public WebElement seachbtn;
	
	@FindBy (xpath = "//table[@id='resultTable']/tbody")
	private WebElement tableBody;
	
	@FindBy (id= "btnDelete")
	public WebElement deleteBtn;
	
	@FindBy (id= "dialogDeleteBtn")
	public WebElement okConfirmBtn;

	public AddEmployeeReportPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean resultTable(String expected) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		boolean actual = false;
		for (WebElement row : rows) {
			String cellData = row.getText();
			if (cellData.equals(expected)) {
				actual = true;
			}

		}
		return actual;

	}

	
	
	
	public void editReport(String reportName) {
		
		List<WebElement> rows =tableBody.findElements(By.xpath( "tr"));
		
		for (WebElement row : rows) {
			String cellData = row.getText();
			if (cellData.contains(reportName)) {
				
				row.findElement(By.linkText("Edit")).click();
				break;
			}
		}
		}
		
		public void deleteReport(String reportName) throws InterruptedException {
			
			List<WebElement> rows =tableBody.findElements(By.xpath( "tr"));
			
			for (WebElement row : rows) {
				String cellData = row.getText();
				if (cellData.contains(reportName)) {
					
					Thread.sleep(5000);
					//driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td/input")).click();
					List<WebElement> checkbox = row.findElements(By.tagName("input"));
					System.out.println(checkbox.size());
					checkbox.get(0).click();
					break;
					
					
					
				}

			}

	}

	
	

		public boolean deleteResultTable(String expected) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
			boolean actual = true;
			for (WebElement row : rows) {
				String cellData = row.getText();
				if (cellData.equals(expected)) {
					actual = false;
				}

			}
			return actual;

		}




}
