package Com.Restaurant.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Restaurant.Baseclass.BaseClass;

public class ProductPage extends BaseClass {
	WebDriver driver;

	public ProductPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='Product'])[1]")
	WebElement Product;
	
	@FindBy(xpath = "(//div[@id='Addproduct'])")
	WebElement AddProduct;
	
	@FindBy(xpath = "//label[normalize-space()='Product type']")
	WebElement ProductType;
	
	@FindBy(xpath = "//a[[@data-dt-idx='2']]")
	WebElement NextPage;
	
	@FindBy(xpath = "//div[@class='dataTables_info']")
	WebElement NextPageText;
	
	@FindBy(xpath = "//select[@name='Table_length']")
	WebElement ShowCombo;
	
	@FindBy(xpath = "//td[@class='hidden-xs productcode sorting_1']")
	WebElement tableInfo;
	
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement addProduct;
	
	@FindBy(xpath = "//input[@id='ProductCode']")
	WebElement ProductCode;
	
	@FindBy(xpath = "//button[@type='submit'][1]")
	WebElement ApplyFilter;
	
	@FindBy(xpath = "//input[@id='ProductName']")
	WebElement ProductName;
	
	@FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
	WebElement Addbutton;
	
	@FindBy(xpath = "//button[@onclick='updatestock()']")
	WebElement AddStore;
	
	@FindBy(xpath = "//input[@id='Price']")
	WebElement Price;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "//td[@class='hidden-xs productcode sorting_1']")
	WebElement SearchedElement;
	
	@FindBy(xpath = "//i[@class='fa fa-pencil'])[1]")
	WebElement EditElement;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[3]")
	WebElement EditButton;
	
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement DataElementEmpty;
	
	@FindBy(xpath = "//i[@class='fa fa-times']")
	WebElement DeleteElement;
	
    @FindBy(xpath = "//option[contains(text(),'All')])[1]")
    WebElement AllSelected;
    
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement DeletePopup;
	
	@FindBy(id = "Supplier")
	WebElement Supplier;
	
	public WebElement Product() 
	{
		return Product;
	}

	public WebElement AddProduct()
	{
		return AddProduct;
	}

	public WebElement ProductType() 
	{
		return ProductType;
	}
	
	public WebElement NextPage()
	{
		return NextPage;
	}

	public WebElement NextPageText() 
	{
		return NextPageText;
	}

	public boolean IsDisplayedProductType() 
	{
		return ProductType.isDisplayed();
	}

	public void clickOnProductPage()
	{
		action.click1(Product, "Clicking on product buton");
	}

	public String getText()
	{
		return NextPageText.getText();
	}

	public void ClickOnNextPage()
	{
		NextPage.click();
	}

	public WebElement ShowCombo()
	{
		return ShowCombo;
	}

	public void SelectEachElements() 
	{
		Select selectNew = new Select(ShowCombo);
		selectNew.selectByIndex(1);
		selectNew.selectByIndex(2);
		selectNew.selectByIndex(3);
	}

	public String IsDisplayedShowElement() 
	{
		Select selectNew = new Select(ShowCombo);
		return selectNew.getFirstSelectedOption().getText();
	}

	public WebElement ApplyFilter()
	{
		return ApplyFilter;
	}

	public WebElement Supplier()
	{
		return Supplier;
	}

	public void SelectSuppplier() throws InterruptedException
	{
		Select selectNew = new Select(Supplier);
		selectNew.selectByIndex(0);
		ApplyFilter.click();
	}

	public WebElement tableIno() 
	{
		return tableInfo;
	}

	public boolean SelectedSupplierContent() 
	{
		Select selectNew = new Select(Supplier);
		return selectNew.getFirstSelectedOption().getText().equalsIgnoreCase("All");
	}

	public WebElement addProduct() 
	{
		return addProduct;
	}

	public void addProductClick() 
	{
		action.click1(addProduct, "Clicking on addProduct");
	}

	public WebElement ProductCode()
	{
		return ProductCode;
	}

	public void SetProductCode() 
	{
		action.explicitWait(getDriver(), ProductCode, Duration.ofSeconds(20));
		action.type(ProductCode, "1234567");	
	}

	public WebElement ProductName() 
	{
		return ProductName;
	}

	public void SetProductName() 
	{
		action.type(ProductName, "XYZ");
	}

	public WebElement Price() 
	{
		return Price;
	}

	public void SetProductPrice()
	{
		action.type(Price, "10000");
	}

	public WebElement Addbutton()
	{
		return Addbutton;
	}

	public WebElement AddStore() 
	{
		return AddStore;
	}

	public void AddStoreClick()
	{
		AddStore.click();
	}

	public void buttonClick() 
	{
		Addbutton.click();
	}

	public WebElement Search() 
	{
		return Search;
	}

	public void addSearch() 
	{
		action.explicitWait(getDriver(), Search, Duration.ofSeconds(20));
		action.type(Search, "1234567");
	}
	
	public void addSearchAfterEdit() 
	{
		action.type(Search, "XYZA");
	}

	public WebElement SearchedElement()
	{
		return SearchedElement;
	}

	public boolean search() 
	{
		String serchedElement = SearchedElement.getText();
		if (serchedElement.equalsIgnoreCase("1234567")) {
			return true;
		}
		return false;
	}

	public WebElement DeleteElement() 
	{
		return DeleteElement;
	}

	public void DeleteElementClick()
	{
		action.click1(DeleteElement, "Clicking on DeleteElement");
		action.click1(DeletePopup, "Clicking on DeletePopup");
	}

	public WebElement DataElementEmpty() 
	{
		return DataElementEmpty;
	}

	public WebElement DeletePopup()
	{
		return DeletePopup;
	}

	public boolean DeleteSucsess()
	{
		if (DataElementEmpty.getText().equalsIgnoreCase("No matching records found")) {
			return true;
		} else
			return false;
	}

	public WebElement EditElement() 
	{
		return EditElement;
	}

	public void EditElementValue() 
	{
		action.click1(EditButton, "Clicking on EditElement");
		action.type(ProductName, "A");
		action.click1(Addbutton,"Addutton");
	}
}
