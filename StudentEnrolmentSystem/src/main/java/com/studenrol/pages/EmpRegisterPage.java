package com.studenrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studenrol.testbase.TestBase;

public class EmpRegisterPage extends TestBase
{
	@FindBy(xpath="//div[@class='title']")
	WebElement empRegFormText;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement empNameTB;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement empEmaiTB;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement empPasswordTB;
	
	@FindBy(xpath="//input[@name='role']")
	WebElement empRolesTB;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement registerBtn;
	
	@FindBy(xpath="//div[@class='inputfield']//following::span[1]")
	WebElement emailErrorMsg;
	
	@FindBy(xpath="//span[@class='alert alert-danger']")
	WebElement pswdErrorMsg;
	
	WebDriverWait wait=new WebDriverWait(driver,7);
	
	public EmpRegisterPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
    public void setEmpName(String strEmpName)
    {
    	wait.until(ExpectedConditions.visibilityOf(empNameTB));
    	empNameTB.sendKeys(strEmpName);
    }
    
    public void setEmpEmail(String strEmpEmail)
    {
    	wait.until(ExpectedConditions.visibilityOf(empEmaiTB));
    	empEmaiTB.sendKeys(strEmpEmail);     
    }
  
    public void setEmpPassword(String empPassword)
    {
    	wait.until(ExpectedConditions.visibilityOf(empPasswordTB));
    	empPasswordTB.sendKeys(empPassword);
    }
    
    public void setEmpRole(String empRole)
    {
    	wait.until(ExpectedConditions.visibilityOf(empRolesTB));
    	empRolesTB.sendKeys(empRole);
    }
    
    //Error Message
    public String getEmailErrorMessage()
    {
    	return emailErrorMsg.getText();
    }
    
    public String getPasswordErrorMessage()
    {
    	return pswdErrorMsg.getText();
    }
    
    //Click Register Button
    public EmpLoginPage clickRegisterBtn()
    {
    	registerBtn.click();
    	return new EmpLoginPage();
    }
    
    public void clearName()
    {
    	empNameTB.clear();     
    }
	public void clearEmail()
    {
		wait.until(ExpectedConditions.visibilityOfAllElements(empEmaiTB));
		empEmaiTB.clear();     
    }
	
	public void clearPass()
    {
		wait.until(ExpectedConditions.visibilityOfAllElements(empPasswordTB));
		empPasswordTB.clear();     
    }
	public void clearRole()
    {
		wait.until(ExpectedConditions.visibilityOfAllElements(empRolesTB));
		empRolesTB.clear();     
    }
    

}
