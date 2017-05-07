package com.electron.test.regression;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electron.lib.ui.AddNewUserPage;
import com.electron.lib.ui.EditUserPage;
import com.electron.lib.ui.HomePage;
import com.electron.lib.ui.LoginPage;
import com.electron.lib.ui.UsersListPage;
import com.electron.project.utils.CreateDriver;
import com.electron.utils.GetData;

public class TestCreateUserUS0157 
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	UsersListPage userlist;
	AddNewUserPage adduser;
	EditUserPage edituser;
	String un;
	@BeforeMethod
	public void setUp()
	{
		driver = CreateDriver.createInstance();
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		userlist = new UsersListPage(driver);
		adduser = new AddNewUserPage(driver);
		edituser = new EditUserPage(driver);
	}
	@Test
	public void testCreateUserTC0288()
	{
		String filePath = "./test-data/data.xlsx";
		un = GetData.fromExcel(filePath, "TC_0288", 1, 0);
		String pwd = GetData.fromExcel(filePath, "TC_0288", 1, 1);
		String firstName = GetData.fromExcel(filePath, "TC_0288", 1, 2);
		String lastName = GetData.fromExcel(filePath, "TC_0288", 1, 3);
		loginPage.getUserNameTextbox().sendKeys("admin");
		loginPage.getPasswordTextbox().sendKeys("manager");
		loginPage.getLoginButton().click();
		
		homepage.getUsersTab().click();
		
		userlist.getAddUserButton().click();
		
		adduser.getUserNameTextbox().sendKeys(un);
		adduser.getPasswordTextbox().sendKeys(pwd);
		adduser.getRetypePasswordTextbox().sendKeys(pwd);
		adduser.getFirstNameTextbox().sendKeys(firstName);
		adduser.getLastNameTextbox().sendKeys(lastName);
		adduser.getCreateUserButton().click();
		boolean status = userlist.getUser(un).isDisplayed();
		Assert.assertEquals(status, true);
	}
	@AfterMethod
	public void tearDown()
	{
		userlist.getUser(un).click();
		edituser.getDeleteUserButton().click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		homepage.getLogoutButton().click();
		driver.close();
		
	}
}
