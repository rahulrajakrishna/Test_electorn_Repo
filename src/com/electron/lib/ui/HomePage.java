package com.electron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getLogoutButton()
	{
		return driver.
				findElement(By.xpath("//img[@class='logoutImg']/.."));
	}
	public WebElement getUsersTab()
	{
		return driver.findElement(By.linkText("Users"));
	}
}
