package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.ParentLayer.TesBase;

import POMLayer.HomePage;

public class HomeTestPage extends TesBase {

    HomePage home;

    public HomeTestPage() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        Intilization();
        loginToApplication();     // Reusable login method
        home = new HomePage();
    }

    // ---------------------------
    // Validate Home Page Loaded
    // ---------------------------
    @Test(priority = 1)
    public void validateHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Magnus", "Home page title mismatch");
        Reporter.log("Home Page is loaded successfully.", true);
    }

    // ---------------------------
    // Validate Employee --> Create
    // ---------------------------
    @Test(priority = 2)
    public void validateEmployeeCreateNavigation() throws InterruptedException {
        home.clickEmployeLink();
        Thread.sleep(500);
        home.clickCreateLink();
        Thread.sleep(1500);

        

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Employee/Create"), "Navigation to Create page failed");

        Reporter.log("Employee--> Create page opened successfully.", true);
    }

    
    

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
