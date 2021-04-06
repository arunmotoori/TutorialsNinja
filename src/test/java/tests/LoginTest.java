package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
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
	public void loginWithValidCredentailsTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.emailAddressTextField().sendKeys(prop.getProperty("validEmailAddress"));
		
		loginPage.passwordTextField().sendKeys(prop.getProperty("validPassword"));
		
		loginPage.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.accountBreadCrumb().isDisplayed());
		
	}
	
	@Test
	public void loginWithInValidCredentailsTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.emailAddressTextField().sendKeys(prop.getProperty("invalidEmailAddress"));
		
		loginPage.passwordTextField().sendKeys(prop.getProperty("invalidPassword"));
		
		loginPage.loginButton().click();
		
		Assert.assertEquals(loginPage.noMatchForEmailAddressAndPasswordWarningMessage().getText(),"Warning: No match for E-Mail Address and/or Password.");

	}
	
	@Test
	public void loginWithoutProvidingAnyCredentailsTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropMenu().click();
		landingPage.loginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginButton().click();
		
		Assert.assertEquals(loginPage.noMatchForEmailAddressAndPasswordWarningMessage().getText(),"Warning: No match for E-Mail Address and/or Password.");

	}

}
