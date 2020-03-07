Feature: Validating Syntax /getAllEmployee.php HRMS API
Background:
Given user generates token
@getAllEmployee
Scenario: Getting all employees using /getAllEmployee.php API
Given user calls getAllEmployee API
When User retrieves response for getAllEmployee API
Then status code is 200 for getAllEmployee API
Then user validates all employees are listed