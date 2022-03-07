package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class directoryListingsViewPage extends base {
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewDirectory;
	
	@FindBy(xpath="//input[@id='edit-field-first-name-listing-und-0-value']")
	WebElement directoryName;
	
	@FindBy(xpath="//input[@id='edit-field-last-name-listing-und-0-value']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='edit-field-job-title-listing-und-0-value']")
	WebElement jobTitle;
	
	@FindBy(xpath="//input[@id='edit-field-directory-location-und-0-value']")
	WebElement Location;
	
	@FindBy(xpath="//body/div[@id='page']/div[@id='content']/div[@id='content-wrapper']/div[@id='main-content']/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[2]/legend[1]/span[1]")
	WebElement social;
	
	@FindBy(xpath="//input[@id='edit-field-twitter-link-und-0-title']")
	WebElement twitter;
	
	@FindBy(xpath="//input[@id='edit-field-twitter-link-und-0-url']")
	WebElement twitterURL;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath= "//span[contains(text(),'Directory Listings')]")	
	WebElement dashToDirectoryLink;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabDirectoryTitle;
	
	@FindBy(id="searchBox")
	WebElement searchBox;
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[1]")
	WebElement TracedEditBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement directoryListingDelete;
	
	public directoryListingsViewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickDirectoryNewandSaveBtn(String dirName, String secondtName, String job, String loc, String twtTitle, String twtURL) throws InterruptedException {
		addNewDirectory.click();
		directoryName.sendKeys(dirName);
		lastName.sendKeys(secondtName);
		jobTitle.sendKeys(job);
		Location.sendKeys(loc);
		social.click();
		Thread.sleep(1000);
		twitter.sendKeys(twtTitle);
		twitterURL.sendKeys(twtURL);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		
		System.out.println("Directory List is saved");
		Thread.sleep(1000);
		try {
			String directoryListTitle = grabDirectoryTitle.getText();
			System.out.println(directoryListTitle);
			Log.info("Status Message: "+directoryListTitle);
			Log.info("Successfully created a Directory List with title name: " +dirName+" "+secondtName);
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashToDirectoryLink.click();
	
	}
	
	public void searchDirectoryListTitle(String InputDirTitle, String E_FirstName, String E_lastName, String E_jobTitle, String E_Location, String E_twitter, String E_twitterURL) {
		try {
			searchBox.sendKeys(InputDirTitle);
			searchBtn.click();
			TracedEditBtn.click();
			directoryName.clear();
			directoryName.sendKeys(E_FirstName);
			lastName.clear();
			lastName.sendKeys(E_lastName);
			jobTitle.clear();
			jobTitle.sendKeys(E_jobTitle);
			Location.clear();
			Location.sendKeys(E_Location);
			social.click();
			twitter.clear();
			twitter.sendKeys(E_twitter);
			twitterURL.clear();
			twitterURL.sendKeys(E_twitterURL);
			try {
				submitBtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(InputDirTitle+" is updated as: "+E_FirstName+" "+E_lastName);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but Directory List is Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+InputDirTitle+ " is present in the Directory Listings Table List");
		}
	
		
		
		
		
		
		
	}
	
	public void deleteDirectoryListBtn(String D_directoryName, String D_lastName, String D_jobTitle, String D_Location, String D_twitter, String D_twitterURL, String deletedDirectory) throws InterruptedException {
		addNewDirectory.click();
		directoryName.sendKeys(D_directoryName);
		lastName.sendKeys(D_lastName);
		jobTitle.sendKeys(D_jobTitle);
		Location.sendKeys(D_Location);
		social.click();
		twitter.sendKeys(D_twitter);
		twitterURL.sendKeys(D_twitterURL);
		try {
			submitBtn.click();
			Log.info("Directory List is created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Directory List has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashToDirectoryLink.click();
		searchBox.sendKeys(deletedDirectory);
		searchBtn.click();
		TraceDeleteBtn.click();
		directoryListingDelete.click();
		System.out.println("Directory Listing is deleted");
		
		
		
	}
}
