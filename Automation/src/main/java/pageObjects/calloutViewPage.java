package pageObjects;
import utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class calloutViewPage extends base{
	
	
	@FindBy(xpath="//h1[contains(text(),'Callouts')]")
	WebElement calloutsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNew;
	
	@FindBy(id="edit-title")
	WebElement title;
	
	@FindBy(id="edit-field-callouts-und-0-field-callout-title-und-0-value")
	WebElement subtitle;
	
	@FindBy(xpath="//textarea[@id='edit-field-callouts-und-0-field-callout-description-und-0-value']")
	WebElement desc;
	
	@FindBy(css="#edit-submit")
	WebElement submitbtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dash;
	
	@FindBy(xpath= "//span[contains(text(),'Callouts')]")
	WebElement dashTocalloutLink;
	
	//@FindBy(css="h1.page-title item-block-title ")
	//WebElement grabCalloutTitle;
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabCalloutTitle;
	public calloutViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validateCalloutPageTitle() {
		return driver.getTitle();
	}
	

	
	public void  clickonNewBtnandSaveBtn(String title1, String subtitle1, String description) throws InterruptedException{
		addNew.click();
		title.sendKeys(title1);
		subtitle.sendKeys(subtitle1);
		desc.sendKeys(description);
		Thread.sleep(3000);
		submitbtn.click();
		System.out.println("Callout is saved");
		Thread.sleep(1000);
		String calltitle = grabCalloutTitle.getText();
		Thread.sleep(1000);
		Log.info("Successfully created a Callout with title name: " +calltitle);
		
		
		//driver.navigate().back();
		//driver.navigate().back();
		//dash.click();
		//dashTocalloutLink.click();
		
		
	}
	
	
	
}
