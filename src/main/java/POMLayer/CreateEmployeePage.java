package POMLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import com.jala.qa.ParentLayer.TesBase;

public class CreateEmployeePage extends TesBase {

    // -----------------------------
    // 1. Object Repository (PageFactory)
    // -----------------------------

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "EmailId")
    WebElement email;

    @FindBy(id = "MobileNo")
    WebElement mobile;

    @FindBy(id = "DOB")
    WebElement dob;

    @FindBy(id = "rdbMale")
    WebElement maleRadio;

    @FindBy(id = "rdbFemale")
    WebElement femaleRadio;

    @FindBy(id = "Address")
    WebElement address;

    @FindBy(id = "CountryId")
    WebElement countryDropdown;

    @FindBy(id = "CityId")
    WebElement cityDropdown;

    // Skills Checkboxes
    @FindBy(id = "chkSkill_5") WebElement skillAWS;
    @FindBy(id = "chkSkill_3") WebElement skillDevOps;
    @FindBy(id = "chkSkill_2") WebElement skillFullStackDeveloper;
    @FindBy(id = "chkSkill_4") WebElement skillMiddleware;
    @FindBy(id = "chkSkill_1") WebElement skillQA;
    @FindBy(id = "chkSkill_6") WebElement skillWebServices;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement SaveBtn;


    // -----------------------------
    // 2. Constructor
    // -----------------------------
    public CreateEmployeePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    // -----------------------------
    // 3. Action Methods
    // -----------------------------

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterMobile(String mob) {
        mobile.sendKeys(mob);
    }

    public void enterDOB(String date) {
        dob.sendKeys(date);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            maleRadio.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femaleRadio.click();
        }
    }

    public void enterAddress(String add) {
        address.sendKeys(add);
    }

    public void selectCountry(String country) {
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void selectCity(String city) {
        new Select(cityDropdown).selectByVisibleText(city);
    }

    public void selectSkill(String skillName) {

        switch (skillName.toLowerCase()) {
        case "aws":
            skillAWS.click();
            break;
        case "devops":
            skillDevOps.click();
            break;
        case "Full Stack Developer":
            skillFullStackDeveloper.click();
            break;
        case "middleware":
            skillMiddleware.click();
            break;
        case "qa-automation":
            skillQA.click();
            break;
        case "webservices":
            skillWebServices.click();
            break;
        }
    }

    public void clickSubmit() {
        SaveBtn.click();
    }


    
}
