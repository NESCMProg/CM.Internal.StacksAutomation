package teseCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.Log;
import utility.readCredentials;

public class DashboardPageTest extends base{
	LoginPatron loginpatron	;
	readCredentials rc = new readCredentials();	
	DashboardPage dashboardpage;
	//calloutViewPage covp;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		
		 loginpatron = new LoginPatron();
		 String username1 = rc.ReadCellData(1,0);
		 String password1 = rc.ReadCellData(1,1);
		 dashboardpage =  loginpatron.login(username1,password1);
		 Log.info("username from excel: "+ username1);
		 Log.info("password from excel: "+ password1);
		//dashboardpage = loginpatron.login(prop.getProperty("username"), prop.getProperty("password"));
		//covp = new calloutViewPage();
	//covp =  dashboardpage.clickOnCalloutsLink();
		
		
	}
	
	@Test(priority=1)
	public void verifyDashboardTitleTest() {
		String title2 = dashboardpage.verifyDashboardPageTitle();
		Assert.assertEquals(title2, "Dashboard | Research","Dashboard Title Not Matched");
		Log.info("Verified the Dashboard Title name which is : "+title2);
		System.out.println(title2);
	}
	
	/*@Test(priority=2)
	public void calloutsTiletest() {
		System.out.println("dashboard page success");
		covp = dashboardpage.clickOnCalloutsLink();
		
	}*/
	
	/*@AfterMethod
	public void teardown() {
		driver.quit();
	}*/
	
	
}
