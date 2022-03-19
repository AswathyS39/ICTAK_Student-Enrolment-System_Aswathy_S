package com.studenrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studenrol.testbase.TestBase;

public class EmpLoginPage extends TestBase
{
	public String alertMsg;
	
	@FindBy(xpath="//input[@name='email']")	
	WebElement loginEmailTB;

	@FindBy(xpath="//input[@name='password']")	
	WebElement loginPasswordTB;

	@FindBy(xpath="//select[@name='role']")	
	WebElement userTypeDD;

	@FindBy(xpath="//input[@name='sign-in']")	
	WebElement loginBtn;

	public EmpLoginPage()
	{

		PageFactory.initElements(driver, this);
	}


	public void loginEmpEmail(String loginEmpEmail) throws Exception
	{
		loginEmailTB.sendKeys(loginEmpEmail);
	}
	
	public void loginEmpPassword(String loginEmpPassword)
	{
		loginPasswordTB.sendKeys(loginEmpPassword);
	}
	public void userTypeSelect(String userType) throws Exception
	{
		Select dropdown= new Select(userTypeDD);
		dropdown.selectByVisibleText(userType);
		String selectedUserType=dropdown.getFirstSelectedOption().getText();
	}
	
	public EmpProfileHomePg clickLoginBtn()
	{
		loginBtn.click();
		return new EmpProfileHomePg();
	}

}