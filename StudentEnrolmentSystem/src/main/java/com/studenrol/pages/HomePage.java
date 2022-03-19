package com.studenrol.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(xpath="//a[@routerlink='home']")
	WebElement homeLink;

	@FindBy(xpath="//a[@routerlink='courses']")
	WebElement courseLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement ictakEnroll;

	@FindBy(xpath="//a[text()='Go through our courses']")
	WebElement goThruCourseBtn;
	
	@FindBy(xpath="//h1[text()='Our Courses']")
	WebElement ourCourseText;

	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String homePageUrlVerify()
	{
		return driver.getCurrentUrl();
	}

	public void clickHomeLink()
	{
		homeLink.click();
	}
	
	public CoursePage clickCourseLink()
	{
		courseLink.click();
		return new CoursePage();
	}
	
	public CoursePage clickGoThruCourse()
	{
		goThruCourseBtn.click();
		return new CoursePage();
	}
	
	public String coursePageTextVerify()
	{
		return ourCourseText.getText();
	}

	public void ictakEnrolLink()
	{
		ictakEnroll.click();
	}
}