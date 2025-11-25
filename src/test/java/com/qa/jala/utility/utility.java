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
import org.apache.poi.ss.usermodel.DataFormatter;

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

   public Object[][] getEmployeeDataFromExcel() throws IOException {
   String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\jala\\qa\\DataLayer\\mybook.xlsx";
   
   FileInputStream file = new FileInputStream(path);
   XSSFWorkbook action = new XSSFWorkbook(file);
   
   XSSFSheet sheetname = action.getSheet("EmployeeData"); 
   
   int rowCount = sheetname.getPhysicalNumberOfRows(); 
   int colCount = sheetname.getRow(0).getLastCellNum(); 
   
   // Initialize the 2D array: (rowCount - 1) to exclude the header, colCount for columns
   Object data[][] = new Object[rowCount - 1][colCount];
   
   DataFormatter formatter = new DataFormatter();
   // Loop through rows: start from i=1 to skip the header row
   for (int i = 1; i < rowCount; i++) {
       
       // Loop through columns: start from j=0
       for (int j = 0; j < colCount; j++) {
           
           // Get the cell value, format it as a String, and store it.
           // We use (i - 1) for the array index to start storing data from data[0][j]
    	   data[i - 1][j] = formatter.formatCellValue(sheetname.getRow(i).getCell(j));
       }
   }
   
   action.close(); // Close workbook
   file.close();   // Close file stream

   return data;
}}
