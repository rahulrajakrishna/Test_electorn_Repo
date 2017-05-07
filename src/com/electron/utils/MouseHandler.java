package com.electron.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHandler 
{
	public static void mouseHover(WebDriver driver,
			WebElement element) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	// Add more functions related to mouse
}
