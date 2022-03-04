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
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import pageObjects.directoryListingsViewPage;
import resources.base;
import utility.TestUtil;

public class createDirectoryListingsTestPage extends base {
	LoginPatron loginpatron;
	DashboardPage dashboardpage;
	directoryListingsViewPage dlvp;
	createDirectoryListingsTestPage createdirectorylist;
	readCredentials rc = new readCredentials();

	public createDirectoryListingsTestPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		Log.info("Test functionality for creating a Directory Listing");
		loginpatron = new LoginPatron();
		String username1 = rc.ReadCellData(1, 0);
		String password1 = rc.ReadCellData(1, 1);
		dashboardpage = loginpatron.login(username1, password1);
		// Log.info("username from excel: "+ username1);
		// Log.info("password from excel: "+ password1);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		dlvp = new directoryListingsViewPage();
		dlvp = dashboardpage.clickOnDirectoryListingsLink();

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
	public Object[][] getDirectoryListData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("directory");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getDirectoryListData")
	public void newdirectorycreatetest(String dirName, String secondtName, String job, String loc, String twtTitle, String twtURL) throws InterruptedException {
		Log.info("Module Name: Directory Listings");
		Log.info("Test Case ID: TS_DL_01");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info("Test Description: Navigate to 'Directory Listings' Page in Directory Listings Tile. Click on [Add New] button to create a new Directory."
				+ " Page navigates to 'Create Directory Listing' page. Fill the details and click on [Save] button. "
				+ "New Directory is created with respective Title name and can be viewed in Directory Listings table grid.");
		dlvp.clickDirectoryNewandSaveBtn(dirName, secondtName, job, loc, twtTitle, twtURL);
		Log.info("Condition in Test Scenario Id: TS_DL_01 is Executed Successfully");
		Log.info("Test Result: Pass");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
			Log.info("Browser is closed");
		

	}

}
