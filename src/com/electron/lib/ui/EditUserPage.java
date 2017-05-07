package com.electron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUserPage
{
	WebDriver driver;
	public EditUserPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getDeleteUserButton()
	{
		return driver.findElement(By.cssSelector("input[value='Delete this User']"));
	}
}
