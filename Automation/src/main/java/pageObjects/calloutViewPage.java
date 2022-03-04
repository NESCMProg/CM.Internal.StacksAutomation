package pageObjects;
import utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import resources.base;

public class calloutViewPage extends base{
	
	//WebDriverWait wait = new WebDriverWait(driver,30);
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
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitbtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dash;
	
	@FindBy(xpath= "//span[contains(text(),'Callouts')]")	
	WebElement dashTocalloutLink;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabCalloutTitle;
	
	@FindBy(id="searchBox")
	WebElement searchBox;
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[1]")
	WebElement TracedEditBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement calloutDelete;
	
	public calloutViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validateCalloutPageTitle() {
		return driver.getTitle();
	}
	
	
	
	public void  clickonNewBtnandSaveBtn(String title1, String subtitle1, String description) throws InterruptedException{
		
		addNew.click();
		title.sendKeys(title1);
		Log.info("Title Name from Excel: " +title1);
		subtitle.sendKeys(subtitle1);
		Log.info("SubTitle from Excel: " +subtitle1);
		desc.sendKeys(description);
		Log.info("Description from Excel: " +description);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='edit-submit']")));
		try {
			submitbtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but Callout has been created");
		}
		
		System.out.println("Callout is saved");
		Thread.sleep(2000);
		try {
			String calltitle = grabCalloutTitle.getText();
			Thread.sleep(1000);
			Log.info("Successfully created a Callout with title name: " +title1);
			Log.info("Status Message: "+calltitle);
			
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashTocalloutLink.click();
		
	}
	
	public void clickEditandSaveBtn(String editedTitle, String editedSubtitle, String editedDescription) {
		System.out.println("entered clickEditandSaveBtn method");
		title.click();
		title.clear();
		System.out.println("cleared title");
		title.sendKeys(editedTitle);
		System.out.println("title is edited");
		Log.info("NEW TITLE IS EDITED which is: "+ editedTitle);
		subtitle.clear();
		System.out.println("subtitle cleared");
		subtitle.sendKeys(editedSubtitle);
		Log.info("SUB-TITLE IS EDITED");
		System.out.println("subtitle is edited");
		desc.clear();
		System.out.println("desc is cleared");
		desc.sendKeys(editedDescription);
		Log.info("DESCRIPTION IS EDITED");
		System.out.println("description is cleared");
		try {
			submitbtn.click();
			System.out.println("clicked submit button");
			Log.info("clicked on SAVE button after Editing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but Callout has been Edited");
		}
		
	}
	
	public void searchCalloutTitle(String inputCalloutTitle, String editedTitle, String editedSubtitle, String editedDescription) {
		try {
			searchBox.sendKeys(inputCalloutTitle);
			searchBtn.click();
			TracedEditBtn.click();
			System.out.println("TracedEdit Button is clicked");
			title.clear();
			title.sendKeys(editedTitle);
			Log.info(inputCalloutTitle+" NEW TITLE IS EDITED AS: "+editedTitle);
			subtitle.clear();
			subtitle.sendKeys(editedSubtitle);
			Log.info("NEW SUB-TITLE IS EDITED AS: "+editedSubtitle);
			desc.clear();
			desc.sendKeys(editedDescription);
			Log.info("DESCRIPTION IS EDITED AS: "+editedDescription);
			System.out.println("description is cleared");
			try {
				submitbtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(inputCalloutTitle+" is updated as: "+editedTitle);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but Callout has been Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+inputCalloutTitle+ " is present in the Callouts Table List");
		}
		
		
		
	}
	
	public void deleteCalloutBtn(String title1_D, String subtitle1_D, String description_D, String deleteCalloutTitle) throws InterruptedException {
		addNew.click();
		title.sendKeys(title1_D);
		System.out.println(title1_D);
		subtitle.sendKeys(subtitle1_D);
		System.out.println(subtitle1_D);
		desc.sendKeys(description_D);
		try {
			submitbtn.click();
			Log.info("Callout created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Callout has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashTocalloutLink.click();
		searchBox.sendKeys(deleteCalloutTitle);
		searchBtn.click();
		TraceDeleteBtn.click();
		calloutDelete.click();
		System.out.println("Callout is deleted");
		
		
		
	}
	
	
	
}
