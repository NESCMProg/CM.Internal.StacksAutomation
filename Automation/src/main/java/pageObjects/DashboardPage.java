package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class DashboardPage extends base {
																	
	@FindBy(xpath= "//span[contains(text(),'Callouts')]")
	WebElement calloutLink;
		
	@FindBy(xpath= "//span[contains(text(),'Custom Blocks')]")
	WebElement customBlockLink;
	
	@FindBy(xpath= "//span[contains(text(),'Resource Flows')]")
	WebElement resourceFlowLink;
	
	@FindBy(xpath= "//span[contains(text(),'News Articles')]")
	WebElement newsArticlesLink;
	
	@FindBy(xpath= "//span[contains(text(),'Database Listings')]")
	WebElement databaseListingsLink;
	
	@FindBy(xpath= "//span[contains(text(),'Directory Listings')]")
	WebElement directoryListingsLink;
	
	@FindBy(css="div#div_16.large-3.medium-6.small-12.columns.sortees.end.ui-sortable-handle")
	WebElement pagesLink;
	
	@FindBy(xpath= "//span[contains(text(),'Reserves')]")
	WebElement reservesLink;
	
	
	
	@FindBy(css="a.close-reveal-modal")
	WebElement alertmessage;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
 
	//Action
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	

	public calloutViewPage clickOnCalloutsLink() {
		System.out.println("This is dashboard page inside POM");
		alertmessage.click();
		calloutLink.click();
		return new calloutViewPage();
	}
	
	public resourceViewPage clickOnResourceFlowLink() {
		System.out.println("This is dashboard page inside POM");
		resourceFlowLink.click();
		return new resourceViewPage();
	}
	
	public CustomBlockViewPage clickOnCustomBlockLink() {
		customBlockLink.click();
		return new CustomBlockViewPage();
	}
	
	public  NewsArticleViewPage clickOnNewsArticlesLink() {
		System.out.println("This is dashboard page inside POM");
		alertmessage.click();
		newsArticlesLink.click();
		return new NewsArticleViewPage() ;
	}
	
	public DataBaseListingsViewPage clickOnDatabaseListingLink() {
		alertmessage.click();
		databaseListingsLink.click();
		return new DataBaseListingsViewPage();
		
	}
	
	public directoryListingsViewPage clickOnDirectoryListingsLink() {
		alertmessage.click();
		directoryListingsLink.click();
		return new directoryListingsViewPage();
	}
	
	public pagesViewPage clickOnPagesLink() {
		alertmessage.click();
		pagesLink.click();
		return new pagesViewPage();
	}
	
	public reservesViewPage clickonReservesLink() {
		alertmessage.click();
		reservesLink.click();
		return new reservesViewPage();
	}
	
	
	
}

