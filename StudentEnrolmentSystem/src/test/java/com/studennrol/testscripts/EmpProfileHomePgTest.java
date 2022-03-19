package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.EmpProfileHomePg;
import com.studenrol.testbase.TestBase;

public class EmpProfileHomePgTest extends TestBase
{
	EmpProfileHomePg objempProfileHome;
	HomePageTest objHomePgTest1;
	

	@Test(priority=1)
	public void verifyHomeCourse() throws Exception
	{
		objempProfileHome = new EmpProfileHomePg();
		objHomePgTest1 = new HomePageTest();
		objHomePgTest1.verifyHomePage();	
		objHomePgTest1.verifyCoursePage();
	}
	

	@Test(priority=0)
	public void verifyProfileName() throws Exception
	{
		objempProfileHome = new EmpProfileHomePg();
		String expProfileName="WELCOME ASWIN";
		String actualProfileName=objempProfileHome.empProfileName();
		if(expProfileName.equals(actualProfileName))
		{
			Assert.assertEquals(true, "Login Successful");
		}
		else
			Assert.assertEquals(false, "Login Successful, but Username of that loggedIn employee should be present in the Welcome Note");
	}
	

	@Test(priority=2)
	public void verifyEmpAllStudPg() throws Exception
	{
		objempProfileHome = new EmpProfileHomePg();
		objempProfileHome.empAllStudClick();
		Thread.sleep(1000);
	
		String expAllStudText=prop.getProperty("allStudPgText");
		String actualAllStudText=objempProfileHome.empAllStudText();
		Assert.assertEquals(expAllStudText, actualAllStudText);
		System.out.println(actualAllStudText);
	}

}
