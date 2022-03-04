package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.base;
import utility.Log;

public class CustomBlockViewPage extends base {

	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewCustom;
	
	@FindBy(id="edit-title")
	WebElement title;
	
	@FindBy(css="#edit-field-workflow-und-0-workflow-workflow-comment")
	WebElement CustomWorkFlowcmt;
	
	@FindBy(css="#edit-log")
	WebElement Customlm;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabCustomTitle;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath= "//span[contains(text(),'Custom Blocks')]")	
	WebElement dashToCustomBlockLink;
	
	@FindBy(id="searchBox")
	WebElement searchBox;
	
	@FindBy(id="edit-submit")
	WebElement searchBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[2]")
	WebElement TraceDeleteBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[1]")
	WebElement TracedEditBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement customDelete;
	
	//WebElement staticTextFormat = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/fieldset[1]/div[1]/div[2]/select"));
	//Select TextFormat = new Select(staticTextFormat);
	
	
	
	public CustomBlockViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickCustomNewBtnandSaveBtn(String title1, String customWFC, String RLM) throws InterruptedException {
		addNewCustom.click();
		title.sendKeys(title1);
		//TextFormat.selectByVisibleText(txtformat);
		//System.out.println(txtformat);
		CustomWorkFlowcmt.sendKeys(customWFC);
		Customlm.sendKeys(RLM);
		try {
			submitBtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			//Log.error("Unable to find SAVE button after providing details");
		}
		Thread.sleep(2000);
		try {
			String CustomTitle = grabCustomTitle.getText();
			Log.info("Status Message: "+CustomTitle);
			Log.info("Successfully created a Resource Flow with title name: " +title1);
			Thread.sleep(1000);
		}
		catch(Exception e2) {
			
		}
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		dashToCustomBlockLink.click();
		
	}
	
	public void deleteCustomBtn(String title1_D, String workflow_D, String customLog_D, String deleteCustomTitle) throws InterruptedException {
		addNewCustom.click();
		title.sendKeys(title1_D);
		CustomWorkFlowcmt.sendKeys(workflow_D);
		Customlm.sendKeys(customLog_D);
		try {
			submitBtn.click();
			Log.info("Custom Block is created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but custom Block has been created");
		}
		Thread.sleep(2000);
		dashboard.click();
		dashToCustomBlockLink.click();
		searchBox.sendKeys(deleteCustomTitle);
		searchBtn.click();
		TraceDeleteBtn.click();
		customDelete.click();
		System.out.println("Custom Block is deleted");
		
	}
	
	public void searchCustomBlockTitle(String inputCustomTitle, String editedTitle, String editedWorkflow, String editedCustomLog ) {
		try {
			searchBox.sendKeys(inputCustomTitle);
			searchBtn.click();
			TracedEditBtn.click();
			title.clear();
			title.sendKeys(editedTitle);
			CustomWorkFlowcmt.clear();
			CustomWorkFlowcmt.sendKeys(editedWorkflow);
			Customlm.clear();
			Customlm.sendKeys(editedCustomLog);
			try {
				submitBtn.click();
				System.out.println("clicked submit button");
				Log.info("clicked on SAVE button after Editing details");
				Log.info(inputCustomTitle+" is updated as: "+editedTitle);
			}
			catch(Exception e) {
				Log.info("Unable to get status message, but Custom Block is Edited");
			}
		}
		catch(Exception e1) {
			Log.info("No such Title "+inputCustomTitle+ " is present in the Custom Blocks Table List");
		}
		
		
		
	}
}
