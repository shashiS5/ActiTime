package com_ActiTime_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_ActiTime_Generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
	@FindBy(id = "logoutLink")
	private WebElement logout;
	

	//Intilization
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void clickOnLogout()
	{
		logout.click();
	}

}