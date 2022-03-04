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

import pageObjects.CustomBlockViewPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.NewsArticleViewPage;
import pageObjects.calloutViewPage;
import resources.base;
import utility.TestUtil;

public class CreateCustomBlockTestPage extends base {
	LoginPatron loginpatron;
	DashboardPage dashboardpage;
	CreateCustomBlockTestPage createcustom;
	CustomBlockViewPage cbvp;
	CreateCustomBlockTestPage createnewsarticles;
	readCredentials rc = new readCredentials();

	public CreateCustomBlockTestPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		Log.info("Test functionality for creating a Custom Block");
		loginpatron = new LoginPatron();
		String username1 = rc.ReadCellData(1, 0);
		String password1 = rc.ReadCellData(1, 1);
		dashboardpage = loginpatron.login(username1, password1);
		// Log.info("username from excel: "+ username1);
		// Log.info("password from excel: "+ password1);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		cbvp = new CustomBlockViewPage();
		cbvp = dashboardpage.clickOnCustomBlockLink();

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
	public Object[][] getCustomBlockData() {

		Object data[][] = null;
		try {
			data = TestUtil.getTestData("custom");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getCustomBlockData")
	public void newCustomCreateTest(String customTitle, String customWorkFlow, String customLog ) throws InterruptedException  {
		Log.info("Module Name: Custom Block");
		Log.info("Test Case ID: TS_CB_01");
		Log.info("Test Designed By: Charan");
		Log.info("Test Priority: High");
		Log.info("Test Executed By: "+machineName );
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info("Test Description: Navigate to Custom Block Page in Custom Block Tile. Click on [Add New] button to create a new Custom."
				+ " Page navigates to 'Create Custom Block' page. Fill the details and click on [Save] button. "
				+ "New 'Custom Block' is created with respective Title name and can be viewed in Custom Block table grid.");
		cbvp.clickCustomNewBtnandSaveBtn(customTitle, customWorkFlow, customLog);
		Log.info("Condition in Test Scenario Id: TS_CB_01 is Executed Successfully");
		Log.info("Test Result: Pass");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
			Log.info("Browser is closed");
		

	}

}
