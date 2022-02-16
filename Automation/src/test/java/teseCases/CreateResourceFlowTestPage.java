package teseCases;
import utility.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	LoginPatron loginpatron	;
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
		Log.info("driver is initialized for Resource Flows Page");
		 loginpatron = new LoginPatron();
		// dashboardpage = loginpatron.login(prop.getProperty("username"),prop.getProperty("password"));
		 String username1 = rc.ReadCellData(1,0);
		 String password1 = rc.ReadCellData(1,1);
		 dashboardpage =  loginpatron.login(username1,password1);
		 Log.info("username from excel: "+ username1);
		 Log.info("password from excel: "+ password1);
		 rfvp = new resourceViewPage();
		 rfvp = dashboardpage.clickOnResourceFlowLink();
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 
		
	}
	@DataProvider
	public Object[][] getLoginData()
	{
		
		//common utility - which is applicable for excel files
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
	public Object[][] getResourceFlowsData()
	{
		
		Object data[][]=null;
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
	
	@Test(dataProvider="getResourceFlowsData")
	public void newResourceFlowTest(String title1, String ISBN1, String UPC, String subTitle, String author, String resflow, String rlm) throws InterruptedException {
		rfvp.clickresourceNewandSaveBtn(title1, ISBN1, UPC, subTitle, author, resflow, rlm);
		Log.info("title1 from Excel: "+title1);
		Log.info("ISBN1 value from Excel: "+ISBN1);
		Log.info("UPC value from Excel: "+UPC);
		Log.info("subTitle value from Excel: "+subTitle);
		Log.info("author value from Excel: "+resflow);
		Log.info("ResourceFlow value from Excel: "+rlm);
		Log.info("Resource Flow Stage PASS");
		Log.info("Test Scenario Id: TS_RF_01 is Executed Successfully");
		System.out.println(resflow);
		System.out.println(title1);
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
