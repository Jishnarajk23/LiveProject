package com.Restaurant.TestCases;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.Utilities.Log;

public class VerifyValidUserLoginTest extends BaseClass {

	@Test(groups = { "SMK" }, priority = 1)
	// @Parameters({"UserName"})
	public void VerifyUserLogin() {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(Lp.IsLogoutDisplayed(), "Login page is not loaded");
		Lp.LogoutFun();
	}

	@Test(dataProvider = "InvalidLoginDatas",priority = 2)
	public void VerifyInvalidUserLogin(String userName, String password) {
		Log.startTestCase("VerifyInvalidUserLogin");
		Lp.InvalidLogin(userName, password);
		Assert.assertFalse(Lp.IsSubmitDisplayed(), "Login to site");
		Log.endTestCase("VerifyInvalidUserLogin");
	}
}
