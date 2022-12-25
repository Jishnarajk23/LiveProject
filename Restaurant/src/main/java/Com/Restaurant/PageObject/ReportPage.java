package Com.Restaurant.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class ReportPage extends BaseClass {

	public ReportPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	WebElement Reports;

	@FindBy(xpath = "//h3[contains(text(),'Top 5 Products this year')]")
	WebElement Top5Prod;

	@FindBy(xpath = "//h3[text()='Clients Stats']")
	WebElement ClientsStat;

	@FindBy(xpath = "(//b[@role='presentation'])[1]")
	WebElement SelectClientDrop;

	@FindBy(xpath = "//input[@id='CustomerRange']")
	WebElement ClientCalender;

	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[1]")
	WebElement ClientReport;

	@FindBy(xpath = "//h4[@id='stats']")
	WebElement StatusOfReport;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement Close;

	@FindBy(xpath = "(//span[@role='presentation'])[2]")
	WebElement ProductStatus;


	@FindBy(xpath = "//input[@id='ProductRange']")
	WebElement ProdRange;

	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[2]")
	WebElement ProdReport;
	@FindBy(xpath = "//h3[text()='Stock stats']")
	WebElement StoreStat;

	@FindBy(xpath = "//span[contains(text(),'OMStores')]")
	WebElement SelectStore;

	@FindBy(xpath = "//input[@id='RegisterRange']")
	WebElement RegisCal;
	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[3]")
	WebElement RegReport;

	@FindBy(xpath = "(//button[@class='btn btn-Year'])[1]")
	WebElement PrevYear;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement NextYear;

	@FindBy(xpath = "//h1[@class='statYear']")
	WebElement CurrentYear;

	public WebElement ProdReport() {
		return ProdReport;
	}

	public WebElement SelectRegStore() {
		return SelectStore;
	}

	public WebElement RegisCal() {
		return RegisCal;
	}

	public WebElement Report() {
		return Reports;
	}

	public WebElement RegRepo() {
		return RegReport;
	}

	public WebElement TopProducts() {
		return Top5Prod;

	}

	public WebElement Clientstat() {
		return ClientsStat;
	}

	public WebElement ClientDrop() {
		return SelectClientDrop;
	}

	public WebElement ClientCal() {
		return ClientCalender;
	}

	public WebElement ClientRep() {
		return ClientReport;
	}

	public WebElement Producttat() {
		return ProductStatus;
	}

	public WebElement Productrange() {
		return ProdRange;
	}

	public WebElement ProdRep() {
		return ProdReport;
	}

	public void ClickOnReports() {
		action.click1(Reports, "Clicking on Reports");
	}

	public void ClickOnSelectClient() {
		ClickOnReports();
		action.click1(ClientReport, "Clicking on Report");

	}

	public void ClickOnSelectProduct() {
		ClickOnReports();
		action.click1(ProdReport, "Clicking on Report");

	}

	public void ClickOnSelectStore() {
		ClickOnReports();
		action.click1(RegReport, "Clicking on Report");
	}

	public Boolean IsStatPresent() {
		action.explicitWait(getDriver(), StatusOfReport, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), StatusOfReport);
	}

	public Boolean IsTop5ProductsPresent() {
		return action.isDisplayed(getDriver(), Top5Prod);
	}

	public boolean IsReportStatusPresent() {
		action.explicitWait(getDriver(), StatusOfReport, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), StatusOfReport);
	}

	public void ClickonClose() {
		action.click1(Close, "ClickingonClose");
	}

	public int CurrentYear() {
		return Integer.parseInt(CurrentYear.getText());
	}

	public boolean IsClickOnNextYear() {
		int YearBeforeClick = CurrentYear();
		action.click1(NextYear, "Next Year");
		int YearAfterClick = Integer.parseInt(CurrentYear.getText());
		if (YearAfterClick == YearBeforeClick + 1) {
			return true;
		}
		return false;
	}

	public boolean IsClickOnPrevYear() {
		int YearBeforeClick = CurrentYear();
		action.click1(PrevYear, "PrevYear");
		int YearAfterClick = Integer.parseInt(CurrentYear.getText());
		if (YearAfterClick == YearBeforeClick - 1) {
			return true;
		}
		return false;
	}
}