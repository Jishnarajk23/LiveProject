package com.Restaurant.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.PeoplePage;
import Com.Restaurant.PageObject.ProductPage;
import Com.Restaurant.Utilities.Log;

public class VerifyPeopleTest extends BaseClass {
	@Test(priority = 1)
	public void VerifyPeople() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("VerifyPeople");
		Pp.PeopleClick();
		Assert.assertTrue(Pp.WaitersDisplayed(), "product page is not loaded");
		Log.endTestCase("VerifyPeople");
	}

	@Test(priority = 2)
	public void AddWaiters() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("AddWaiters");
		Pp.PeopleClick();
		Pp.WaitersClick();
		Pp.AddWaitersClick();
		Pp.SetWaitersName();
		Pp.SubmitClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "Element not found");
		Log.endTestCase("AddWaiters");
	}

	@Test(priority = 3)
	public void SearchWaiters() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("SearchWaiters");
		Pp.PeopleClick();
		Pp.WaitersClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "Element not found");
		Log.endTestCase("SearchWaiters");
	}

	@Test(priority = 4)
	public void DeleteWaiters() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("DeleteWaiters");
		Pp.PeopleClick();
		Pp.WaitersClick();
		Pp.addSearch();
		Pp.DeleteElementClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.DeleteSucsess(), "Waiters delete not success");
		Log.endTestCase("DeleteWaiters");
	}

	@Test(priority = 5)
	public void AddCustomers() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("AddCustomers");
		Pp.PeopleClick();
		Pp.CustomersClick();
		Pp.addCustomerClick();
		Pp.SetCustomersName("jishna","def","ghi@gmail.com","jkl");
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "Added Customer not found");
		Log.endTestCase("AddCustomers");
	}

	@Test(priority = 6)
	public void SearchCustomers() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("SearchCustomers");
		Pp.PeopleClick();
		Pp.CustomersClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "search sucsess");
		Log.endTestCase("SearchCustomers");
	}
	

	@Test(priority = 7)
	public void DeleteCustomers() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("DeleteCustomers");
		Pp.PeopleClick();
		Pp.CustomersClick();
		Pp.addSearch();
		Pp.DeleteElementClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.DeleteSucsess(), "Delete customer not sucsess");
		Log.endTestCase("DeleteCustomers");
	}
	
	@Test(priority = 8)
	public void AddSupplier() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("AddSupplier");
		Pp.PeopleClick();
		Pp.SuppliersClick();
		Pp.AddSupplierClick();
		Pp.SetSupplierDetails();
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "search sucsess");
		Log.endTestCase("AddSupplier");
	}

	@Test(priority = 9)
	public void SearchSuppliers() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("SearchSuppliers");
		Pp.PeopleClick();
		Pp.SuppliersClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.search(), "search sucsess");
		Log.endTestCase("SearchSuppliers");
	}
	
	@Test(priority = 10)
	public void DeleteSuppliers() throws InterruptedException {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("DeleteSuppliers");
		Pp.PeopleClick();
		Pp.SuppliersClick();
		Pp.addSearch();
		Pp.DeleteElementClick();
		Pp.addSearch();
		Assert.assertTrue(Pp.DeleteSucsess(), "Delete not sucsess");
		Log.endTestCase("DeleteSuppliers");
	}
	
}
