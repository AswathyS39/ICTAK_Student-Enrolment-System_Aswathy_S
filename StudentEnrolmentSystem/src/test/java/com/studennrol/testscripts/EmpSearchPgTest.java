package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.EmpSearchPage;
import com.studenrol.testbase.TestBase;

public class EmpSearchPgTest extends TestBase
{
	EmpSearchPage objSearch;
	
	@Test(priority=0)
	public void studListDisp() throws Exception
	{
		objSearch=new EmpSearchPage();
		
		//objSearch.headingList();
		
		//objSearch.studentsList();
		Thread.sleep(1000);
		
		objSearch.searchList("Veena");
		
		objSearch.searchList("MCA");
		
		objSearch.searchList("2019");
		
		objSearch.searchList("Kollam");
		
		objSearch.searchList("Flutter");
		
		objSearch.searchList("91");
		
		objSearch.searchList("#$%^");
		
		objSearch.searchList("H^%^%");
		
		Thread.sleep(1000);
	}
	public void empLogout() throws Exception
	{
		objSearch.logoutClick();
		String actualRes=driver.getCurrentUrl();
		String expectedRes=prop.getProperty("loginPgUrl");
		if(driver.getCurrentUrl().equals(expectedRes))
			Assert.assertEquals(expectedRes, actualRes,"Logout Successful");
		else
			Assert.assertTrue(false, "Logoout not working properly!!!!!!......");
	}
	
}
