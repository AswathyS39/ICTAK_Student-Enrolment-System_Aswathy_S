package com.studenrol.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studenrol.testbase.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//a[@routerlink='employeesignup']")
	WebElement empSignupBtn;

	WebDriverWait wait=new WebDriverWait(driver,7);
	public LoginPage()
	{

		PageFactory.initElements(driver, this);
	}

	public EmpRegisterPage empSignupBtnClick()
	{
		if(empSignupBtn.isDisplayed())
		{
			wait.until(ExpectedConditions.elementToBeClickable(empSignupBtn));
			empSignupBtn.click();
		}
		return new EmpRegisterPage();
	}

}
