package Com.Restaurant.PageObject;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class StoresPage extends BaseClass {
	WebDriver driver;

	public StoresPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement DataElementEmpty;

	@FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='Stores'])[1]")
	WebElement Stores;

	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement addStores;

	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
	WebElement AddStores;

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement SearchedElement;

	@FindBy(xpath = "//input[@id='StoreName']")
	WebElement StoreName;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	WebElement DeleteElement;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement DeletePopup;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement DeleteButton;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement EditElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailId;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//input[@name='country']")
	WebElement Country;

	@FindBy(xpath = "//input[@name='city']")
	WebElement City;

	@FindBy(xpath = "//input[@name='adresse']")
	WebElement Address;

	public WebElement Stores() 
	{
		return Stores;
	}

	public void StoreClick() 
	{
		action.click1(Stores, "Clicking on Stores");
	}

	public WebElement Search() 
	{
		return Search;
	}

	public void addSearch() 
	{
		action.type(Search, "XYZ");
	}

	public WebElement addStores() 
	{
		return addStores;
	}

	public WebElement AddStores() 
	{
		return AddStores;
	}

	public WebElement SearchedElement() 
	{
		return SearchedElement;
	}

	public boolean AddStoreDisplayed()
	{
		return addStores.isDisplayed();
	}

	public WebElement StoreName() 
	{
		return StoreName;
	}

	public WebElement DeleteElement() 
	{
		return DeleteButton;
	}

	public WebElement EditElement() 
	{
		return EditElement;
	}

	public WebElement DataElementEmpty()
	{
		return DataElementEmpty;
	}

	public WebElement DeletePopup()
	{
		return DeletePopup;
	}

	public void addStoresClick() 
	{
		action.click1(addStores, "Clicking on addStores");
	}

	public void SetStoreDetails() 
	{
		try {
			ArrayList list = Excel.getData("StoreData");
			action.explicitWait(getDriver(), StoreName, Duration.ofSeconds(20));
			action.type(StoreName, list.get(0).toString());
			action.type(EmailId, list.get(1).toString());
			action.type(PhoneNumber, list.get(2).toString());
			action.type(Country, list.get(3).toString());
			action.type(City, "Kozhikode");
			action.type(Address, "Arunima");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SubmitClick()
	{
		action.click1(AddStores, "Clicking on submit");
	}

	public boolean search() 
	{
		String serchedElement = SearchedElement.getText();
		if (serchedElement.equalsIgnoreCase("XYZ")) {
			return true;
		}
		return false;
	}

	public void addSearchAfterEdit() 
	{
		action.type(Search, "XYZA");
	}

	public boolean searchAfterEdit() 
	{
		String serchedElement = SearchedElement.getText();
		if (serchedElement.equalsIgnoreCase("XYZA")) {
			return true;
		}
		return false;
	}

	public void DeleteElementClick()
	{
		action.click1(DeleteButton, "Delete button");
	}

	public boolean DeleteSucsess()
	{
		if (DataElementEmpty.getText().equalsIgnoreCase("No matching records found")) {
			return true;
		} else
			return false;
	}

	public void EditElementValue() {
		EditElement.click();
		action.type(StoreName, "XYZA");
		action.click1(SubmitButton, "Submit");
	}
}
