package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {
	
	WebDriver driver;
	
	public ForgottenPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-email")
	WebElement emailAddressTextField;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueButton;
	
	@FindBy(css="div[class='alert alert-danger alert-dismissible']")
	WebElement forgottendPasswordInvalidEmailAddressMessage;
	
	public WebElement emailAddressTextField() {
		
		return emailAddressTextField;
		
	}
	
	public WebElement continueButton() {
		
		return continueButton;
		
	}
	
	public WebElement forgottendPasswordInvalidEmailAddressMessage() {
		
		return forgottendPasswordInvalidEmailAddressMessage;
	}

}
