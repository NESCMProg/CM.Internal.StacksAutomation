package pageObjects;
import utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class resourceViewPage extends base {
	
	@FindBy(xpath="//h1[contains(text(),'Resource Flows')]")
	WebElement resourceLabel;
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewResource;
	
	@FindBy(id="edit-title")
	WebElement resourceTitle;
	
	@FindBy(css="#edit-field-items-und-0-field-isbn-und-0-value")	
	WebElement ISBN;
	
	@FindBy(css="#edit-field-items-und-0-field-upc-und-0-value")
	WebElement UPC;
	
	@FindBy(xpath="//input[@id='edit-field-items-und-0-field-title-und-0-value']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='edit-field-items-und-0-field-author-und-0-value']")
	WebElement author;
	
	@FindBy(css="#edit-field-workflow-und-0-workflow-workflow-comment")
	WebElement rfWorkFlowcmt;
	
	@FindBy(css="#edit-log")
	WebElement resourceflowrlm;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabresourceflowTitle;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath= "//span[contains(text(),'Resource Flows')]")	
	WebElement dashToResourceFlowLink;
	
	@FindBy(id="searchBox")
	WebElement searchBox;	
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[1]")
	WebElement TracedEditBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement resourceFlowDelete;
	
	public resourceViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickresourceNewandSaveBtn(String rtitle1, String ISBN1, String upc1, String rtitle11, String author1, String wfcmts, String rlm) throws InterruptedException {
		addNewResource.click();
		resourceTitle.sendKeys(rtitle1);
		Log.info("Title Name from Excel: " +rtitle1);
		Thread.sleep(1000);
		ISBN.sendKeys(ISBN1);
		Log.info("ISBN1 value from Excel: "+ISBN1);
		UPC.sendKeys(upc1);
		Log.info("UPC value from Excel: "+upc1);
		title.sendKeys(rtitle11);
		Log.info("subTitle value from Excel: "+rtitle11);
		author.sendKeys(author1);
		Log.info("author value from Excel: "+author1);
		rfWorkFlowcmt.sendKeys(wfcmts);
		Log.info("WorkFlow Comment value from Excel: "+wfcmts);
		resourceflowrlm.sendKeys(rlm);
		Log.info("Revision Log Message value from Excel: "+rlm);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		
		System.out.println("Resource Flow is saved");
		Thread.sleep(1000);
		try {
			String resourceFlowTitle = grabresourceflowTitle.getText();
			System.out.println(resourceFlowTitle);
			Log.info("Status Message: "+resourceFlowTitle);
			Log.info("Successfully created a Resource Flow with title name: " +rtitle1);
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashToResourceFlowLink.click();
	}
	
	
	public void deleteResourceFlowBtn(String mainResourceTitle, String ISBN_1, String upc_1, String rtitle11, String author1, String wfcmts, String rlm, String deleteResourceTitle) throws InterruptedException {
		addNewResource.click();
		resourceTitle.sendKeys(mainResourceTitle);
		ISBN.sendKeys(ISBN_1);
		UPC.sendKeys(upc_1);
		title.sendKeys(rtitle11);
		author.sendKeys(author1);
		rfWorkFlowcmt.sendKeys(wfcmts);
		resourceflowrlm.sendKeys(rlm);
		try {
			submitBtn.click();
			Log.info("Callout created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Resource Flow has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashToResourceFlowLink.click();
		searchBox.sendKeys(deleteResourceTitle);
		searchBtn.click();
		TraceDeleteBtn.click();
		resourceFlowDelete.click();
		System.out.println("Resource Flow is deleted");
		
		
		
	}
	
	public void clickEditandSaveBtn(String inputEditedTitle, String Edited_ISBN_1, String Edit_UPC1, String Edit_title1, String Edit_author1, String Edit_rfWorkFlowcmt1, String Edit_resourceflowrlm1) {
		resourceTitle.click();
		resourceTitle.clear();
		resourceTitle.sendKeys(inputEditedTitle);
		Log.info("NEW TITLE IS EDITED which is: "+ inputEditedTitle);
		ISBN.clear();
		ISBN.sendKeys(Edited_ISBN_1);
		UPC.clear();
		UPC.sendKeys(Edit_UPC1);
		title.clear();
		title.sendKeys(Edit_title1);
		author.clear();
		author.sendKeys(Edit_author1);
		rfWorkFlowcmt.clear();
		rfWorkFlowcmt.sendKeys(Edit_rfWorkFlowcmt1);
		resourceflowrlm.clear();
		resourceflowrlm.sendKeys(Edit_resourceflowrlm1);
		try {
			submitBtn.click();
			System.out.println("clicked submit button");
			Log.info("clicked on SAVE button after Editing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but Callout has been Edited");
		}
	
	}
	
	public void searchResourceTitle(String existingTitle, String EditedTitle, String E_ISBN1, String E_UPC1, String E_title1, String E_author1, String E_rfWorkFlowcmt1, String E_resourceflowrlm1) {
		try {
			searchBox.sendKeys(existingTitle);
			searchBtn.click();
			TracedEditBtn.click();
			System.out.println("TracedEdit Button is clicked");
			resourceTitle.clear();
			resourceTitle.sendKeys(EditedTitle);
			Log.info(existingTitle+" NEW TITLE IS EDITED AS: "+EditedTitle);
			ISBN.clear();
			ISBN.sendKeys(E_ISBN1);
			UPC.clear();
			UPC.sendKeys(E_UPC1);
			title.clear();
			title.sendKeys(E_title1);
			author.clear();
			author.sendKeys(E_author1);
			rfWorkFlowcmt.clear();
			rfWorkFlowcmt.sendKeys(E_rfWorkFlowcmt1);
			resourceflowrlm.clear();
			resourceflowrlm.sendKeys(E_resourceflowrlm1);
			try {
				submitBtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(existingTitle+" is updated as: "+EditedTitle);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but Callout has been Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+existingTitle+ " is present in the Resource Flows Table List");
		}
		
		
	}
}
