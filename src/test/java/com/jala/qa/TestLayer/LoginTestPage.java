package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.ParentLayer.TesBase;
import com.qa.jala.utility.utility;

import POMLayer.LoginPage;


public class LoginTestPage extends TesBase{
	POMLayer.LoginPage login;
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() {
		Intilization();
		
	}
	
//	@Test
//	public void add() {
//		System.out.println(System.getProperty("user.dir"));
//	}
//	
	@DataProvider
	public Object[][] addData() throws IOException {
		utility util = new utility();
		 Object[][] data1 = util.getDataFromExcel();
		 return data1;
	}
	
	@Test(dataProvider = "addData")
	public void validateLoginPage(String uname, String pass) throws IOException, InterruptedException {
		 login = new LoginPage();
		 login.enterUname(uname);
		 login.enterPass(pass);
		 login.clickOnLoginBtn();
		 Thread.sleep(3000);
		 String actual = driver.getTitle();
		Assert.assertEquals(actual, "Magnus", "Home page title not matched, TC failed");
		Assert.assertEquals(actual, "Magnus", "Home page title matched, TC passed");
		Reporter.log("Home page title matched, TC Passed", true);
		Reporter.log("Home page title not matched, TC failed", false);
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}