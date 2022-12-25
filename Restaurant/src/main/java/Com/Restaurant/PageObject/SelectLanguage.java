package Com.Restaurant.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class SelectLanguage extends BaseClass {

	@FindBy(xpath = "//li[@class='dropdown language']")
	WebElement Language;

	@FindBy(xpath = "(//li/ul[@class='dropdown-menu'])[3]/li[2]")
	WebElement France;

	@FindBy(xpath = "(//li/ul[@class='dropdown-menu'])[3]/li[3]")
	WebElement portuguese;

	@FindBy(xpath = "(//li/ul[@class='dropdown-menu'])[3]/li[1]")
	WebElement English;

	@FindBy(xpath = "//h1[@class='text-center choose_store']")
	WebElement StoreContent;

	public SelectLanguage() 
	{
		PageFactory.initElements(getDriver(), this);
	}

	public void SelectFrance() 
	{
		action.click1(Language, "Language ");
		action.click1(France, "France selected");
	}

	public boolean IsChanged()
	{
		action.explicitWait(getDriver(), StoreContent, Duration.ofSeconds(20));
		String storeContentText = StoreContent.getText();
		if (storeContentText.equalsIgnoreCase("Choisissez un boutique")) {
			return true;
		}
		return false;
	}

	public boolean IsChangedToEnglish() 
	{
		action.explicitWait(getDriver(), StoreContent, Duration.ofSeconds(20));
		String storeContentText = StoreContent.getText();
		if (storeContentText.equalsIgnoreCase("Choose a store")) {
			return true;
		}
		return false;
	}

	public boolean IsChangedToPotuguese() 
	{
		action.explicitWait(getDriver(), StoreContent, Duration.ofSeconds(20));
		String storeContentText = StoreContent.getText();
		if (storeContentText.equalsIgnoreCase("Escolha uma loja")) {
			return true;
		}
		return false;
	}

	public void SelectEnglish() 
	{
		action.explicitWait(getDriver(), Language, Duration.ofSeconds(20));
		action.click1(Language, "Language");
		action.click1(English, "English");
	}

	public void SelectPortuguese() 
	{
		action.click1(Language, "Language");
		action.click1(portuguese, "portuguese");
	}
}