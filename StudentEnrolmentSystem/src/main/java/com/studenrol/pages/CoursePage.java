package com.studenrol.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class CoursePage extends TestBase
{
	public String corsName;
	
	@FindBy(xpath= "//div[@class='row']/div[@class='col-md-4 col-sm-4']//descendant::img")
	List<WebElement> courseImgMO;
	
	@FindBy(xpath= "//div[@class='row']/div[@class='col-md-4 col-sm-4']//descendant::button")
	List<WebElement> knowMoreBtn;
	
	@FindBy(xpath= "//div[@class='row']/div[@class='col-md-4 col-sm-4']//descendant::h3")
	List<WebElement> cName;
	
	@FindBy(xpath="//a[@routerlink='/login/studentlogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement loginText;

	@FindBy(xpath="//div[@class='caption']//h1")
	WebElement courseName;
	
	public CoursePage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String showCoursesName()
	{
		return courseName.getText();
	}
	
	
	public LoginPage knowMoreBtn(String courseName) throws Exception
	{

		for(int i=0;i<cName.size();i++) 
		{
			if(cName.get(i).getText().contains(courseName))
			{
				corsName=cName.get(i).getText();
	
				Actions actions = new Actions(driver);
				Thread.sleep(2000);
				actions.moveToElement(courseImgMO.get(i)).build().perform();
				Thread.sleep(2000);
				actions.moveToElement(knowMoreBtn.get(i)).click().perform();
				break;
			}
		}
		
		return new LoginPage();
		
	}
	
	public EmpLoginPage clickLoginBtn()
	{
		loginBtn.click();
		return new EmpLoginPage();
	}

	public String loginPageTextVerify()
	{
		return loginText.getText();
	}
}
