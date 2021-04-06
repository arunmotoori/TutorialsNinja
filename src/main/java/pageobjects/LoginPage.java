package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
    
	@FindBy(id="input-email")
	WebElement emailAddressTextField;
	
	@FindBy(id="input-password")
	WebElement passwordTextField;
	
	@FindBy(css="input[value='Login']")
	WebElement loginButton;
	
	@FindBy(css="div[class='alert alert-danger alert-dismissible']")
	WebElement noMatchForEmailAddressAndPasswordWarningMessage;
	
	@FindBy(linkText="Forgotten Password")
	WebElement forgottenPasswordLink;
	
	@FindBy(css="div[class='alert alert-success alert-dismissible']")
	WebElement forgotPasswordSuccessMessage;
	
	public WebElement emailAddressTextField() {
		
		return emailAddressTextField;
	}
	
	public WebElement passwordTextField() {
		
		return passwordTextField;
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}
	
	public WebElement noMatchForEmailAddressAndPasswordWarningMessage() {
		
		return noMatchForEmailAddressAndPasswordWarningMessage;
	}
	
	public WebElement forgottenPasswordLink() {
		
		return forgottenPasswordLink;
		
	}
	
	public WebElement forgotPasswordSuccessMessage() {
		
		return forgotPasswordSuccessMessage;
	}
	

}
