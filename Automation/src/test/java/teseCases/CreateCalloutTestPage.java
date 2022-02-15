package teseCases;
import utility.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import utility.readCredentials;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.TestUtil;

public  class CreateCalloutTestPage extends base {

	LoginPatron loginpatron	;
	DashboardPage dashboardpage;
	calloutViewPage covp;
	CreateCalloutTestPage createcallouts;
	readCredentials rc = new readCredentials();	
	
	public CreateCalloutTestPage() {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		Log.info("driver is initialized for Callouts Page");
		 loginpatron = new LoginPatron();
		//dashboardpage = loginpatron.login(prop.getProperty("username"),prop.getProperty("password"));
		 String username1 = rc.ReadCellData(1,0);
		 System.out.println("vOutput");
		String password1 = rc.ReadCellData(1,1);
		dashboardpage =  loginpatron.login(username1,password1);
	 Log.info("username from excel: "+ username1);
	Log.info("password from excel: "+ password1);
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 covp = dashboardpage.clickOnCalloutsLink();
		 covp = new calloutViewPage();
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		
		Object data[][]=null;
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
	public Object[][] getCalloutData()
	{
		
		Object data[][]=null;
		try {
			data = TestUtil.getTestData("callouts");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	/*@Test(dataProvider="getLoginData",priority=1)
	public void loginTest(String username, String password)
	{
		
		dashboardpage = loginpatron.login(username,password);
		covp = dashboardpage.clickOnCalloutsLink();
	}*/
	@Test(dataProvider="getCalloutData")
	public void newcalloutcreatetest(String title1, String subtitle1, String description) throws InterruptedException {
		
		covp.clickonNewBtnandSaveBtn(title1, subtitle1, description);
		Log.info("title1 from Excel:"+title1);
		Log.info("subtitle1 from Excel:"+subtitle1);
		Log.info("description from Excel:"+description);
		Log.error("title1 from Excel is not driven");
		Log.error("subtitle1 from Excel is not driven");
		Log.error("description from Excel is not driven");
		Log.info("Test Scenario ID TS_CO_01 is Executed Successfully");
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		Log.info("Browser is closed");
		
	}
	
	
}
