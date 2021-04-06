package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountSuccessPage;
import pageobjects.LandingPage;
import pageobjects.RegisterAccountPage;
import resources.Base;
import utils.Utils;

public class RegisterAccountTest extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = intializeBrowser();
		
	}
	
	@Test
	public void registerNewAccountWithMandatoryFieldsTest() throws IOException  {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		
		landingPage.registerOption().click();
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
		
		registerAccountPage.firstNameTextField().sendKeys(prop.getProperty("firstName"));
		registerAccountPage.lastNameTextField().sendKeys(prop.getProperty("lastName"));
		
		Utils utils = new Utils();
		
		registerAccountPage.emailTextField().sendKeys(utils.generateRandomEmail());
		
		registerAccountPage.telephoneTextField().sendKeys(prop.getProperty("telephone"));
		
		registerAccountPage.passwordTextField().sendKeys(prop.getProperty("password"));
		
		registerAccountPage.confirmPasswordTextField().sendKeys(prop.getProperty("password"));
		
		registerAccountPage.privacyPolicyCheckboxField().click();
		
		registerAccountPage.continueButton().click();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountSuccessPage.accountSuccessBreadcrumb().isDisplayed());
	
	}
	
	@Test
	public void registerNewAccountWithSubscriptionTest() throws IOException  {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		
		landingPage.registerOption().click();
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
		
		registerAccountPage.firstNameTextField().sendKeys(prop.getProperty("firstName"));
		registerAccountPage.lastNameTextField().sendKeys(prop.getProperty("lastName"));
		
		Utils utils = new Utils();
		
		registerAccountPage.emailTextField().sendKeys(utils.generateRandomEmail());
		
		registerAccountPage.telephoneTextField().sendKeys(prop.getProperty("telephone"));
		
		registerAccountPage.passwordTextField().sendKeys(prop.getProperty("password"));
		
		registerAccountPage.confirmPasswordTextField().sendKeys(prop.getProperty("password"));
		
		registerAccountPage.yesRadioOption().click();
		
		registerAccountPage.privacyPolicyCheckboxField().click();
		
		registerAccountPage.continueButton().click();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountSuccessPage.accountSuccessBreadcrumb().isDisplayed());
	
	}
	
	@Test
	public void registerNewAccountWithoutEnteringAnyFeildsTest() throws IOException  {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		
		landingPage.registerOption().click();
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
		
		registerAccountPage.continueButton().click();
		
		Assert.assertEquals(registerAccountPage.privacyPolicyWarningMessage().getText(),"Warning: You must agree to the Privacy Policy!");
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}

}
