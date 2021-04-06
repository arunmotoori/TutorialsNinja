package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.SearchPage;
import resources.Base;

public class SearchTest extends Base {
	
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
	public void searchTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.searchBoxTextField().sendKeys(prop.getProperty("validProductName"));
		
		landingPage.searchButton().click();
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.iPhoneProductLabel().isDisplayed());
		
	}
	
	@Test
	public void searchForANonExistingProductTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.searchBoxTextField().sendKeys(prop.getProperty("invalidProductName"));
		
		landingPage.searchButton().click();
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.noProductSearchCriteriaMessage().isDisplayed());
		
	}
	
	
	@Test
	public void searchWithoutProvidingAnyProductTest() {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.searchButton().click();
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.noProductSearchCriteriaMessage().isDisplayed());
		
	}

}
