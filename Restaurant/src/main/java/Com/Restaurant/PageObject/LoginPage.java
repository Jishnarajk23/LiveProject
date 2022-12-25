package Com.Restaurant.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class LoginPage extends BaseClass 
{
	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement Uname;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PWord;
	
	@FindBy(name = "submit")
	WebElement submit;
	
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logOut;
	
	@FindBy(css = "img[alt='logo']")
	WebElement Logo;

	public LoginPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	public WebElement DispLogo() 
	{
		return Logo;
	}
	public WebElement UserName() 
	{
		return Uname;
	}

	public WebElement Password() 
	{
		return PWord;
	}

	public boolean IsLogoDisplayed() 
	{
		return true;
	}

	public WebElement Submit()
	{
		return submit;
	}

	public WebElement Logout() 
	{
		return logOut;
	}

	public boolean IsLogoutDisplayed() 
	{
		return logOut.isDisplayed();
	}
	
	public boolean IsSubmitDisplayed() 
	{
		return submit.isDisplayed();
	}
	
	public Boolean IsLogoPresent() 
	{
		return action.isDisplayed(getDriver(), Logo);
	}
	
	public void LogoutFun() 
	{
		action.click1(logOut, "Clicking on logout buton");
	}

	public void Login(String username, String password)
	{
		action.type(UserName(), username);
		action.type(PWord, password);
		action.click1(submit, "Clicking on login buton");
	}

	public void InvalidLogin(String username, String password) 
	{
		action.type(UserName(), username);
		action.type(PWord, password);
		action.click1(submit, "Clicking on login buton");
	}
}
