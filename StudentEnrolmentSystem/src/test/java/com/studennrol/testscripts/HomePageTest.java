package com.studennrol.testscripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.HomePage;
import com.studenrol.testbase.TestBase;

public class HomePageTest extends TestBase
{
	HomePage objHomePg;

	@Test(priority=0)
	public void verifyHomePage() throws Exception
	{
		//Create Login Page object
		objHomePg = new HomePage();
		objHomePg.clickHomeLink();
		String homePageTitleActual=driver.getTitle();
		Thread.sleep(1000);
		String homePageTitleExp="Student Enrollment System";
		
		Assert.assertEquals(homePageTitleExp, homePageTitleActual);
	}
	
	@Test(priority=1)
		public void verifyGoThruCoursePage() throws Exception
		{
			objHomePg = new HomePage();
			objHomePg.clickGoThruCourse();
			Thread.sleep(1000);

			String ourCourseText=objHomePg.coursePageTextVerify();
			String courseText="Our Courses";
			Assert.assertEquals(courseText, ourCourseText);
			objHomePg.ictakEnrolLink();
		}

	@Test(priority=2)
	public void verifyCoursePage() throws Exception
	{
		objHomePg = new HomePage();
		objHomePg.clickCourseLink();
		Thread.sleep(1000);
		String courseUrlActual=driver.getCurrentUrl();
		String courseUrlExp=prop.getProperty("goThruCourseUrl");
		
		Assert.assertEquals(courseUrlExp, courseUrlActual);
	}

}
