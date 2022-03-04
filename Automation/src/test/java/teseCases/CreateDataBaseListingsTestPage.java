package teseCases;

import utility.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import utility.readCredentials;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.DataBaseListingsViewPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.TestUtil;

public class CreateDataBaseListingsTestPage extends base {
	LoginPatron loginpatron;
	DashboardPage dashboardpage;
	DataBaseListingsViewPage dblvp;
	CreateDataBaseListingsTestPage createdatabaselistings;
	readCredentials rc = new readCredentials();

	public CreateDataBaseListingsTestPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		Log.info("Test Functionality for creating Database Listings");
		loginpatron = new LoginPatron();
		String username1 = rc.ReadCellData(1, 0);
		String password1 = rc.ReadCellData(1, 1);
		dashboardpage = loginpatron.login(username1, password1);
		// Log.info("username from excel: "+ username1);
		// Log.info("password from excel: "+ password1);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		dblvp = new DataBaseListingsViewPage();
		dblvp = dashboardpage.clickOnDatabaseListingLink();
		

	}

	@DataProvider
	public Object[][] getLoginData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	@DataProvider
	public Object[][] getDBListingsData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("dblisting");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getDBListingsData")
	public void newcalloutcreatetest(String DBLTITLE, String Main_URL1, String subTitle_1, String subTitle1_URL) throws InterruptedException {
		Log.info("Module Name: Database Listings");
		Log.info("Test Case ID: TS_DBL_01");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info("Test Description: Navigate to Database Listings Page in Database Listings Tile. Click on [Add New] button to create a new Database List."
				+ " Page navigates to 'Create Database Listing' page. Fill the details and click on [Save] button. "
				+ "New Database List is created with respective Title name and can be viewed in Database Listings table grid.");
		dblvp.clickDBLNewBtnandSaveBtn(DBLTITLE, Main_URL1, subTitle_1, subTitle1_URL);
		Log.info("Condition in Test Scenario Id: TS_DBL_01 is Executed Successfully");
		Log.info("Test Result: Pass");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
			Log.info("Browser is closed");
		

	}

}
