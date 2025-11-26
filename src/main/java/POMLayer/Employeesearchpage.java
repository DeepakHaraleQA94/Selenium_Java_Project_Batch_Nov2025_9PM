package POMLayer;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.ParentLayer.TesBase;

public class Employeesearchpage extends TesBase {

    // -----------------------------
    // 1. Object Repository (Locators)
    // -----------------------------

    @FindBy(id = "Name")
     WebElement nameInput;

    @FindBy(id = "MobileNo")
     WebElement mobileNoInput;

    @FindBy(id = "btnSearch")
     WebElement searchButton;

    @FindBy(id = "btnClear")
     WebElement clearButton;

    @FindBy(linkText = "Add Employee")
     WebElement addEmployeeButton;

    @FindBy(tagName = "table")
     WebElement employeeTable;

    // -----------------------------
    // 2. Constructor
    // -----------------------------
    public Employeesearchpage () throws IOException {
		super();
		PageFactory.initElements(driver, this);

    }
    // -----------------------------
    // 3. Actions
    // -----------------------------

    /** Clicks the Add Employee button 
     * @throws IOException */
    public CreateEmployeePage clickAddEmployee() throws IOException {
        addEmployeeButton.click();
        return new CreateEmployeePage(); // Assuming CreateEmployeePage exists
    }

    /** Performs a search operation with given name and mobile number */
    public Employeesearchpage searchEmployee(String name, String mobileNo) {
        nameInput.clear();
        nameInput.sendKeys(name);

        mobileNoInput.clear();
        mobileNoInput.sendKeys(mobileNo);

        searchButton.click();
        return this;
    }

    /** Clears the search form */
    public void clearSearch() {
        clearButton.click();
    }

  
}




	