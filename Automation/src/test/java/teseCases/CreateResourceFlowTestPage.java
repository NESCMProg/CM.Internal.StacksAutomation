package teseCases;

import utility.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import pageObjects.resourceViewPage;
import resources.base;
import utility.TestUtil;
import utility.readCredentials;

public class CreateResourceFlowTestPage extends base {
	LoginPatron loginpatron;
	DashboardPage dashboardpage;
	resourceViewPage rfvp;
	readCredentials rc = new readCredentials();
	CreateResourceFlowTestPage createResourceFlows;

	public CreateResourceFlowTestPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		Log.info("Test functionality for creating a Resource Flow");
		loginpatron = new LoginPatron();
		String username1 = rc.ReadCellData(1, 0);
		String password1 = rc.ReadCellData(1, 1);
		dashboardpage = loginpatron.login(username1, password1);
		// Log.info("username from excel: "+ username1);
		// Log.info("password from excel: "+ password1);
		rfvp = new resourceViewPage();
		rfvp = dashboardpage.clickOnResourceFlowLink();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@DataProvider
	public Object[][] getLoginData() {

		// common utility - which is applicable for excel files
		Object data[][] = null;
		try {
			data = TestUtil.getTestData("login");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@DataProvider
	public Object[][] getResourceFlowsData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("resourceflows");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getResourceFlowsData")
	public void newResourceFlowTest(String title1, String ISBN1, String UPC, String subTitle, String author,
			String resflow, String rlm) throws InterruptedException {
		Log.info("Module Name: Resource Flows");
		Log.info("Test Case ID: TS_RF_01");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info(
				"Test Description: Navigate to Resource Flow Page in Resource Flow Tile. Click on [Add New] button to create a new "
						+ "Resource Flow. Page navigates to Create Resource Flow page. Fill the details and click on [Save] button. "
						+ "New Resource Flow is created with respective Title name and and be viewed in Resource Flow table ");
		rfvp.clickresourceNewandSaveBtn(title1, ISBN1, UPC, subTitle, author, resflow, rlm);
		Log.info("Test Scenario Id: TS_RF_01 is Executed Successfully");
		Log.info("Test Result: Pass");
		System.out.println(resflow);
		System.out.println(title1);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
			Log.info("Browser is closed");
		
	}

}
