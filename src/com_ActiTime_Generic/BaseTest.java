package com_ActiTime_Generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements Autoconstant
{
	public WebDriver driver;
	
	static 
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	@Parameters({"nodeurl","browser","appurl"})
	@BeforeMethod
	public void precondition(String nodeurl, String browser, String appurl) throws MalformedURLException
	{
		URL url = new URL(nodeurl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);		
		driver = new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(appurl);
	}
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status == 2)
		{
			String name = res.getName();
			GenericUtils.getScreenShot(driver, name);
		}
		driver.close();
	}

}