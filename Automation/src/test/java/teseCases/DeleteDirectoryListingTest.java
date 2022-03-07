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
import pageObjects.NewsArticleViewPage;
import pageObjects.calloutViewPage;
import pageObjects.directoryListingsViewPage;
import resources.base;
import utility.Log;
import utility.TestUtil;
import utility.readCredentials;

public class DeleteDirectoryListingTest extends base {
	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	directoryListingsViewPage dlvp;
	DeleteDirectoryListingTest deldirectorylist;
	readCredentials rc = new readCredentials();
	
	public DeleteDirectoryListingTest() {
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
		 dlvp = new directoryListingsViewPage();
		 dlvp = dashboardpage.clickOnDirectoryListingsLink();
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
	public Object[][] getdeletedirectorylistData()
	{
		Object data[][]=null;
		try {
			data = TestUtil.getTestData("deletedirectory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getdeletedirectorylistData")
	public void deleteTest(String D_directoryName, String D_lastName, String D_jobTitle, String D_Location, String D_twitter, String D_twitterURL, String deletedDirectory) {
		Log.info("Test Case ID: TS_DL_02");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Module Name: Directory Listings");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: "+currentDateTime);
		Log.info("Test Description: Log in to EBSCO Enterprise Research application to create a Directory List first. Then identify the created ones in Directory"
				+" Listings table and delete the following Directory");
		
		try {
			dlvp.deleteDirectoryListBtn(D_directoryName, D_lastName, D_jobTitle, D_Location, D_twitter, D_twitterURL, deletedDirectory);
			Log.info(D_directoryName+" "+D_lastName+ " is created first");
			Log.info(D_directoryName+" "+D_lastName+ " is deleted successfully");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

