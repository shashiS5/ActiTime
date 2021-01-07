package com_ActiTime_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Generic.ExcelData;
import com_ActiTime_Pages.LoginPage;

@Ignore
public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void invalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		LoginPage lp = new LoginPage(driver);
		//verify login page title
		lp.verifyTitle(title);
		
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i=1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			//enter invalid user name
			lp.enterUserName(un);
			Reporter.log("Invalid user name = "+un, true);
			//enter invalid password
			lp.enterPassword(pw);
			Reporter.log("Invalid password = "+pw,true);
			//click on login
			lp.clickOnLogin();
			String aErrorMessage = lp.verifyErrorMessage();
			String eErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
			//verify error message 
			Assert.assertEquals(aErrorMessage, eErrorMessage);
			Reporter.log("-------------------------------------------",true);
			Thread.sleep(1000);
		}
	}

}