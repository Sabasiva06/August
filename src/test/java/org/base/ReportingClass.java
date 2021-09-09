package org.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportingClass {

	public static void JVMReportGeneration(String json) {

		File file = new File("C:\\Users\\vels\\Music\\CucumberPro\\CucumberReporting");

		Configuration configuration = new Configuration(file, "Facebook");
		configuration.addClassifications("Platform", "Win-10");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Sprint No", "32");

		List<String> li = new ArrayList<String>();
		li.add(json);

		ReportBuilder builder = new ReportBuilder(li, configuration);
		builder.generateReports();

	}

}
