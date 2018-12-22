#Author: MohamedSharfi
Feature: Employee feature

  Background: 
    Given I enter "admin" and "admin123" and click

  
  Scenario Outline: Add employee reports
    When I click on PIM also I click on Reports
    And I click add
    And I enter "<ReportName>"
    And Select "<SelectionCriteria3>" to EmployeeName
    And click Add Employee Name
    And Enter "<EmployeeName>" that matches the default employee
    And Select "<SelectionCriteria1>" to SubUnit
    And click Add Sub Unit
    And Select on "<SubUnit>" that matches one of the default employees
    And Select "<SelectionCriteria2>" to JobTitle
    And click Add Job Title
    And Select the "<JobTitle>" that matches one the default employee
    Then Verify "<DisplayFieldGroups>" Personal is selected
    And Select "<DisplayFields>" to EmployeeId
    And click Add Employee Id
    And Check the box for Display Fields
    Then Click Save
    Then Validate "<ReportName>" appears

    Examples: 
      | ReportName | SelectionCriteria3 | EmployeeName  | SelectionCriteria1 | SubUnit | SelectionCriteria2 | JobTitle     | DisplayFieldGroups | DisplayFields |
      | JavaHunter | Employee Name      | Hannah Flores | Sub Unit           | IT      | Job Title          | IT Executive | Personal           | Employee Id   |

 
  Scenario Outline: 
    When I click on PIM also I click on Reports
    And I find existing "<ReportName>" and on click Edit
    And Select on "<SubUnit1>" that matches a Different default employee
    And Select the "<JobTitle1>" that matches the Different default employee
    And Enter "<EmployeeName1>" that matches the default employee
    Then Verify "<DisplayFieldGroups>" Personal is selected
    And Check the box for Display Fields
    Then Click Save
    Then Validate "<ReportName>" appears

    Examples: 
      | ReportName | SubUnit1 | JobTitle1       | EmployeeName1 | DisplayFieldGroups |
      | JavaHunter | Finance  | Finance Manager | Hannah Flores | Personal           |

  
  Scenario Outline: 
    When I click on PIM also I click on Reports
    And I find "<ReportName>" and click on Check Box
    Then Click Delete
    And click Ok
    Then Verify "<ReportName>" does not Exist

    Examples: 
      | ReportName |
      | JavaHunter |
