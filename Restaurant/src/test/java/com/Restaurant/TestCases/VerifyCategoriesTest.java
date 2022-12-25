package com.Restaurant.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.CategoriesPage;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.StoresPage;
import Com.Restaurant.Utilities.Log;

public class VerifyCategoriesTest extends BaseClass {

	@Test(priority = 1)
	public void VerifyCategories() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("VerifyCategories");
		Cp.CategoriesClick();
		Cp.ExpenseClick();
		Assert.assertTrue(Cp.ExpensDisplayed(), "store page is not loaded");
		Log.endTestCase("VerifyCategories");
	}
}
