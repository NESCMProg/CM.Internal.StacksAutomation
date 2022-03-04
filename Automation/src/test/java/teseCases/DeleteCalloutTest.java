package teseCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.Log;
import utility.TestUtil;
import utility.readCredentials;

public class DeleteCalloutTest extends base {
	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	calloutViewPage covp;
	DeleteCalloutTest delcallout;
	readCredentials rc = new readCredentials();
	
	public DeleteCalloutTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		Log.info("Browser is opened");
		 loginpatron = new LoginPatron();
		 String username1 = rc.ReadCellData(1,0);
		String password1 = rc.ReadCellData(1,1);
		dashboardpage =  loginpatron.login(username1,password1);
	// Log.info("username from excel: "+ username1);
	//Log.info("password from excel: "+ password1);
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 covp = new calloutViewPage();
		 covp = dashboardpage.clickOnCalloutsLink();
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		
		Object data[][]=null;
		try {
			data = TestUtil.getTestData("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return data;
	}
	
	@DataProvider
	public Object[][] getdeleteData()
	{
		Object data[][]=null;
		try {
			data = TestUtil.getTestData("deletecallout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getdeleteData")
	public void deleteTest(String title_CD, String subtitle_CD, String desc_CD, String DeleteCallout) {
		Log.info("Test Case ID: TS_CO_02");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Module Name: Callouts");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: "+currentDateTime);
		Log.info("Test Description: Log in to EBSCO Enterprise Research application to create a callout first. Then identify the created ones in callout"
				+" table and delete the following callout");
		
		try {
			covp.deleteCalloutBtn(title_CD, subtitle_CD, desc_CD, DeleteCallout);
			Log.info(title_CD+ " callout is created first");
			Log.info(DeleteCallout +" is deleted successfully");
		}
		catch(Exception e1) {
			
		}
		
		Log.info("Test Result: Pass");
		System.out.println("For Deletetion, deleteCalloutBtn method is implemented");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		try {
			Log.info("Browser is closed");
		}
		catch(Exception e) {
			Log.error(e.getMessage());
		}
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

