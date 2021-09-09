package org.test;

import org.base.ReportingClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, glue = {
		"org.step" }, dryRun = false, monochrome = true, plugin = { "pretty",
				"html:C:\\Users\\vels\\Music\\CucumberPro\\ReportGeneraation",
				"json:C:\\Users\\vels\\Music\\CucumberPro\\ReportGeneraation\\fb.json",
				"junit:C:\\Users\\vels\\Music\\CucumberPro\\ReportGeneraation\\fb.xml",
				"json:C:\\Users\\vels\\Music\\CucumberPro\\CucumberReporting\\fb.json" }, snippets = SnippetType.CAMELCASE)
public class TestRunner {

	@AfterClass
	public static void afterClass() {

		ReportingClass.JVMReportGeneration("C:\\Users\\vels\\Music\\CucumberPro\\CucumberReporting\\fb.json");
	}

	public void muliplty() {
		System.out.println("Product of two number");

	}

	public void division() {
		System.out.println("Dicvision if Two numbers");

	}
}