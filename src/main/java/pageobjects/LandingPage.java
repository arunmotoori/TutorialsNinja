package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	@FindBy(linkText="Login")
	WebElement loginOption;
	
	@FindBy(name="search")
	WebElement searchBoxTextField;
	
	@FindBy(css="button[class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public WebElement myAccountDropMenu() {
		
		return myAccountDropMenu;
		
	}
	
	public WebElement registerOption() {
		
		return registerOption;
		
	}
	
	
	public WebElement loginOption() {
		
		return loginOption;
	}
	
	public WebElement searchBoxTextField() {
		
		return searchBoxTextField;
	}
	
	public WebElement searchButton() {
		
		return searchButton;
		
	}

}
