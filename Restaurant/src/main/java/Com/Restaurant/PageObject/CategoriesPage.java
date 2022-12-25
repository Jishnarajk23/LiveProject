package Com.Restaurant.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class CategoriesPage extends BaseClass {
	WebDriver driver;

	public CategoriesPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//span[contains(text(),'Categories')]")
	WebElement Categories;
	
	@FindBy(xpath = "(//span[contains(text(),'Expense')]")
	WebElement Expense;

	public WebElement Categories()
	{
		return Categories;
	}

	public void CategoriesClick() 
	{
		action.click1(Categories, "Clicking on Categories");
	}

	public WebElement Expense() 
	{
		return Expense;
	}

	public void ExpenseClick() 
	{
		action.click1(Expense, "Clicking on Expense");
	}

	public boolean ExpensDisplayed() 
	{
		return Expense.isDisplayed();
	}

}
