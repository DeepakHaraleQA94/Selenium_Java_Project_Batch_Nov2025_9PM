package POMLayer;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jala.qa.ParentLayer.TesBase;

public class MenuPage extends TesBase {

    // Top Menu Items
    @FindBy(xpath = "(//a[contains(text(),'Testing')])[1]")
    WebElement menuTesting;

    @FindBy(xpath = "(//a[contains(text(),'Java')])[1]")
    WebElement menuJava;

    @FindBy(xpath = "(//a[contains(text(),'.Net')])[1]")
    WebElement menuDotnet;
    
    @FindBy(xpath = "//a[@id='b4']")
    WebElement menuDatabase;

    // ------- SUB MENUS under Testing -------
    @FindBy(xpath = "//a[contains(text(),'Selenium')]")
    WebElement seleniumSub;

    @FindBy(xpath = "//a[contains(text(),'Manual Testing')]")
    WebElement manualSub;

    @FindBy(xpath = "//a[contains(text(),'DB Testing')]")
    WebElement dbSub;

    @FindBy(xpath = "//a[contains(text(),'Unit Testing')]")
    WebElement unitSub;
    
    // SUB MENUS under JAVA
    @FindBy(xpath = "//a[contains(text(),'Adv Java')]")
    WebElement advJava;

    @FindBy(xpath = "//a[contains(text(),'Core Java')]")
    WebElement coreJava;

    @FindBy(xpath = "//a[contains(text(),'Spring')]")
    WebElement springMenu;

    @FindBy(xpath = "//a[contains(text(),'Hibernate')]")
    WebElement hibernateMenu;
    
 // .NET submenu
    @FindBy(xpath = "//a[contains(text(),'ASP.NET')]")
    WebElement aspNet;

    @FindBy(xpath = "//a[contains(text(),'C#')]")
    WebElement cSharp;

    @FindBy(xpath = "//a[contains(text(),'ADO.NET')]")
    WebElement adoNet;

    @FindBy(xpath = "//a[contains(text(),'MVC')]")
    WebElement mvc;

    // DATABASE submenu
    @FindBy(xpath = "//a[contains(text(),'SQL')]")
    WebElement sql;

    @FindBy(xpath = "//a[contains(text(),'My Sql')]")
    WebElement mySql;

    @FindBy(xpath = "//a[contains(text(),'Oracle')]")
    WebElement oracle;

    @FindBy(xpath = "//a[contains(text(),'H2')]")
    WebElement h2;



    public MenuPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    // ACTION METHODS
 // --------------- TOP MENU CLICKS -----------------

    public void clickTestingMenu() {
        menuTesting.click();;
    }

    public void clickJavaMenu() {
        menuJava.click();
    }

    public void clickDotNetMenu() {
        menuDotnet.click();
    }

    public void clickDatabaseMenu() {
        menuDatabase.click();
    }



    
}


