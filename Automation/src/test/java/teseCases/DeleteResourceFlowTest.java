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
import pageObjects.resourceViewPage;
import resources.base;
import utility.Log;
import utility.TestUtil;
import utility.readCredentials;

public class DeleteResourceFlowTest extends base {
	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	resourceViewPage rfvp;
	DeleteResourceFlowTest delcallout;
	readCredentials rc = new readCredentials();
	
	public DeleteResourceFlowTest() {
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
		 rfvp = new resourceViewPage();
		 rfvp = dashboardpage.clickOnResourceFlowLink();
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
			data = TestUtil.getTestData("deleteresourceflow");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getdeleteData")
	public void deleteTest(String mainResourceTitle, String ISBN_1, String upc_1, String rtitle11, String author1, String wfcmts, String rlm, String deleteResourceTitle) {
		Log.info("Test Case ID: TS_RF_02");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Module Name: Resource Flows");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: "+currentDateTime);
		Log.info("Test Description: Log in to Ebsco Enterprise Research application to create a Resource Flow first. Then identify the created ones in Resource"
				+" Flow table and delete the following Resource Flow");
		
		try {
			rfvp.deleteResourceFlowBtn(mainResourceTitle, ISBN_1, upc_1, rtitle11, author1, wfcmts, rlm, deleteResourceTitle);
			Log.info(mainResourceTitle+ " Resource Flow is created first");
			Log.info(deleteResourceTitle +" is deleted successfully");
		}
		catch(Exception e1) {
			
		}
		
		Log.info("Test Result: Pass");
		System.out.println("For Deletetion, deleteResourceFlowBtn method is implemented");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

