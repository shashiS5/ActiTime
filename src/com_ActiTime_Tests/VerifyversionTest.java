package com_ActiTime_Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Generic.ExcelData;
import com_ActiTime_Pages.LoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority = 3)
	public void verifyversion()
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		LoginPage lp = new LoginPage(driver);
		//verify login page title
		lp.verifyTitle(title);
		String aVersion = lp.verifyVersion();
		String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aVersion, eVersion);
		Reporter.log("Actual application version = "+aVersion,true);
		sa.assertAll();
	}

}