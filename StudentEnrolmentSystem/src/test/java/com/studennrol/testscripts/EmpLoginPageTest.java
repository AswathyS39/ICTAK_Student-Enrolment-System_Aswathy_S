

package com.studennrol.testscripts;


import com.studenrol.constants.AutomationConstants;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.studenrol.pages.EmpLoginPage;
import com.studenrol.testbase.TestBase;

import com.studenrol.utilities.TestUtil;

public class EmpLoginPageTest extends TestBase
{
	EmpLoginPage objEmpLoginPg;
	String sheetName = "EmpLogin";
	
	@Test(priority=0, dataProvider="getEmpLoginData")
	public void verifyValidLoginStud(String uName, String pswd, String type, String loginState) throws Exception 
	{
		objEmpLoginPg = new EmpLoginPage();
		
		objEmpLoginPg.loginEmpEmail(uName);
		objEmpLoginPg.loginEmpPassword(pswd);
		objEmpLoginPg.userTypeSelect(type);
		Thread.sleep(1000);
		objEmpLoginPg.clickLoginBtn();
		Thread.sleep(1000);
		Alert loginAlert= driver.switchTo().alert();
		
		String alertMsg=loginAlert.getText();
		loginAlert.accept();
		Thread.sleep(1000);
		
		if(loginState.equals("Valid"))
		{
			if(alertMsg.equals(AutomationConstants.LOGIN_SUCCESS_ALERT))
			{
				Assert.assertTrue(true, alertMsg);
			}
			else
			{
				Assert.assertTrue(false, "Login Failure");
			}
			
		}
		else if(loginState.equals("Invalid"))
		{
			if(alertMsg.equals(AutomationConstants.INVALID_LOGIN_ALERT))
				{
					Assert.assertTrue(true, alertMsg);
				}
				else if(alertMsg.equals(AutomationConstants.EMP_INVALID_PASSWORD_ALERT))
				{
					Assert.assertTrue(true, alertMsg);
				}
				else
				{
					Assert.assertTrue(false, "Login Failure");
				}
		}
		else
		{
			Assert.assertTrue(false, "Login Failure");
		}
//
//		objEmpLoginPg.clearEmail();		//org.openqa.selenium.NoSuchElementException: 
//		objEmpLoginPg.clearPassword();	//no such element: Unable to locate element: {"method":"xpath","selector":"//input[@name='email']"}		
//		objEmpLoginPg.clearUserType();
	
		driver.navigate().refresh();
	}
	
	@DataProvider
	public Object[][] getEmpLoginData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

}
