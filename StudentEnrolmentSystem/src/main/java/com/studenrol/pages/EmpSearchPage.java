package com.studenrol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;
import com.studenrol.utilities.ExcelLibrary;


public class EmpSearchPage extends TestBase
{
	
	public static String TESTDATA_SHEET_PATH=System.getProperty("user.dir") + "\\src\\main\\resources\\EmpTestData.xlsx";
	public String searchData;
	public String  studDetails;
	
	@FindBy(xpath="//input[@id='listSearch']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='container']//a[@data-toggle='collapse']")
	WebElement logoutLink;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> totStudsRow;
	@FindBy(xpath="//thead/tr")
	List<WebElement> totCHeadRow;
	@FindBy(xpath="//thead/tr/th")
	List<WebElement> totCHead;
	@FindBy(xpath="//tbody/tr/td")
	List<WebElement> totStuds;
	
	@FindBy(xpath="//table[@class='table']/tbody/tr")
	List<WebElement> searchStudRow;
	
	@FindBy(xpath="//table[@class='table']/tbody/tr/td")
	List<WebElement> searchStudCol;
	
	@FindBy(xpath="//table[@class='table']/tbody//descendant::h5")
	WebElement noResult;
	
	
	public EmpSearchPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void headingList() throws Exception 
	{
		ExcelLibrary xlLib= new ExcelLibrary(TESTDATA_SHEET_PATH);
		int totRows=totCHeadRow.size();
		int totCols=totCHead.size();
		if(totRows>0)
		{
		for(int i=1;i<=totRows;i++)
		{
			for(int j=0;j<totCols;j++)
			{
				xlLib.setCellData("StudentDetails", 0, j, totCHead.get(j).getText());
			}
			System.out.println();
			
		}
	}
	}
	
	
	public String studentsList() throws Exception 
	{
		ExcelLibrary xlLib= new ExcelLibrary(TESTDATA_SHEET_PATH);
		int totRows=totStudsRow.size();
		int totCols;
		
		if(totRows>0)
		{
		for(int i=1;i<=totRows;i++)
		{
			totCols=driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).size();
			for(int j=0;j<totCols;j++)
			{
				studDetails= driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).get(j).getText();
				xlLib.setCellData("StudentDetails", i, j, driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).get(j).getText());
			}
			System.out.println();
		}
		}
		Thread.sleep(1000);
		return studDetails;
	}
	
	
	public String searchList(String searchText) throws Exception 
	{
		int totSearchCols=0;
		
		searchBox.sendKeys(searchText);
		System.out.println("----------------------------------------------------");
		System.out.println("Student Details - Filtered by : "+searchText);
		System.out.println("----------------------------------------------------");
		int totSearchRows=searchStudRow.size();
		if(totSearchRows>0)
		{
		for(int i=1; i<=totSearchRows;i++)
		{
			totSearchCols=driver.findElements(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td")).size();
			for(int j=0;j<totSearchCols;j++)
			{
				System.out.print(driver.findElements(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td")).get(j).getText()+"		");
				searchData=driver.findElements(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td")).get(j).getText();
			}
			
			System.out.println();
		}
		}
		else
		{
			searchData= noResult.getText();
		}
	System.out.println(searchData);
	searchBox.clear();
	return searchData;
	}
	
	public HomePage logoutClick() throws Exception 
	{
		logoutLink.click();
		Thread.sleep(2000);
		return new HomePage();
	}

}
