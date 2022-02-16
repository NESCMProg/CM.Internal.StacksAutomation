package teseCases;
import utility.Log;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPatron;
import pageObjects.calloutViewPage;
import resources.base;
import utility.TestUtil;

public class LoginPageTest extends base {
//public static Logger log =LogManager.getLogger(LoginPageTest.class.getName());
LoginPatron loginpatron	;
DashboardPage dashboardpage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		System.out.println("driver is initialized for Login Patron Page");
		Log.info("driver is initialized for Login Patron Page");
		 loginpatron = new LoginPatron();
		 dashboardpage = new DashboardPage();
		 
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
	
	@Test(priority=1)
	public void validatepatronLoginPageTitleTest() {
		String title = loginpatron.validatepatronLoginPageTitle();
		Assert.assertEquals(title, "EBSCOhost");
		Log.info("Title for Login Patron page is verified : "+title);
	}
	
	@Test(dataProvider="getLoginData", priority=2)
	public void loginTest(String username, String password)
	{
		System.out.println();
		dashboardpage = loginpatron.login(username,password);
		
		Log.info("username from Excel: "+username);
		Log.info("password from Excel: "+password);
		Log.info("Condition for Test Scenario Id: TS_LP_01 is PASS");
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
