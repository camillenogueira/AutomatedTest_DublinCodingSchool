import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class newCustomer_TestScenarios {

	public static WebDriver driver = null;
	
	@BeforeAll
	public static void beforeall() {
		System.setProperty("webdriver.chrome.driver", "/Users/camillenogueira/webdriver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void afterall() {
		driver.close();
	}
	
	@Test
	public void errorMensageBlankField() {
		
	}
	
	@Test
	public void addNewCustomer_happyPath() {
		
	}
		
	@Test
	public void checkAllLabels() throws InterruptedException {
		
		//Login
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click(); //close the iframe to accept the data privacy popup
		Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mngr434560"); //username
		driver.findElement(By.name("password")).sendKeys("uredepA"); //password
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click(); //click on the button to login
		Thread.sleep(1000);
		//End of Login
		
		//driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		//Comment the Click on the new customer to not open the iframe
		driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(1000);
		
		//Close the iframe
		//driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0").findElement(By.id("dismiss-button")).click(); //close the iframe afte click on the link "New Customer

		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));

		driver.switchTo().frame(frame1);

		WebElement frame2 = driver.findElement(By.id("ad_iframe"));

		driver.switchTo().frame(frame2);

		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();

		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		
		
		//driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		//driver.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
		////a[contains(text(),'New Customer
		
		//Check if the Subtitle "Add New Customer" is correct
		String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p")).getText();
		String expectedResults = "Add New Customer";
		assertEquals(expectedResults, actualResults);
		
		//Check if the Label "Customer Name" is correct
		actualResults = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1]")).getText();
		expectedResults = "Customer Name";
		assertTrue(actualResults.contains(expectedResults));
		
		//Check if the Label "Gender" is correct
		assertEquals("Gender", driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[1]")).getText());
		
	}
}
