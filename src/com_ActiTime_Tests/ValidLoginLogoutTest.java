package com_ActiTime_Tests;

import org.testng.annotations.Test;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Generic.ExcelData;
import com_ActiTime_Pages.EnterTimeTrackPage;
import com_ActiTime_Pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void ValidLoginLogout()
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String epTitle  = ExcelData.getData(file_path, "TC01", 1, 3);
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		//verify login page title
		lp.verifyTitle(lgTitle);
		//enter valid user name
		lp.enterUserName(un);
		//enter valid password
		lp.enterPassword(pw);
		//click login button
		lp.clickOnLogin();
		//verify enter time track page
		lp.verifyTitle(epTitle);
		//click on logout
		ep.clickOnLogout();
		//verify login page title
		lp.verifyTitle(lgTitle);
	}

}