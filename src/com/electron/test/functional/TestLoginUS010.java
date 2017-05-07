package com.electron.test.functional;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electron.lib.ui.HomePage;
import com.electron.lib.ui.LoginPage;
import com.electron.project.utils.CreateDriver;
// Step 1
public class TestLoginUS010
{
	// Step 2
	WebDriver driver;
	// Step 3
	LoginPage loginPage;
	HomePage homePage;
	
	// Step 4
	@BeforeMethod
	public void setUp()
	{
		// Step 5
		driver = CreateDriver.createInstance();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	// Step 6
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	// Step 7
	@Test
	public void testLoginValidTC018()
	{
		// Step 8
		loginPage.getUserNameTextbox().sendKeys("admin");
		loginPage.getPasswordTextbox().sendKeys("manager");
		loginPage.getLoginButton().click();
		
		boolean actualStatus = homePage.getLogoutButton().isDisplayed();
		boolean expectedStatus = true;
		Assert.assertEquals(actualStatus, expectedStatus);
		homePage.getLogoutButton().click();
	}
	
	
}
