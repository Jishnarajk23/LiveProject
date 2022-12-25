package com.Restaurant.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.Utilities.Log;

public class VerifyEachLanguageTest extends BaseClass {

	@Test(priority=1, dependsOnMethods= {"SelectPortuguese"})
	public void SelectFrance() {
		Log.startTestCase("SelectFrance");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sl.SelectFrance();
		Assert.assertTrue(Sl.IsChanged(), "language not changed");
		Sl.SelectEnglish();
		Assert.assertTrue(Sl.IsChangedToEnglish(),"Not Changed to english") ;
		Log.endTestCase("SelectFrance");
	}
	
	@Test
	public void SelectPortuguese(){
		Log.startTestCase("SelectPortuguese");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sl.SelectPortuguese();
		Assert.assertTrue(Sl.IsChangedToPotuguese(), "language not changed");
		Sl.SelectEnglish();
		Assert.assertTrue(Sl.IsChangedToEnglish(),"Not Changed to english") ;
		Log.endTestCase("SelectPortuguese");
	}
}