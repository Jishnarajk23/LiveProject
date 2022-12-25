package com.Restaurant.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.ProductPage;
import Com.Restaurant.PageObject.StoresPage;
import Com.Restaurant.Utilities.Log;
import static org.testng.Assert.assertTrue;
import Com.Restaurant.Baseclass.BaseClass;

public class VerifyStoresTest extends BaseClass {
	@Test(priority = 1)
	public void VerifyStores() { 
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("VerifyStores");
		// To click on the store button
		Sp.StoreClick();
		// Check add store is displayed or not
		Assert.assertTrue(Sp.AddStoreDisplayed(), "store page is not loaded");
		Log.endTestCase("VerifyStores");
	}
	
	@Test(priority = 2)
	public void addStores() throws InterruptedException {
		Log.startTestCase("addStores");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Sp.StoreClick();
		// Click on add store button
		Sp.addStoresClick();
		// Set store name.
		Sp.SetStoreDetails();
		// Click on submit button
		Sp.SubmitClick();
		// Search the added store
		Sp.addSearch();
		// To check store is added or not
		Assert.assertTrue(Sp.search(), "Element not found");
		Log.endTestCase("addStores");

	}

	@Test(priority = 3)
	public void EditStores() throws InterruptedException {
		Log.startTestCase("EditStores");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Sp.StoreClick();
		Sp.addSearch();
		Sp.EditElementValue();
		Sp.addSearchAfterEdit();
		Assert.assertTrue(Sp.searchAfterEdit(), "Edited element not added");
		Log.endTestCase("EditStores");
	}

	@Test(priority = 4)
	public void DeleteStores() throws InterruptedException {
		Log.startTestCase("DeleteStores");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Sp.StoreClick();
		Sp.addSearchAfterEdit();
		Sp.DeleteElementClick();
		Sp.addSearchAfterEdit();
		Assert.assertTrue(Sp.DeleteSucsess(), "Stores not deleted");
		Log.endTestCase("DeleteStores");
	}
}
