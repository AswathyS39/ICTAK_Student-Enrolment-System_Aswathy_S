package com.studenrol.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class EmpStudDetailsPage extends TestBase
{


	@FindBy(xpath="//div[@class='col-lg-4']//descendant::h3")
	WebElement studNameDetails;
	
	@FindBy(xpath="//div[@class='col-lg-4']//descendant::p[1]")
	WebElement studIdDetails;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::tr[2]/td[2]")
	WebElement studDistrict;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::tr[3]/td[2]")
	WebElement studState;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::tr[4]/td[2]")
	WebElement studQualif;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::tr[5]/td[2]")
	WebElement studPOYear;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::tr[6]/td[2]")
	WebElement studTrainingTech;
	
	@FindBy(xpath="//div[@class='col-lg-8']//descendant::table[2]//td[2]")
	WebElement studEExmMark;
	
	
	
	@FindBy(xpath="//a[@routerlink='search']")
	WebElement empSearchLink;
	
	@FindBy(xpath="//*[@id='home']//h1[text()='Search Students']")
	WebElement searchPgText;
	
	public EmpStudDetailsPage()
	{
		
		PageFactory.initElements(driver, this);
	}

	public String detailStudName()
	{
		return studNameDetails.getText();
	}
	
	public String detailStudId()
	{
		return studIdDetails.getText();
	}
	
	public String detailStudDistrict()
	{
		return studDistrict.getText();
	}
	
	public String detailStudState()
	{
		return studState.getText();
	}
	
	public String detailStudQualif()
	{
		return studQualif.getText();
	}
	
	public String detailStudPOY()
	{
		return studPOYear.getText();
	}
	
	public String detailStudTTech()
	{
		return studTrainingTech.getText();
	}
	
	public String detailStudEEMark()
	{
		return studEExmMark.getText();
	}
	
	public EmpSearchPage empSearchPgClick()
	{
		empSearchLink.click();
		return new EmpSearchPage();
	}
	
	public String empSearchPgText()
	{
		return searchPgText.getText();
	}
	
}
