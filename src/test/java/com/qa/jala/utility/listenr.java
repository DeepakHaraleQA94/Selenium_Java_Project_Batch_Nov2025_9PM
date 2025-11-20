package com.qa.jala.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jala.qa.ParentLayer.TesBase;




public class listenr extends TesBase implements ITestListener {
	public static utility util;
	public listenr() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	ExtentReports  report = utility.getExtentReport();
	public static ExtentTest eTest;
	
	public void onStart(ITestContext context) {
	  
		System.out.println("testclass execution started ");
		

	  }
	
	
	  public void onTestStart(ITestResult result) {
  
		   System.out.println("test method execution started  "+ result.getMethod().getMethodName());
		   String testName = result.getName();
			eTest = report.createTest(testName);
			eTest.log(Status.INFO,testName+" execution started");
	  
	  }
	
	  
	  
	  public void onTestSuccess(ITestResult result) {
		    System.out.println(" TC method passed" + result.getMethod().getMethodName());
		  }
	
	  public void onTestFailure(ITestResult result) {
		    System.out.println("TC method validation Failed "+ result.getMethod().getMethodName() );
		    try {
				util = new utility();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   try {
			util.screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    		
	  }
	  
	  
	  public void onTestSkipped(ITestResult result) {
		    System.out.println("TC method skipped " + result.getMethod().getMethodName() );
		  }

	  
	public void onFinish(ITestContext context) {
	   System.out.println("Test class execution has been completed ");
	   
	   report.flush();
	  }

	
}
