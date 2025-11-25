package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.jala.qa.ParentLayer.TesBase;
import com.qa.jala.utility.listenr;
import com.qa.jala.utility.utility;

import POMLayer.LoginPage;
import POMLayer.CreateEmployeePage;
@Listeners(listenr.class)
public class EmployeeCreateTestPage extends TesBase {

    LoginPage login;
    CreateEmployeePage createEmp;

    public EmployeeCreateTestPage() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        Intilization();   
        login = new LoginPage();

        // LOGIN FIRST
        login.enterUname(prop.getProperty("Uname"));
        login.enterPass(prop.getProperty("Pass"));
        login.clickOnLoginBtn();
        Thread.sleep(3000);

        // Navigate to Create Page
        driver.get("https://magnus.jalatechnologies.com/Employee/Create");
    }
    
    @DataProvider
    public Object[][] getEmployeeData() throws IOException {
        // Assuming 'utility' is the class containing the method to read Excel data
        utility util = new utility();
        // You may need to create a specific method in utility to read employee data
        // For example, utility.getEmployeeDataFromExcel("SheetName")
        Object[][] data = util.getEmployeeDataFromExcel(); // Replace with your actual method call
        return data;
    }
    
    //Test Method using DataProvider
    // The @Test method now accepts parameters from the DataProvider
    @Test(dataProvider = "getEmployeeData")
    public void validateEmployeeCreatePage(String firstName, String lastName, String email, 
                                           String mobile, String dob, String gender, 
                                           String address, String country, String city, 
                                           String skill) throws Exception {
        
        createEmp = new CreateEmployeePage();

        // Fill Employee Create Form with data from DataProvider
        createEmp.enterFirstName(firstName);
        createEmp.enterLastName(lastName);
        createEmp.enterEmail(email);
        createEmp.enterMobile(mobile);
        createEmp.enterDOB(dob);
        createEmp.selectGender(gender);
        createEmp.enterAddress(address);
        createEmp.selectCountry(country);
        Thread.sleep(1000); 
        createEmp.selectCity(city);
        
        Thread.sleep(3000);
        createEmp.selectSkill(skill);
        Thread.sleep(3000);
        createEmp.clickSubmit();
        Thread.sleep(3000);

  
        String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Search Employee", "Search Employee page title not matched, TC failed");
        Reporter.log("Search Employee page title matched, TC Passed", true);

       
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}

