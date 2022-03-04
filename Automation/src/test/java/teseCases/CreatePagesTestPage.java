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
import pageObjects.pagesViewPage;
import pageObjects.resourceViewPage;
import resources.base;
import utility.TestUtil;
import utility.readCredentials;

public class CreatePagesTestPage extends base {
	LoginPatron loginpatron;
	DashboardPage dashboardpage;
	pagesViewPage pvp;
	readCredentials rc = new readCredentials();
	CreatePagesTestPage createResourceFlows;

	public CreatePagesTestPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		Log.info("Test functionality for creating a Page");
		loginpatron = new LoginPatron();
		String username1 = rc.ReadCellData(1, 0);
		String password1 = rc.ReadCellData(1, 1);
		dashboardpage = loginpatron.login(username1, password1);
		pvp = new pagesViewPage();
		pvp = dashboardpage.clickOnPagesLink();
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
	public Object[][] getpagesData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("pages");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getpagesData")
	public void newPageCreateTest(String pgTitle, String pageWorkFlow) throws InterruptedException {
		Log.info("Module Name: Pages");
		Log.info("Test Case ID: TS_PG_01");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info(
				"Test Description: To create Page, click on Pages Tile in dashboard. Click on [Add New] button to navigate to"
				+ " 'Create Page'. Fill details and click on [SAVE] button. New Page is created");
		pvp.clickPagesNewandSaveBtn(pgTitle, pageWorkFlow);
		Log.info("Test Scenario Id: TS_PG_01 is Executed Successfully");
		Log.info("Test Result: Pass");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
			Log.info("Browser is closed");
		
	}

}
