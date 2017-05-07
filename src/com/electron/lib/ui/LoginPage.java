package com.electron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUserNameTextbox()
	{
		WebElement element = driver.findElement(By.name("username"));
		return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
}
