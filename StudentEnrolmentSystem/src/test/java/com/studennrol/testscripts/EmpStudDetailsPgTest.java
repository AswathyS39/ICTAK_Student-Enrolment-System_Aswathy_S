package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.constants.AutomationConstants;
import com.studenrol.pages.EmpMarkEntryPage;
import com.studenrol.pages.EmpStudDetailsPage;
import com.studenrol.testbase.TestBase;

public class EmpStudDetailsPgTest extends TestBase
{
	EmpStudDetailsPage objEmpStudDetail;
	EmpMarkEntryPage objMarkEntry;
	
	EmpMarkEntryPageTest obj;
	
	@Test(priority=0)
	public void studentNameVerify() throws Exception
	{
		objEmpStudDetail= new EmpStudDetailsPage();
		
		String StudentName=objEmpStudDetail.detailStudName();
		if(StudentName.equals(prop.getProperty("empStudNameDetails")))
		{
			Assert.assertTrue(true);
			Thread.sleep(1000);
		}
		
		else
		{
			Assert.assertTrue(false,"Other Student Details is showing");
		}
	}
	
	@Test(priority=1)
	public void studentMarkVerify() throws Exception
	{
		
		objMarkEntry=new EmpMarkEntryPage();
		objEmpStudDetail= new EmpStudDetailsPage();
		String StudentName=objEmpStudDetail.detailStudName();
		
		if(StudentName.equals(prop.getProperty("empStudNameDetails")))
		{
			Assert.assertTrue(true);
		
			if(prop.getProperty("empStudEEMark").equals(objEmpStudDetail.detailStudEEMark()))
			{
				Assert.assertTrue(true);
			}
		}
		Thread.sleep(1000);
	}

	@Test(priority=2)	
	public void verifyEmpSearchPg() throws Exception
	{
		objEmpStudDetail= new EmpStudDetailsPage();
		
		objEmpStudDetail.empSearchPgClick();
		Thread.sleep(1000);
		
		String expSearchText=AutomationConstants.SEARCH_PAGE_TEXT;
		String actualSearchText=objEmpStudDetail.empSearchPgText();
		Assert.assertEquals(expSearchText, actualSearchText);
	}
	

}
