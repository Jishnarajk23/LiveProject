package com.Restaurant.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.ReportPage;
import Com.Restaurant.Utilities.Log;
import Com.Restaurant.Utilities.RetryTestCases;

public class VeriyReportPageTest extends BaseClass {
	@Test(priority=1,retryAnalyzer = RetryTestCases.class)
	public void VerifyReportPage() throws InterruptedException {
		Log.startTestCase("VerifyReportPage");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnReports();
		Assert.assertTrue(Rp.IsTop5ProductsPresent());
		Log.endTestCase("VerifyReportPage");
	}
	
	@Test(priority=2)
	public void VerifyReportPageClientStat() throws InterruptedException {
		Log.startTestCase("VerifyReportPageClientStat");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnSelectClient();
		Assert.assertTrue(Rp.IsReportStatusPresent());
		Rp.ClickonClose();
		Log.endTestCase("VerifyReportPageClientStat");
	}

	@Test(priority=3)
	public void VerifyReportProductStat() throws InterruptedException {
		Log.startTestCase("VerifyReportProductStat");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnSelectProduct();
		Assert.assertTrue(Rp.IsReportStatusPresent());
		Rp.ClickonClose();
		Log.endTestCase("VerifyReportProductStat");
	}
	
	@Test(priority=4)
	public void VerifyReportStoreStat() throws InterruptedException {
		Log.startTestCase("VerifyReportStoreStat");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnSelectStore();
		Assert.assertTrue(Rp.IsReportStatusPresent());
		Rp.ClickonClose();
		Log.endTestCase("VerifyReportStoreStat");
	}
	
	@Test(priority=5)
	public void ClickOnPreviousYear() throws InterruptedException {
		Log.startTestCase("ClickOnPreviousYear");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnReports();	
		Assert.assertTrue(Rp.IsClickOnPrevYear(), "Not ClickOnPreviousYear");
		Log.endTestCase("ClickOnPreviousYear");
	}
	
	@Test(priority=6)
	public void ClickOnNextYear() throws InterruptedException {
		Log.startTestCase("ClickOnNextYear");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Rp.ClickOnReports();	
		Assert.assertTrue(Rp.IsClickOnNextYear(), "Not ClickOnNextYear");
		Log.endTestCase("ClickOnNextYear");
	}
}