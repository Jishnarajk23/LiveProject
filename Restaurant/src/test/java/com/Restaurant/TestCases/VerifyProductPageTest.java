package com.Restaurant.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.ProductPage;
import Com.Restaurant.Utilities.Log;

public class VerifyProductPageTest extends BaseClass {
	@Test(priority = 1)
	public void VerifyProduct() {
		Assert.assertTrue(Lp.IsLogoDisplayed(), "Login page is not loaded");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Log.startTestCase("VerifyProductPage");
		ProPp.clickOnProductPage();
		Assert.assertTrue(ProPp.IsDisplayedProductType(), "product page is not loaded");
		Log.endTestCase("VerifyProductPage");
	}

	@Test(priority = 2)
	public void VerifySelectEachElements() {
		Log.startTestCase("VerifySelectEachElements");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		ProPp.clickOnProductPage();
		ProPp.SelectEachElements();
		Assert.assertEquals(ProPp.IsDisplayedShowElement(), "100");
		Log.endTestCase("VerifySelectEachElements");
	}

	@Test(priority = 3)
	public void selectSupplier() throws InterruptedException {
		Log.startTestCase("selectSupplier");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		ProPp.clickOnProductPage();
		ProPp.SelectSuppplier();
		Assert.assertTrue(ProPp.SelectedSupplierContent(), "All is not selected");
		Log.endTestCase("selectSupplier");
	}
	

	@Test(priority = 4)
	public void addProduct() throws InterruptedException {
		Log.startTestCase("addProduct");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		ProPp.clickOnProductPage();
		ProPp.addProductClick();
		ProPp.SetProductCode();
		ProPp.SetProductName();
		ProPp.SetProductPrice();
		ProPp.buttonClick();
		ProPp.AddStoreClick();
		ProPp.addSearch();
		Assert.assertTrue(ProPp.search(), "Search element not found");
		Log.endTestCase("addProduct");

	}

	@Test(priority = 5)
	public void EditProduct() throws InterruptedException {
		Log.startTestCase("EditProduct");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		ProPp.clickOnProductPage();
		ProPp.addSearch();
		ProPp.EditElementValue();
		ProPp.addSearch();
		Assert.assertTrue(ProPp.search(), "Element not found");
		Log.endTestCase("EditProduct");

	}

	@Test(priority = 6)
	public void deleteProduct() throws InterruptedException {
		Log.startTestCase("deleteProduct");
		Lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		ProPp.clickOnProductPage();
		ProPp.addSearch();
		ProPp.DeleteElementClick();
		ProPp.addSearch();
		Assert.assertTrue(ProPp.DeleteSucsess(), "Not deleted");
		Log.endTestCase("deleteProduct");

	} 

}
