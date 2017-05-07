package com.electron.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandler 
{
	public static void selectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}
	public static void selectDDLByValue(WebElement ddl, String value)
	{
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}
	public static void selectDDLByVisible(WebElement ddl, String text)
	{
		Select sct = new Select(ddl);
		sct.selectByVisibleText(text);
	}
	public static void deSelectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.deselectByIndex(index);
	}
	public static void deSelectDDLByValue(WebElement ddl, String value)
	{
		Select sct = new Select(ddl);
		sct.deselectByValue(value);
	}
	public static void deSelectDDLByVisible(WebElement ddl, String text)
	{
		Select sct = new Select(ddl);
		sct.deselectByVisibleText(text);
	}
	public static void deSelectAllOptions(WebElement ddl)
	{
		Select sct = new Select(ddl);
		sct.deselectAll();
	}
}
