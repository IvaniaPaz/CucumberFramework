package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features"
		, glue = {"com.hrms.API.steps.practice"}
		, dryRun = true
		,tags ="@getAllEmployee")

public class APIRunners {
}