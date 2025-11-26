package POMLayer;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.ParentLayer.TesBase;

public class PopupsPage extends TesBase {

    
    @FindBy(xpath = "//a[contains(text(),'Popup One')]")
    WebElement PopupOne;
   
    @FindBy(xpath = "//a[contains(text(),'Popup Two')]")
    WebElement PopupTwo;
   
    @FindBy(xpath = "//a[contains(text(),'Popup Three')]")
    WebElement PopupThree;

    @FindBy(xpath = "//a[contains(text(),'Popup Duplicate')]")
    WebElement PopupDuplicate;

    @FindBy(xpath = "//a[contains(text(),'In Window Popup')]")
    WebElement InWindowPopup;

    @FindBy(id="alertBox")
    WebElement alertBox;

    @FindBy(id="confirmBox")
    WebElement confirmBox;
 
    @FindBy(id="promptBtn")
    WebElement PromptBox;


    public PopupsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    // ### ACTION METHODS ###

    public void clickPopupOne() {
        PopupOne.click();
    }

    public void clickPopupTwo() {
        PopupTwo.click();
    }

    public void clickPopupThree() {
        PopupThree.click();
    }

    public void clickPopupDuplicate() {
        PopupDuplicate.click();
    }

    public void clickInWindowPopup() {
        InWindowPopup.click();
    }

    public void triggerAlertBox() {
        alertBox.click();
        driver.switchTo().alert().accept();
    }
    
    public void triggerConfirmBoxDismiss() {
        confirmBox.click();
        driver.switchTo().alert().dismiss();
    }
    
    public String handlePromptBox() {

        // Click the prompt button
        PromptBox.click();

        // Switch to alert prompt
        Alert alert = driver.switchTo().alert();

        // Read the prompt default text
        String text = alert.getText();
        System.out.println("Prompt Default Text = " + text);

        // Close prompt
        alert.accept();

        return text;
    }

}