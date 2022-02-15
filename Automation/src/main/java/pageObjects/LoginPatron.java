package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;
import utility.Log;

public class LoginPatron extends base {						
	//Page Factory
	@FindBy(id="edit-name")
	WebElement username;
	
	@FindBy(id="edit-pass")
	WebElement password;
	
	@FindBy(id="edit-submit")
	WebElement LoginBtn;
	
	
	@FindBy(xpath="//h2[contains(text(),'Error message')]")
	WebElement errormessage;
	
	@FindBy(xpath="//body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]")
	WebElement elementerror;
	
	@FindBy(css="a.close-reveal-modal")
	WebElement alertmessage;
	
	@FindBy(xpath="//div[@class='messages error']")
	WebElement alertException;
	//Initialization page factory
	public LoginPatron() {
		PageFactory.initElements(driver, this);	
	}
	
	//Actions in Login Page
	public String validatepatronLoginPageTitle() {
		return driver.getTitle();
	}
public boolean validateErrorMessage() {
	return errormessage.isDisplayed();
}
	

public boolean validatesingleError() {
	return elementerror.isDisplayed();
}

public DashboardPage login(String un, String pwd) {
try {
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginBtn.click();
	alertmessage.click();
}
	catch(Exception e){
		String alerexptmsg = alertException.getText();
		Log.error(alerexptmsg);
	}
	Log.info("Alert message is closed");
	return new DashboardPage();
}


	
}
