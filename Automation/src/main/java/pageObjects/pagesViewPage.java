package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class pagesViewPage extends base {
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewPage;
	
	@FindBy(id="edit-title")
	WebElement pageTitle;
	
	@FindBy(css="#edit-field-workflow-und-0-workflow-workflow-comment")
	WebElement pagesWorkFlowcmt;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(css= "div#div_16.large-3.medium-6.small-12.columns.sortees.end.ui-sortable-handle")	
	WebElement dashToPagesLink;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabPageTitle;
	
	@FindBy(id="searchBox")
	WebElement searchBox;
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[1]")
	WebElement TracedEditBtn;
	
	@FindBy(xpath="//tr[@class='odd']/td[1]//following-sibling::td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement pageDelete;
	
	public pagesViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	
	public void clickPagesNewandSaveBtn(String pgTitle, String pageWorkFlow) throws InterruptedException {
		addNewPage.click();
		pageTitle.sendKeys(pgTitle);
		pagesWorkFlowcmt.sendKeys(pageWorkFlow);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		System.out.println("New Page is created");
		Thread.sleep(1000);
		try {
			String pageTitle = grabPageTitle.getText();
			System.out.println(pageTitle);
			Log.info("Status Message: "+pageTitle);
			Log.info("Successfully created a Resource Flow with title name: " +pgTitle);
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashToPagesLink.click();
	}
	
	public void searchPageTitle(String existingPageTitle, String E_Title, String E_pagesWorkFlowcmt) {
		try {
			searchBox.click();
			searchBtn.sendKeys(existingPageTitle);
			TracedEditBtn.click();
			pageTitle.clear();
			pageTitle.sendKeys(E_Title);
			pagesWorkFlowcmt.clear();
			pagesWorkFlowcmt.sendKeys(E_pagesWorkFlowcmt);
			try {
				submitBtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(existingPageTitle+" is updated as: "+E_Title);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but Page has been Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+existingPageTitle+ " is present in the Pages Table List");
		}
		
		
		
		
	}
	
	public void deletePageBtn(String d_pageTitle, String D_pagesWorkFlowcmt, String deletePageTitle) throws InterruptedException {
		addNewPage.click();
		pageTitle.sendKeys(d_pageTitle);
		pagesWorkFlowcmt.sendKeys(D_pagesWorkFlowcmt);
		try {
			submitBtn.click();
			Log.info("Page is created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Page has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashToPagesLink.click();
		searchBox.sendKeys(deletePageTitle);
		searchBtn.click();
		TraceDeleteBtn.click();
		pageDelete.click();
		System.out.println(d_pageTitle+"Page is deleted");
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
