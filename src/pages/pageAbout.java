package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageAbout {
	
	WebDriver driver ;
	WebElement element;
	
	By ProdDropBox = By.className("chzn-single");
	By AlertSelect = By.partialLinkText("ALERT");
	By LeadershipLink = By.linkText("Leadership Team");
		
	public pageAbout(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This POM method will be exposed in test case to
	 * Get the title of About Page
	 * @return CurrentURL
	 */
//	public String getTitleAbout(){
//		Assert.assertEquals(driver.getCurrentUrl(), Util.AboutPageURL);
//		return driver.getCurrentUrl();
//	 
//	}
	
	/**
	 * This POM method will be exposed in test case to
	 * Click and Navigate to Alert Page
	 * @driver
	 * @return
	 */
	public void click_Alert(WebDriver driver){
		//Select Drop Box
		driver.findElement(ProdDropBox).click();
		//Click on ALERT from Drop Box
		driver.findElement(AlertSelect).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void click_LeaderShip(WebDriver driver){
		driver.findElement(LeadershipLink).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
