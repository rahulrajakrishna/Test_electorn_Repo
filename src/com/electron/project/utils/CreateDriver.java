package com.electron.project.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.electron.utils.GetData;

public class CreateDriver 
{
	public static WebDriver createInstance()
	{
		WebDriver driver = null;
		String browserName = GetData.
		fromProperties("./test-config/config.properties", "browser");
		String url = GetData.
		fromProperties("./test-config/config.properties", "url");
		String timeOuts = GetData.
		fromProperties("./test-config/config.properties", "timeouts");
		// To convert String data to integer data
		Integer timeOut = new Integer(timeOuts);
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", 
					"./browser_server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./browser_server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("INvalid Browser option");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
