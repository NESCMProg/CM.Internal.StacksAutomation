package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class DashboardPage extends base {
																	
	@FindBy(xpath= "//span[contains(text(),'Callouts')]")
	WebElement calloutLink;
	
	@FindBy(xpath= "//span[contains(text(),'Pages')]")
	WebElement pagesLink;
	
	@FindBy(xpath= "//span[contains(text(),'Custom Blocks')]")
	WebElement customBlockLink;
	
	@FindBy(xpath= "//span[contains(text(),'Resource Flows')]")
	WebElement resourceFlowLink;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
 
	//Action
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	

	public calloutViewPage clickOnCalloutsLink() {
		System.out.println("This is dashboard page inside POM");
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
	
	
	
}

