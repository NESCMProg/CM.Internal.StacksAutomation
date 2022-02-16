package pageObjects;
import utility.Log;
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
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='edit-submit']")));
		try {
			submitbtn.click();
			Log.info("clicked on SAVE button after providing details");
		}
		catch(Exception e) {
			Log.info("Unable to get status message, but Callout has been created");
		}
		
		System.out.println("Callout is saved");
		Thread.sleep(1000);
		String calltitle = grabCalloutTitle.getText();
		Thread.sleep(1000);
		Log.info("Successfully created a Callout with title name: " +calltitle);
		
		
	}
	
	
	
}
