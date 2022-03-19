package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.studenrol.pages.EmpRegisterPage;
import com.studenrol.pages.LoginPage;
import com.studenrol.testbase.TestBase;

import com.studenrol.utilities.TestUtil;



public class EmpRegisterPageTest extends TestBase
{
	LoginPage objLoginPg;
	EmpRegisterPage objEmpRegPg;
	String sheetName = "EmpReg";
	
	@Test(priority=0, dataProvider="getEmpRegData")
	public void verifyRegistration(String empName, String empEmail, String empPswd, String empRole, String Type) throws Exception 
	{
		objEmpRegPg = new EmpRegisterPage();
		
		objEmpRegPg.setEmpName(empName);
		
		objEmpRegPg.setEmpEmail(empEmail);
		
		objEmpRegPg.setEmpPassword(empPswd);
		
		objEmpRegPg.setEmpRole(empRole);
		Thread.sleep(2000);
		objEmpRegPg.clickRegisterBtn();
		
		Thread.sleep(2000);
		if(Type.equals("Invalid"))
		{
			if(driver.getCurrentUrl().equals(prop.getProperty("loginPgUrl")))
			{
				objLoginPg=new LoginPage();
				objLoginPg.empSignupBtnClick();
				
				Assert.assertTrue(false, "Not validating NAME & Role in Registration Form");
				
			}
			else if(driver.getCurrentUrl().equals(prop.getProperty("empSingupUrl")))
				{
					driver.navigate().refresh();
					Assert.assertTrue(true, "Enter Valid Data");		
				}
				 
		}
		else if(Type.equals("Valid"))
		{
			if(driver.getCurrentUrl().equals(prop.getProperty("loginPgUrl")))
			{
				Assert.assertTrue(true, "Registration Successful");
			}
		}
		else
		{
			Assert.assertTrue(false, "Registration Failure");
		}
		
	}
	
	@DataProvider
	public Object[][] getEmpRegData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
	}
}
