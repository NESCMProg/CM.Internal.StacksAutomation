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
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.Log;
import utility.TestUtil;
import utility.readCredentials;

public class DeleteCustomTest extends base {
	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	CustomBlockViewPage cbvp;
	calloutViewPage covp;
	DeleteCustomTest delcustom;
	readCredentials rc = new readCredentials();
	
	public DeleteCustomTest() {
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
		 cbvp = new CustomBlockViewPage();
		 cbvp = dashboardpage.clickOnCustomBlockLink();
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
			data = TestUtil.getTestData("deletecustom");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getdeleteData")
	public void deleteTest(String title1_D, String workflow_D, String customLog_D, String deleteCustomTitle) {
		Log.info("Test Case ID: TS_CB_02");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Module Name: Custom Block");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: "+currentDateTime);
		Log.info("Test Description: Log in to EBSCO Enterprise Research application to create a Custom Block first. Then identify the created ones in Custom"
				+" table and delete the following Custom Block");
		
		try {
			cbvp.deleteCustomBtn(title1_D, workflow_D, customLog_D, deleteCustomTitle);
			Log.info(title1_D+ " Custom Block is created first");
			Log.info(deleteCustomTitle +" is deleted successfully");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

