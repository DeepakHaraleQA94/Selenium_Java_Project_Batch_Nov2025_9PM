package com.jala.qa.TestLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.ParentLayer.TesBase;

import POMLayer.CreateEmployeePage;

public class EmployeeSeaqrchPage extends TesBase {

	
	 

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
	 
	    
	    public EmployeeSeaqrchPage() throws IOException {
			super();
			// TODO Auto-generated constructor stub
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
	    public EmployeeSeaqrchPage searchEmployee(String name, String mobileNo) {
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
