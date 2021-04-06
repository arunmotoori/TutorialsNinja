package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText="iPhone")
	WebElement iPhoneProductLabel;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement noProductSearchCriteriaMessage;
	
	public WebElement iPhoneProductLabel() {
		
		return iPhoneProductLabel;
		
	}
	
	public WebElement noProductSearchCriteriaMessage() {
		
		return noProductSearchCriteriaMessage;
		
	}

}
