package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.LoginPage;
import com.studenrol.testbase.TestBase;

public class LoginPageTest extends TestBase
{
	LoginPage objLoginPg;

	@Test(priority=0)
	public void verifyempSignupBtn() throws Exception
	{
		//Create Login Page object
		objLoginPg = new LoginPage();
		objLoginPg.empSignupBtnClick();
		
		String empRegPgUrlActual=driver.getCurrentUrl();
		//Thread.sleep(1000);
		String empRegPgUrlExp=prop.getProperty("empSingupUrl");

		Assert.assertEquals(empRegPgUrlExp, empRegPgUrlActual);
	}
	
	
}
