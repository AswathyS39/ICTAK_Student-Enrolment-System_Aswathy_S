package com.studenrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class EmpProfileHomePg extends TestBase
{
	HomePage obj= new HomePage();
	
	
	@FindBy(xpath="//*[@id='home']//ancestor::h1")
	WebElement empProfileName;
	
	@FindBy(xpath="//a[@routerlink='students']")
	WebElement empAllStudLink;
	
	
	
	@FindBy(xpath="//*[@id='home']//h1[text()='Students']")
	WebElement studentPgText;
	
	
	
	public EmpProfileHomePg()
	{
		
		PageFactory.initElements(driver, this);
	}
	public void empProfileHomeLink() throws Exception
	{
		
		obj.clickHomeLink();
		Thread.sleep(2000);
		obj.homePageUrlVerify();
		Thread.sleep(2000);
		
	}
	public void empProfileCourseLink() throws Exception
	{
		obj.clickCourseLink();
		Thread.sleep(2000);
		obj.coursePageTextVerify();
		Thread.sleep(2000);
	}
	
	public String empProfileName()
	{
		return empProfileName.getText();
	}
	
	public EmpAllStudentPage empAllStudClick()
	{
		empAllStudLink.click();
		return new EmpAllStudentPage();
	}
	
	public String empAllStudText()
	{
		return studentPgText.getText();
	}
	
	
}
