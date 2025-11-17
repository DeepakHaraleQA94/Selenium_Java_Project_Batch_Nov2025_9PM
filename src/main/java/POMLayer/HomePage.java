package POMLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.ParentLayer.TesBase;

public class HomePage  extends TesBase{
	
	@FindBy(linkText = "Home")
	WebElement HomePageLink;
	
	@FindBy(linkText = "Employee")
	WebElement EmployeLink;

	@FindBy(linkText = "Create")
	WebElement CreateLink;
	
	@FindBy(linkText = " Search ")
	WebElement  SearchLink;
	
	@FindBy(linkText = "More")
	WebElement MoreLink;
	
	@FindBy(linkText = "  Multiple Tabs ")
	WebElement  MultipleTabsLink;
	
	@FindBy(linkText = " Menu ")
	WebElement  MenuLink;
	
	@FindBy(linkText = "  Autocomplete ")
	WebElement  AutocompleteLink;
	
	@FindBy(linkText = "  Collapsible Content ")
	WebElement  CollapsibleContentLink;
	
	@FindBy(linkText = " Images ")
	WebElement  ImagesLink;
	
	@FindBy(linkText = " Slider ")
	WebElement  SliderLink;
	
	@FindBy(linkText = "Tooltips")
	WebElement  TooltipsLink;
	
	@FindBy(linkText = " Popups ")
	WebElement  PopupsLink;
	
	@FindBy(linkText = " Links ")
	WebElement  LinksLink;
	
	@FindBy(linkText = " CSS Properties ")
	WebElement  CSSPropertiesLink;
	
	@FindBy(linkText = " iFrames ")
	WebElement  iFramesLink;
	
	@FindBy(linkText = "Settings ")
	WebElement  SettingsLink;
	
//Constructor
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	//Action Function 
	
	public void clickHomePageLink() {
		HomePageLink.click();
	}
	
	public void clickEmployeLink() {
		EmployeLink.click();
	}
	
	public void clickCreateLink() {
		CreateLink.click();
	}
	public void clickSearchLink() {
		SearchLink.click();
	}
	
	public void clickMoreLink() {
		MoreLink.click();
	}
	
	public void clickMultipleTabsLink() {
		MultipleTabsLink.click();
	}
	
	public void clickMenuLink() {
		MenuLink.click();
	}
	
	public void clickAutocompleteLink() {
		AutocompleteLink.click();
	}
	public void clickCollapsibleContentLink() {
		CollapsibleContentLink.click();
	}
	
	public void ImagesLink() {
		ImagesLink.click();
	}
	
	public void SliderLink() {
		SliderLink.click();
	}
	
	public void TooltipsLink() {
		TooltipsLink.click();
	}
	
	public void PopupsLink() {
		PopupsLink.click();
	}
	public void LinksLink() {
		LinksLink.click();
	}
	public void CSSPropertiesLink() {
		CSSPropertiesLink.click();
	}
	public void iFramesLink() {
		iFramesLink.click();
	}
	public void SettingsLink() {
		SettingsLink.click();
	}
	

}
