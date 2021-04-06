package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.ForgottenPasswordPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ForgotPasswordTest extends Base {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = intializeBrowser();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	@Test
	public void resetPasswordTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.forgottenPasswordLink().click();
		
		ForgottenPasswordPage forgottenPassworddPage = new ForgottenPasswordPage(driver);
		
		forgottenPassworddPage.emailAddressTextField().sendKeys(prop.getProperty("validEmailAddress"));
		
		forgottenPassworddPage.continueButton().click();
		
		Assert.assertEquals(loginPage.forgotPasswordSuccessMessage().getText(),"An email with a confirmation link has been sent your email address.");
		
		
	}
	
	@Test
	public void resetPasswordForInvalidEmailAddressTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.forgottenPasswordLink().click();
		
		ForgottenPasswordPage forgottenPassworddPage = new ForgottenPasswordPage(driver);
		
		forgottenPassworddPage.emailAddressTextField().sendKeys(prop.getProperty("invalidEmailAddress"));
		
		forgottenPassworddPage.continueButton().click();
		
		Assert.assertEquals(forgottenPassworddPage.forgottendPasswordInvalidEmailAddressMessage().getText(),"Warning: The E-Mail Address was not found in our records, please try again!");
			
		
	}
	
	@Test
	public void resetPasswordWithoutProvidingEmailAddressTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.forgottenPasswordLink().click();
		
		ForgottenPasswordPage forgottenPassworddPage = new ForgottenPasswordPage(driver);
		
		forgottenPassworddPage.continueButton().click();
		
		Assert.assertEquals(forgottenPassworddPage.forgottendPasswordInvalidEmailAddressMessage().getText(),"Warning: The E-Mail Address was not found in our records, please try again!");
			
	}

}
