package com.electron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersListPage
{
	WebDriver driver;
	public UsersListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getAddUserButton()
	{
		return driver.
				findElement(By.cssSelector("input[value='Add New User']"));
	}
	public WebElement getUser(String userName)
	{
		return driver.findElement(By.partialLinkText(userName));
	}
}
