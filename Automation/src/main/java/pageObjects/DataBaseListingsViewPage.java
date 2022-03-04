package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class DataBaseListingsViewPage extends base {
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewDBL;
	
	@FindBy(id="edit-title")
	WebElement DBLTitle;
	
	@FindBy(id="edit-field-ezproxy-url-und-0-value")
	WebElement MainURL;
	
	//@FindBy(id="edit-field-e-resource-libguide-id-und-0-value")
	//WebElement LibGuideID;
	
	@FindBy(id="edit-field-e-resource-links-und-0-title")
	WebElement subTitle1;
	
	@FindBy(id="edit-field-e-resource-links-und-0-url")
	WebElement subTitle1URL;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabDBListingTitle;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath= "//span[contains(text(),'Database Listings')]")	
	WebElement dashTodataBaseListingsLink;
	
	@FindBy(id="searchBox")
	WebElement searchBox;
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement DBLDelete;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[1]")
	WebElement TracedEditBtn;
	
	
	
	public DataBaseListingsViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickDBLNewBtnandSaveBtn(String DBLTITLE, String Main_URL1, String subTitle_1, String subTitle1_URL ) throws InterruptedException {
		addNewDBL.click();
		DBLTitle.sendKeys(DBLTITLE);
		MainURL.sendKeys(Main_URL1);
		//LibGuideID.sendKeys(LibGuide);
		subTitle1.sendKeys(subTitle_1);
		subTitle1URL.sendKeys(subTitle1_URL);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		Thread.sleep(1000);
		try {
			String DBListingsTitle = grabDBListingTitle.getText();
			System.out.println(DBListingsTitle);
			Log.info("Status Message: "+DBListingsTitle);
			Log.info("Successfully created a Database List with title name: " +DBLTITLE);
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashTodataBaseListingsLink.click();
		
		
		
	}
	
	public void deleteDBLBtn(String DBLTITLE_D, String Main_URL1_D, String subTitle_1_D, String subTitle1_URL_D, String Delete_DBL) {
		addNewDBL.click();
		DBLTitle.sendKeys(DBLTITLE_D);
		MainURL.sendKeys(Main_URL1_D);
		subTitle1.sendKeys(subTitle_1_D);
		subTitle1URL.sendKeys(subTitle1_URL_D);
		try {
			submitBtn.click();
			Log.info("Database Listing is created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Database List is created");
		}
		dashboard.click();
		dashTodataBaseListingsLink.click();
		searchBox.sendKeys(Delete_DBL);
		searchBtn.click();
		TraceDeleteBtn.click();
		DBLDelete.click();
		System.out.println("Database Listing is deleted");
		
	}
	
	public void searchDatabaseListTitle(String inputDBLTitle, String editedTitle, String editedMainURL, String editedsubTitle1, String editedSubTitle1URL) {
		try {
		searchBox.sendKeys(inputDBLTitle);
		searchBtn.click();
		TracedEditBtn.click();
		DBLTitle.clear();
		DBLTitle.sendKeys(editedTitle);
		MainURL.clear();
		MainURL.sendKeys(editedMainURL);
		subTitle1.clear();
		subTitle1.sendKeys(editedsubTitle1);
		subTitle1URL.clear();
		subTitle1URL.sendKeys(editedSubTitle1URL);
		try {
			submitBtn.click();
			System.out.println("clicked submit button");
			Log.info("clicked on SAVE button after Editing details");
			Log.info(inputDBLTitle+" is updated as: "+editedTitle);
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but DatabaseList is Edited");
		}
	}
	catch(Exception e1) {
		Log.info("No such Title "+inputDBLTitle+ " is present in the Database Listings Table List");
	}
	
		
		
		
	}
	
	
	
	
	
	
	

}
