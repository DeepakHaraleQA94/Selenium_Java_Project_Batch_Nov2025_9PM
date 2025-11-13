package POMLayer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.ParentLayer.TesBase;


public class LoginPage extends TesBase{


//	1. object factory 2. cunstructor  3. action function
	


	@FindBy(id = "UserName")
	 WebElement uname;
	
	@FindBy(id = "Password")
	 WebElement passwd;
	
	@FindBy(id = "btnLogin")
	 WebElement loginbtn;
	
	public LoginPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void enterUname(String name) {
		uname.sendKeys(name);
	}
	
	public void enterPass(String pass) {
		passwd.sendKeys(pass);
	}
	
	public void clickOnLoginBtn() {
		loginbtn.click();
	}
	
	
	
}
