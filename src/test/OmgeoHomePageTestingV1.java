package test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.PageHome;
import pages.pageAbout;
import pages.pageLeadership;

public class OmgeoHomePageTestingV1 {
	WebDriver driver;
	PageHome objPage;
	pageAbout objPageAbout;
	pageLeadership objPageLeader;
	
	
	@BeforeTest
	@Parameters({"browser", "URLHomePage"})
	public void setup( String browsername, String HomePageURL){
		
		if(browsername.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")) {
			String chromePath = System.getProperty("user.dir") + "\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromePath );
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open HomePage URL and Maximize the window
		driver.get(HomePageURL);
		driver.manage().window().maximize();
	}

	/**
	 * This test go to http://www.omgeo.com/
	 * Verify the home page using URL
	 */
	@Test(priority=0)
	@Parameters("URLHomePage")
	public void test_Home_Page_Appear_Correct(String HomeURLName){
		//Verify Home page title
		Assert.assertEquals(driver.getCurrentUrl(), HomeURLName);
	}
	
	@Test(priority = 1)
	@Parameters("URLAbout")
	public void test_About_Page_Correct(String AboutURLName){
		objPage = new PageHome(driver);
		//Click on About
		objPage.clickAbout();	
		//Verify About page URL
		Assert.assertEquals(driver.getCurrentUrl(), AboutURLName);
	}
	
	@Test(priority = 2)
	@Parameters("URLAlert")
	public void AlertPage(String AlertURLName){
		//Create AboutPage object
		objPageAbout = new pageAbout(driver);
		//Click on ALERT and Verify if Alert Page loads correctly
		objPageAbout.click_Alert(driver);
		Assert.assertEquals(driver.getCurrentUrl(), AlertURLName);
		objPageAbout.click_LeaderShip(driver);
	}
	
	@Test (priority = 3)
	@Parameters("URLLeader")
	public void leaderShipPage(String LeaderURLName){
		//Create Leadership Page Object
		objPageLeader = new pageLeadership(driver);
		//Check Leadership Page loads
		Assert.assertEquals(driver.getCurrentUrl(), LeaderURLName);
		//Click on a Leader
		String LeaderName = objPageLeader.GetLeaderDetails();
		//Check for Leaders Content in the modal Dialog
		Assert.assertTrue(driver.getPageSource().toLowerCase().contains(LeaderName.toLowerCase()));
		//Close Browser
		driver.quit();
	}
}
