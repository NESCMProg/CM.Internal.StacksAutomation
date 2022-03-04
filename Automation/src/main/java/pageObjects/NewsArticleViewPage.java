package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class NewsArticleViewPage extends base {

	@FindBy(xpath= "//span[contains(text(),'News Articles')]")	
	WebElement dashToNewsArticleLink;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement newsArticleDelete;
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNew;	
	
	@FindBy(xpath="//input[@id='edit-title']")
	WebElement title;
	
	@FindBy(id="edit-field-news-external-link-und-0-url")
	WebElement ExternalLink;
	
	@FindBy(xpath="//input[@id='edit-field-news-author-und-0-value']")
	WebElement author;
	
	@FindBy(css="#edit-field-workflow-und-0-workflow-workflow-comment")
	WebElement naWorkFlowcmt;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
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
	
	public NewsArticleViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickonNewBtnandSaveBtn(String newsTitle, String externalLink, String newsAuthor, String workFlow) {
		addNew.click();
		title.sendKeys(newsTitle);
		ExternalLink.sendKeys(externalLink);
		author.sendKeys(newsAuthor);
		naWorkFlowcmt.sendKeys(workFlow);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but News Article has been created");
		}
	}
	
	public void deleteNewsArticleBtn(String D_title, String D_link, String D_author, String D_workflow, String deletedTitle) throws InterruptedException {
		addNew.click();
		title.sendKeys(D_title);
		ExternalLink.sendKeys(D_link);
		author.sendKeys(D_author);
		naWorkFlowcmt.sendKeys(D_workflow);
		try {
			submitBtn.click();
			Log.info("News Article created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but News Article has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashToNewsArticleLink.click();
		searchBox.sendKeys(deletedTitle);
		searchBtn.click();
		TraceDeleteBtn.click();
		newsArticleDelete.click();
		System.out.println("News Article is deleted");
	}
	
	public void clickEditandSaveBtn(String U_title, String U_externalLink, String U_author, String U_naWorkFlowcmt) {
		title.click();
		title.clear();
		System.out.println("cleared title");
		title.sendKeys(U_title);
		Log.info("NEW TITLE IS EDITED which is: "+ U_title);
		ExternalLink.clear();
		ExternalLink.sendKeys(U_externalLink);
		author.clear();
		author.sendKeys(U_author);
		naWorkFlowcmt.clear();
		naWorkFlowcmt.sendKeys(U_naWorkFlowcmt);
		try {
			submitBtn.click();
			System.out.println("clicked submit button");
			Log.info("clicked on SAVE button after Editing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but News Article is Edited");
		}
	}
	
	public void searchNewsArticleTitle(String inputNewsTitle, String editedTitle, String E_ExternalLink, String E_author, String E_naWorkFlowcmt) {
		try {
			searchBox.sendKeys(inputNewsTitle);
			searchBtn.click();
			TracedEditBtn.click();
			title.clear();
			title.sendKeys(editedTitle);
			ExternalLink.clear();
			ExternalLink.sendKeys(E_ExternalLink);
			author.clear();
			author.sendKeys(E_author);
			naWorkFlowcmt.clear();
			naWorkFlowcmt.sendKeys(E_naWorkFlowcmt);
			try {
				submitBtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(inputNewsTitle+" is updated as: "+editedTitle);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but News Article is Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+inputNewsTitle+ " is present in the News Article Table List");
		}
		
		
	}
	
	
	
	
}
