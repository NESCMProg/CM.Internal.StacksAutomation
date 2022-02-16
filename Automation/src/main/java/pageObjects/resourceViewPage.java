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
	
	public resourceViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickresourceNewandSaveBtn(String rtitle1, String ISBN1, String upc1, String rtitle11, String author1, String wfcmts, String rlm) throws InterruptedException {
		addNewResource.click();
		resourceTitle.sendKeys(rtitle1);
		Thread.sleep(1000);
		ISBN.sendKeys(ISBN1);
		UPC.sendKeys(upc1);
		title.sendKeys(rtitle11);
		author.sendKeys(author1);
		rfWorkFlowcmt.sendKeys(wfcmts);
		resourceflowrlm.sendKeys(rlm);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		
		System.out.println("Resource Flow is saved");
		Thread.sleep(1000);
		String resourceFlowTitle = grabresourceflowTitle.getText();
		System.out.println(resourceFlowTitle);
		Log.info("Successfully created a Resource Flow with title name: " +resourceFlowTitle);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
