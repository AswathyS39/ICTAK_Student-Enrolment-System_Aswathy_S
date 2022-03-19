package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.EmpAllStudentPage;
import com.studenrol.testbase.TestBase;
import com.studenrol.pages.EmpProfileHomePg;

public class EmpAllStudentPageTest extends TestBase
{
	EmpAllStudentPage objAllStud;
	String expStudName;
	
	@Test(priority=0)
	public void studDetailsBtnVerify() throws Exception
	{
		objAllStud=new EmpAllStudentPage();
		expStudName=prop.getProperty("empStudNameDetails");
		objAllStud.showStudDetail(expStudName);
		Thread.sleep(1000);
		
		EmpProfileHomePg objProfile= new EmpProfileHomePg();
		objProfile.empAllStudClick();
		Thread.sleep(1000);
		
		String actualStudName=objAllStud.studentName;
		Assert.assertEquals(expStudName, actualStudName);
		
	}
	@Test(priority=1)
	public void studMarkEnterBtnVerify() throws Exception
	{
		objAllStud.studMarkEntry(expStudName);
		Thread.sleep(1000);
		
		String actualStudName=objAllStud.studentName;
		Assert.assertEquals(expStudName, actualStudName);
	}

}
