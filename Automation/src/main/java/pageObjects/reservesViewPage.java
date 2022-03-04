package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class reservesViewPage extends base{

	@FindBy(xpath="//a[contains(text(),'Add New')]")
	WebElement addNewReserve;
	
	@FindBy(id="edit-title")
	WebElement reserveTitle;
	
	@FindBy(id="edit-field-registrar-course-id-und-0-value")
	WebElement registrarID;
	
	@FindBy(id="edit-field-course-id-und-0-value")
	WebElement courseID;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement submitBtn;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(xpath= "//span[contains(text(),'Reserves')]")	
	WebElement dashToResourceFlowLink;
	
	@FindBy(xpath= "//span[contains(text(),'Reserves')]")
	WebElement dashToreservesLink;
	
	@FindBy(xpath="//div[@class='messages status']")
	WebElement grabReserveTitle;
	
	public reservesViewPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickReserveNewandSaveBtn(String C_reserveTitle, String C_registrarID, String C_courseID) throws InterruptedException {
		addNewReserve.click();
		reserveTitle.sendKeys(C_reserveTitle);
		registrarID.sendKeys(C_registrarID);
		courseID.sendKeys(C_courseID);
		Thread.sleep(1000);
		try {
			
			submitBtn.click();
			Log.info("Reserves is created");
		}
		catch(Exception e) {
			Log.error("Unable to get status message, but Reserves has been created");
		}
		System.out.println("New Reserve is created");
		Thread.sleep(1000);
		try {
			String reserveTitle = grabReserveTitle.getText();
			System.out.println(reserveTitle);
			Log.info("Status Message: "+reserveTitle);
			Log.info("Successfully created a Resource Flow with title name: " +C_reserveTitle);
			Thread.sleep(2000);
		}
		catch(Exception e2) {
			
		}
		
		try {
			dashboard.click();
		}
		catch(Exception e3) {
			
		}
		
		dashToreservesLink.click();
	}
	
	
	
	
	
	
	
	
	
}
