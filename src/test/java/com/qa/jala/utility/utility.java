package com.qa.jala.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jala.qa.ParentLayer.TesBase;

public class utility extends TesBase {

	
public utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

//	#################### extent report ############################
	
public static ExtentReports getExtentReport() {
		
		ExtentReports report = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}

//########################### screnshot #####################################

   public void screenshot() throws IOException {
	
	      File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      File Destination = new File("C:\\Users\\lenovo\\eclipse-workspace\\Nov2025\\Selenium_Java_Project_Batch_Nov2025_9PM\\screenshot\\img.png");
          FileHandler.copy(source, Destination);
   
   }



}
