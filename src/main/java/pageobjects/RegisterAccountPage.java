package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	WebDriver driver;
	
	public RegisterAccountPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-firstname")
	WebElement firstNameTextField;
	
	@FindBy(id="input-lastname")
	WebElement lastNameTextField;
	
	@FindBy(id="input-email")
	WebElement emailTextField;
	
	@FindBy(id="input-telephone")
	WebElement telephoneTextField;
	
	@FindBy(id="input-password")
	WebElement passwordTextField;
	
	@FindBy(id="input-confirm")
	WebElement confirmPasswordTextField;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement yesRadioOption;
	
	@FindBy(name="agree")
	WebElement privacyPolicyCheckboxField;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyPolicyWarningMessage;
	
	public WebElement firstNameTextField() {
		
		return firstNameTextField;
		
	}
	
	public WebElement lastNameTextField() {
			
			return lastNameTextField;
			
		}

	public WebElement emailTextField() {
		
		return emailTextField;
		
	}

	public WebElement telephoneTextField() {
		
		return telephoneTextField;
		
	}

	public WebElement passwordTextField() {
		
		return passwordTextField;
		
	}

	public WebElement confirmPasswordTextField() {
		
		return confirmPasswordTextField;
		
	}
	
	public WebElement yesRadioOption() {
		
		return yesRadioOption;
	}

	public WebElement privacyPolicyCheckboxField() {
		
		return privacyPolicyCheckboxField;
		
	}

	public WebElement continueButton() {
		
		return continueButton;
		
	}
	
	public WebElement privacyPolicyWarningMessage() {
		
		return privacyPolicyWarningMessage;
		
	}
	

}
