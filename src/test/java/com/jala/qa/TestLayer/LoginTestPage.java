package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.ParentLayer.TesBase;

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
	
//	@Test(dependsOnMethods = "validateLoginPage")
//	public void add() {
//		System.out.println("hi");
//	}
	
	
	@Test
	public void validateLoginPage() throws IOException, InterruptedException {
		 login = new LoginPage();
		 login.enterUname(prop.getProperty("Uname"));
		 login.enterPass(prop.getProperty("Pass"));
		 login.clickOnLoginBtn();
		 Thread.sleep(3000);
		 String actual = driver.getTitle();
		Assert.assertEquals(actual, "Magnus", "Home page title not matched, TC failed");
		Reporter.log("Home page title matched, TC Passed", true);
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}