package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageLeadership {
	WebDriver driver ;
	WebElement element;
	String GetLeader = "/html/body/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/span/a";
	String LeaderName = "";
	By LearMoreLink = By.linkText("Learn More +");
	By LeaderDetailsLink = By.xpath(GetLeader);

	
	public pageLeadership(WebDriver driver){
		
		this.driver = driver;
	}
	
	/**
	 * This POM method will be exposed in test case to
	 * Get the title of Leadership Page
	 * @return CurrentURL
	 */
//	public void CheckLeadershipTitle(){
//		Assert.assertEquals(driver.getCurrentUrl(), Util.LeaderPageURL);
//		
//	}
	
	public String GetLeaderDetails(){
		//Scroll page down to look for details
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(LearMoreLink);
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		//Find Link to Leaders
		element = driver.findElement(LeaderDetailsLink);
		element.click();
		
		//Get Leaders Name from the Link Clicked
		LeaderName = element.getAttribute("href");
		LeaderName = LeaderName.substring(LeaderName.lastIndexOf("/")+1, LeaderName.lastIndexOf("'") );

		String[] LeaderNames = new String[2];
		LeaderNames = LeaderName.split("_");
		LeaderName = LeaderNames[0]+" " + LeaderNames[1];
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Check for Specific details for the Leader Selected.
		driver.switchTo().frame(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getPageSource() + "PAGE SOURCE");
		return LeaderName;
	}

}
