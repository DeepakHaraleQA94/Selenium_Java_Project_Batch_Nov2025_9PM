package com.qa.jala.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

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
	      File Destination = new File(System.getProperty("user.dir" )+"\\screenshot\\img1.png");
          FileHandler.copy(source, Destination);
   
   }

//   ########################### Data Provider ###########################
   
   public Object[][] getDataFromExcel() throws IOException {
//	String path = "C:\\Users\\lenovo\\eclipse-workspace\\Automation_project\\mybook.xlsx";
	   String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\jala\\qa\\DataLayer\\Jala_Credential.xlsx";
	   FileInputStream file = new FileInputStream(path);
	     XSSFWorkbook action = new XSSFWorkbook(file);
	      XSSFSheet sheetname = action.getSheet("Sheet1");
	      Object data[][]= new Object[sheetname.getLastRowNum()][sheetname.getRow(0).getLastCellNum()];
	      for(int i=1; i<sheetname.getLastRowNum(); i++) {
	    	  
	    	  for(int j=0; j<sheetname.getRow(0).getLastCellNum();j++) {
//	    		  System.out.println(sheetname.getRow(i).getCell(j).toString());
	    		   data[i][j] = sheetname.getRow(i).getCell(j).getStringCellValue();
	    	  }
	      }
	   return data;
	   
   }
   
   
   


}
