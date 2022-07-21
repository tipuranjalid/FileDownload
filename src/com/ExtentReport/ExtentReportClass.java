package com.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	ExtentReports extent;
	ExtentSparkReporter spark;

	@BeforeClass
	public void startTest() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\ExtentReportResults.html");
//		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
//		test = report.startTest("ExtentReportClass");
		extent.attachReporter(spark);
	}

	@Test
	public void extentReportDemo() {

//		ExtentTest test = extent.createTest("MyFirstTest");
//		test.pass("Pass");

		// fluent
		ExtentTest test = extent.createTest("MyFirstTest").pass("Pass");
		ExtentTest test1 = extent.createTest("MyFirstTest1").fail("Fail",
				MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		ExtentTest test2 = extent.createTest("MyFirstTest2").info("Info");
		extent.createTest("ScreenCapture").addScreenCaptureFromPath("extent.png")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

	}

	@AfterClass
	public void endTest() throws IOException {

		extent.flush();
		Desktop.getDesktop().browse(new File("ExtentReportResults.html").toURI());

	}
}
