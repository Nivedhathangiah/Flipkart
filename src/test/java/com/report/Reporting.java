package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMReport(String json) {

		File file = new File(System.getProperty("user.dir") + "\\Reports");

		Configuration configuration = new Configuration(file, "Flipkart Automation");

		configuration.addClassifications("OS-Type", "WIN10");
		configuration.addClassifications("Browser Type", "Chrome");
		configuration.addClassifications("Version", "121");
		configuration.addClassifications("Environment Type", "Test");
		configuration.addClassifications("Sprint", "02s");

		List<String> li = new ArrayList<String>();
		li.add(json);

		ReportBuilder reportBuilder = new ReportBuilder(li, configuration);

		reportBuilder.generateReports();

	}

}
