package Com.Restaurant.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class PeoplePage extends BaseClass {
	WebDriver driver;

	public PeoplePage() 
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@placeholder='Supplier Name']")
	WebElement SupplierName;

	@FindBy(xpath = "//button[normalize-space()='Add Customer']")
	WebElement AddCustomer;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement DataElementEmpty;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	WebElement DeleteElement;

	@FindBy(xpath = "//span[normalize-space()='People']")
	WebElement People;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit;

	@FindBy(xpath = "//span[normalize-space()='Waiters']")
	WebElement Waiters;

	@FindBy(xpath = "//span[normalize-space()='Suppliers']")
	WebElement Suppliers;

	@FindBy(xpath = "//span[normalize-space()='Customers']")
	WebElement Customers;

	//@FindBy(xpath = "(//button[contains(text(),'Add Waiter')]")
	@FindBy(xpath = "//button[normalize-space()='Add Waiter']")
	WebElement AddWaiters;

	@FindBy(xpath = "//input[@id='WaiterName']")
	WebElement WaiterName;
	
	@FindBy(xpath = "//input[@id='CustomerName']")
	WebElement CustomerName;

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement SearchedElement;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement DeletePopup;

	@FindBy(xpath = "//button[normalize-space()='Add Supplier']")
	WebElement AddSupplier;

	@FindBy(id = "CustomerPhone")
	WebElement CustomerPhone;

	@FindBy(id = "CustomerEmail")
	WebElement CustomerEmail;

	@FindBy(id = "CustomerDiscount")
	WebElement CustomerDiscount;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;
	
	@FindBy(id = "SupplierName")
	WebElement SupplierNames;

	@FindBy(id = "SupplierPhone")
	WebElement SupplierPhone;

	@FindBy(id = "SupplierEmail")
	WebElement SupplierEmail;

	public WebElement People() 
	{
		return People;
	}

	public WebElement Waiters() 
	{
		return Waiters;
	}

	public WebElement Suppliers() 
	{
		return Suppliers;
	}

	public WebElement Customers()
	{
		return Customers;
	}

	public boolean WaitersDisplayed() 
	{
		return Waiters.isDisplayed();
	}

	public WebElement AddWaiters()
	{
		return AddWaiters;
	}

	public WebElement Search() 
	{
		return Search;
	}

	public WebElement WaiterName() 
	{
		return WaiterName;
	}

	public WebElement SearchedElement() 
	{
		return SearchedElement;
	}

	public WebElement DeletePopup() 
	{
		return DeletePopup;
	}

	public WebElement DeleteElement() 
	{
		return DeleteElement;
	}

	public WebElement AddCustomer()
	{
		return AddCustomer;
	}
	
	public WebElement Submit() {
		return Submit;
	}
	
	public WebElement AddSupplier() 
	{
		return AddCustomer;
	}
	
	public WebElement SupplierName()
	{
		return SupplierName;
	}
	
	public void WaitersClick() 
	{
		action.click1(Waiters, "Clicking on Waiters");
	}

	public void SuppliersClick() 
	{
		 action.click1(Suppliers, "Clicking on Waiters");
	}
	
	public void CustomersClick()
	{
		action.click1(Customers, "Clicking on Customers");
	}
	
	public void PeopleClick()
	{
		action.click1(People, "Clicking on People");
	}
	
	public void addSearch() 
	{
		Search.sendKeys("jishna");
	}
	
	public void AddWaitersClick() 
	{
		action.click1(AddWaiters, "Clicking on Stores");
	}
	
	public void SetWaitersName()
	{
		action.explicitWait(getDriver(),WaiterName,Duration.ofSeconds(20));
		WaiterName.sendKeys("jishna");
	}
	
	public void addCustomerClick() 
	{
		action.click1(AddCustomer, "Clicking on addCustomer");
	}

	public void AddSupplierClick()
	{
		action.click1(AddSupplier, "AddSupplier");
	}

	public void SetSupplierDetails() 
	{
		action.implicitWait(getDriver(),30);
		action.explicitWait(getDriver(), SupplierName, Duration.ofSeconds(20));
		action.type(SupplierName, "jishna");
		action.type(SupplierPhone, "123");
		action.type(SupplierEmail, "ac@gmail.com");
		action.click1(SubmitButton, "Submit");
	}

	public boolean DeleteSucsess() 
	{
		if (DataElementEmpty.getText().equalsIgnoreCase("No matching records found")) {
			return true;
		} else
			return false;
	}
	
	public void DeleteElementClick() 
	{
		action.click1(DeleteElement, "Clicking on DeleteElement");
		action.click1(DeletePopup, "Clicking on DeletePopup");
	}

	public void SetCustomersName(String Name,String Phone,String Email,String Discount ) 
	{
		action.explicitWait(getDriver(),CustomerName,Duration.ofSeconds(20));
		action.type(CustomerName, Name);
		action.type(CustomerPhone, Phone);
		action.type(CustomerEmail, Email);
		action.type(CustomerDiscount, Discount);
		action.click1(SubmitButton, "Submit");
	}
	
	public boolean search()
	{
		String serchedElement = SearchedElement.getText();
		if (serchedElement.equalsIgnoreCase("jishna")) 
		{
			return true;
		}
		return false;
	}
	
	public void SubmitClick() 
	{
		action.click1(Submit, "Clicking on Submit");;
	}

}
