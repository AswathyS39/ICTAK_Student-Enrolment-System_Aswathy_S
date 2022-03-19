package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.CoursePage;
import com.studenrol.testbase.TestBase;


public class CoursePageTest extends TestBase
{
	
	CoursePage objCoursePg;

	@Test(priority=0)
	public void verifyCourseSelect() throws Exception
	{
		objCoursePg= new CoursePage();
		String expCourseName=prop.getProperty("Coursename");
		objCoursePg.knowMoreBtn(expCourseName);
		Thread.sleep(3000);
		String actualCourseName=objCoursePg.showCoursesName();
		
		Assert.assertEquals(expCourseName, actualCourseName);
		
	}
	
	@Test(priority=1)
	public void verifyLoginPage() throws Exception
	{
		objCoursePg= new CoursePage();
		objCoursePg.clickLoginBtn();
		String loginUrlActual=driver.getCurrentUrl();
		Thread.sleep(1000);
		
		String loginUrlExp=prop.getProperty("loginPgUrl");
		Assert.assertEquals(loginUrlExp, loginUrlActual);
	}
}