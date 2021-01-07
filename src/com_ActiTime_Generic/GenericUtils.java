package com_ActiTime_Generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtils
{
	public static void getScreenShot(WebDriver driver,String name)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			Files.copy(src, new File("./ScreenShot/"+name+".png"));
		}
		catch (Exception e) {
		}
	}
	
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}

}


