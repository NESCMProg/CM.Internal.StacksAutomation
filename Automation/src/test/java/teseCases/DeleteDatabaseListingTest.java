package teseCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CustomBlockViewPage;
import pageObjects.DashboardPage;
import pageObjects.DataBaseListingsViewPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.Log;
import utility.TestUtil;
import utility.readCredentials;

public class DeleteDatabaseListingTest extends base {
	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	CustomBlockViewPage cbvp;
	DataBaseListingsViewPage dblvp;
	DeleteDatabaseListingTest deletedatabaselist;
	readCredentials rc = new readCredentials();
	
	public DeleteDatabaseListingTest() {
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
		 dblvp = new DataBaseListingsViewPage();
		 dashboardpage.clickOnDatabaseListingLink();
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
	public Object[][] getdeleteDBLData()
	{
		Object data[][]=null;
		try {
			data = TestUtil.getTestData("deletedbl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getdeleteDBLData")
	public void deleteTest(String DBLTITLE_D, String Main_URL1_D, String subTitle_1_D, String subTitle1_URL_D, String Delete_DBL) {
		Log.info("Test Case ID: TS_DBL_02");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Module Name: Database Listing");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: "+currentDateTime);
		Log.info("Test Description: Log in to EBSCO Enterprise Research application to create a Database Listing first. Then identify the created ones in Database List"
				+" table and delete the following Database List");
		
		try {
			dblvp.deleteDBLBtn(DBLTITLE_D, Main_URL1_D, subTitle_1_D, subTitle1_URL_D, Delete_DBL);
			Log.info(DBLTITLE_D+ " Database List is created first");
			Log.info(Delete_DBL +" is deleted successfully");
		}
		catch(Exception e1) {
			
		}
		
		Log.info("Test Result: Pass");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

