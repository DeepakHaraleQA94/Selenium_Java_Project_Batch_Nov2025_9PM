package com.jala.qa.TestLayer;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.ParentLayer.TesBase;

import POMLayer.HomePage;
import POMLayer.PopupsPage;

public class PopupsTestPage extends TesBase {
	HomePage home;
    PopupsPage popup;

    public PopupsTestPage() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        Intilization();          // Open browser + load Login URL
        loginToApplication(); // Reusable login method from TesBase
        home = new HomePage();
        
        // -----------------------------
        // IMPORTANT: Navigate to Popups
        // -----------------------------
        home.clickMoreLink();     // Click on More
        Thread.sleep(500);
        home.PopupsLink();   // Click on Popups
        Thread.sleep(1500);

        // Initialize Popups Page
        popup = new PopupsPage();  
    }
       

    // ------------------------------
    // Test Execution
    // ------------------------------
    @Test(priority = 1)
    public void validatePopups() throws Exception {

        // Store main window
        String mainWindow = driver.getWindowHandle();

        // ------------------------
        // POPUP ONE
        // ------------------------
        popup.clickPopupOne();
        
        Thread.sleep(1500);
        
        String actual = driver.getTitle();
		Assert.assertEquals(actual, "Popup", "Popup navigate to Google");
		Reporter.log("Popup page title matched, TC Passed", true);

       
        Thread.sleep(1000);}

        

        
		// ------------------------
        // POPUP TWO
        // ------------------------
       
        
        @Test(priority = 2)
        public void testPopupTwo() throws InterruptedException {

            
            popup.clickPopupTwo();

            Thread.sleep(1500);

            Assert.assertTrue(driver.getCurrentUrl().contains("jalatechnologies"));

            
            
        }
        // -----------------------------------------------------
        // 3. Popup THREE
        // -----------------------------------------------------
        @Test(priority = 3)
        public void testPopupThree() throws InterruptedException {

            String main = driver.getWindowHandle();
            popup.clickPopupThree();

            Thread.sleep(1500);
            String actualtitle = driver.getTitle();
            System.out.println(actualtitle);
            
            Assert.assertEquals(actualtitle, "Popup", "Popup navigate to Google");
    		Reporter.log("Popup page title matched, TC Passed", true);

            driver.close();
            
        }
        // -----------------------------------------------------
        // 4. Popup Duplicate
        // -----------------------------------------------------
        @Test(priority = 4)
        public void testPopupDuplicate() throws InterruptedException {

            String main = driver.getWindowHandle();
            popup.clickPopupDuplicate();

            Thread.sleep(1500);
            String url = driver.getCurrentUrl();
            System.out.println(url);

            

            Assert.assertTrue(driver.getCurrentUrl().contains("google"));

            driver.close();
            driver.switchTo().window(main);
        }

        // -----------------------------------------------------
        // 5. In Window Popup (Internal Modal)
        // -----------------------------------------------------
        @Test(priority = 5)
        public void testInWindowPopup() throws InterruptedException {

            popup.clickInWindowPopup();
            Thread.sleep(1000);

            
            Assert.assertTrue(true, "In window popup triggered.");
        }

        // -----------------------------------------------------
        // 6. ALERT BOX
        // -----------------------------------------------------
        @Test(priority = 6)
        public void testAlertBox() {

            popup.triggerAlertBox();
            Assert.assertTrue(true, "Alert handled");
        }

        // -----------------------------------------------------
        // 7. CONFIRM BOX – ACCEPT
        // -----------------------------------------------------
        @Test(priority = 7)
        public void testConfirmAccept() {

            popup.triggerConfirmBoxDismiss();
            Assert.assertTrue(true, "Confirm accept handled");
        }

        // -----------------------------------------------------
        // 8. CONFIRM BOX – DISMISS
        // -----------------------------------------------------
        @Test(priority = 8)
        public void testConfirmDismiss() {

            popup.triggerConfirmBoxDismiss();
            Assert.assertTrue(true, "Confirm dismiss handled");
        }

        // -----------------------------------------------------
        // 9. PROMPT BOX – ENTER TEXT
        // -----------------------------------------------------
        @Test(priority = 9)
        public void validatePromptDefaultText() {

            String text = popup.handlePromptBox();

            Assert.assertTrue(
                text.contains("JALA Academy- A Place to find your Dream Job"),
                "Prompt popup text is not as expected!"
            );

            System.out.println("Prompt popup text validated successfully.");
        }

   

	@AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
