package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.ParentLayer.TesBase;

import POMLayer.LoginPage;
import POMLayer.CreateEmployeePage;

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

    @Test
    public void validateEmployeeCreatePage() throws Exception {
        
        createEmp = new CreateEmployeePage();

        // Fill Employee Create Form
        createEmp.enterFirstName("Sheetal");
        createEmp.enterLastName("Raibole");
        createEmp.enterEmail("sheetal@test.com");
        createEmp.enterMobile("9876543210");
        createEmp.enterDOB("10/03/1997");
        createEmp.selectGender("Female");
        createEmp.enterAddress("Koregaon Park 411014");
        createEmp.selectCountry("India");
        Thread.sleep(1000); 
        createEmp.selectCity("Pune");
        
        Thread.sleep(3000);
        createEmp.selectSkill("QA-Automation");
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

