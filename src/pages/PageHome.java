package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageHome{
	By AboutLink = By.linkText("About");
	WebDriver driver ;
	
	
	public PageHome(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This POM method will be exposed in test case to
	 * Get the title of Login Page
	 * @return CurrentURL
	 */
	public String getTitleHome(){
		return driver.getCurrentUrl();
	}
	
	/**
	 * This POM method will be exposed in test case to
	 * Click and Navigate to About Page
	 * @return
	 */
	public WebDriver clickAbout(){
		driver.findElement(AboutLink).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
