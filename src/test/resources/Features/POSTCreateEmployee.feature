Feature: Validationg Syntax HRMS API's 
Background:
Given user generates token

@APITEST
Scenario: This test will check to see if an employee is created
Given user calls createEmployee API
When User retrieves response 
Then Status code is 200
Then User validates employee is created

