package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.EmpMarkEntryPage;
import com.studenrol.testbase.TestBase;

public class EmpMarkEntryPageTest extends TestBase
{

	EmpMarkEntryPage objMarkEntry;
	int studValidMark=91;
	String studInvalidMark="a&Y";
	String studNullMark="";
	
	@Test(priority=0)
	
	public void verifyEENameTB() throws Exception
	{
		objMarkEntry=new EmpMarkEntryPage();
		objMarkEntry.sNameTB();
		Thread.sleep(2000);
		
		String actualStudName=objMarkEntry.sNameTB();
		Assert.assertEquals(prop.getProperty("empStudNameDetails"), actualStudName);
	}
	
	@Test(priority=1)
	public void verifyValidEEMarkTB() throws Exception
	{
		objMarkEntry=new EmpMarkEntryPage();
		objMarkEntry.sEEMarkValidTB(studValidMark);
		Thread.sleep(1000);
		objMarkEntry.examUpdateBtn();
		Thread.sleep(1000);
		Assert.assertTrue(true,"Valid Mark Entered");	
	}
	
	@Test(priority=2)
	public void verifyInvalidEEMarkTB() throws Exception
	{
		objMarkEntry=new EmpMarkEntryPage();
		objMarkEntry.sEEMarkInvalidTB(studInvalidMark);
		Thread.sleep(1000);
		objMarkEntry.examUpdateBtn();
		Assert.assertTrue(false,"Invalid Mark Entered. Mark Textbx is not Validated. Characters & Symbols are updated as mark");
		
	}
	

	@Test(priority=3)
	public void verifyNullEEMarkTB() throws Exception
	{
		objMarkEntry=new EmpMarkEntryPage();
		objMarkEntry.sEEMarkInvalidTB(studNullMark);
		Thread.sleep(1000);
		objMarkEntry.examUpdateBtn();
		Assert.assertTrue(true,"Updation Unsuccessful. Exit Exam Mark is required error message is not displayed");
		
	}
}
