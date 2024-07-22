package com.flipkart.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;
import com.utility.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"json:src\\test\\resources\\ReportJSON\\flipkart.json" }, dryRun = false, tags = "@product", features = "src\\test\\resources", glue = "com.flipkart.stepdefinition")
public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void reports() {

		Reporting.generateJVMReport(getProjectPath() + "\\src\\test\\resources\\ReportJSON\\flipkart.json");

	}

}
