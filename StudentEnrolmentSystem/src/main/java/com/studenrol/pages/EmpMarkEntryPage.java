package com.studenrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class EmpMarkEntryPage extends TestBase
{
	
	@FindBy(xpath="//label[text()='Name']//following::input[@name='name']")
	WebElement sName;
	
	@FindBy(xpath="//input[@name='id']")
	WebElement sId;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement sCourseName;
	
	@FindBy(xpath="//input[@name='techtraining']")
	WebElement sExamMark;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateBtn;
	
	public EmpMarkEntryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	String studentName;
	String studentId;
	String studentCourse;
	int sEExamMarkTB;
	String sExitExamMark;
	
	public String sNameTB() throws Exception
	{
		
		boolean sNameTBState=sName.isEnabled();
		if(sNameTBState==false)
		{
			studentName=sName.getAttribute("value");
		}
		return studentName;
	}
	
	public String sIdTB()
	{
		boolean sIdTBState=sId.isEnabled();
		if(sIdTBState==false)
		{
			studentId=sId.getAttribute("value");	
		}
		return studentId;
	}
	
	public String sCourseNameTB()
	{
		boolean sCourseTBState=sCourseName.isEnabled();
		if(sCourseTBState==false)
		{
			studentCourse=sCourseName.getAttribute("value");
			System.out.println(studentCourse);
		}
		return studentCourse;
	}
	
	public int sEEMarkValidTB(int sEEMark)
	{
		if(sExamMark.isEnabled())
		{
			sExamMark.clear();
			//sEExamMarkTB= Integer.toString(sEEMark);
			sExamMark.sendKeys(""+sEEMark);
		}
		return sEEMark;
	}
	
	public String sEEMarkInvalidTB(String sEEMark)
	{
		if(sExamMark.isEnabled())
		{
			sExamMark.clear();
			sExamMark.sendKeys(sEEMark);
		}
		return sEEMark;
	}
	
	
	public EmpStudDetailsPage examUpdateBtn()
	{
		updateBtn.click();
		return new EmpStudDetailsPage();
	}
}
