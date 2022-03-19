package com.studenrol.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class EmpAllStudentPage extends TestBase
{
	public String studentName;
	
	@FindBy(xpath="//div[@class='page container']//ul/descendant::h3")
	List<WebElement> studNameList;
	
	@FindBy(xpath="//div[@class='page container']/ul//descendant::button[text()='Mark Entry']")
	List<WebElement> markEntryBtnList;
	
	@FindBy(xpath="//div[@class='page container']//ul/descendant::button[text()='Show Details']")
	List<WebElement> studDetailBtnList;
	
	public EmpAllStudentPage()
	{
		
		PageFactory.initElements(driver, this);
	}

	
	public void showStudsName()
	{
		for(int i=0;i<studNameList.size();i++) 
		{
			System.out.println(studNameList.get(i).getText());
		}
	}
	
	public EmpStudDetailsPage showStudDetail(String studName) throws Exception
	{ 
		int totStud=studNameList.size();
		if(totStud>0)
		{
		for(int i=0;i<totStud;i++) 
		{
			if(studNameList.get(i).getText().contains(studName))
			{
				studentName=studNameList.get(i).getText();
	
				studDetailBtnList.get(i).click();
				break;
			}
		}
		}
		else
			System.out.println("No Students are available right now");
		return new EmpStudDetailsPage();
		
	}
	
	
	public EmpMarkEntryPage studMarkEntry(String studName) throws Exception
	{
		int totStud=studNameList.size();
		if(totStud>0)
		{
		for(int i=0;i<totStud;i++) 
		{
			if(studNameList.get(i).getText().contains(studName))
			{
				studentName=studNameList.get(i).getText();
				
				Actions actions = new Actions(driver);

				actions.moveToElement(markEntryBtnList.get(i)).click().perform();
				
				break;
			}
		}
		}
		else
			System.out.println("No Students are available right now");
		return new EmpMarkEntryPage();
	}
	
}
