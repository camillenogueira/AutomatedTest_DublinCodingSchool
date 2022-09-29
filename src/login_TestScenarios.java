import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Testing login functionality of Guru99")
public class login_TestScenarios {

	
	public static WebDriver driver = null;
	
	@BeforeAll
	public static void beforeall() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver", "/Users/camillenogueira/webdriver/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().timeouts().wait(3000); //.implicitlyWait(6, null);
	}
	
	@AfterAll
	public static void afterall() {
		driver.close();
	}
	
	@Test
	@Order(1)
	@DisplayName("Login Happy Path")
	public void login_happyPath() throws Exception {
	
		MyScreenRecorder screenrecording = new MyScreenRecorder("navigationTest", new File("./recording/"));
		screenrecording.start();
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
	
		//Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mngr440377"); //username
		driver.findElement(By.name("password")).sendKeys("EtEsene"); //password
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click(); //click on the button to login
		
		//Thread.sleep(1000);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", driver.findElement(By.id("dismiss-button")));
		
		/*String actualResults = driver.getCurrentUrl();
		String expectedResults = "https://demo.guru99.com/v4/manager/Managerhomepage.php";
		
		assertEquals(actualResults,expectedResults);
		assertTrue(actualResults.contains(expectedResults));
		//assertThat(actualResults, is(expectedResults));
		*/
		screenrecording.stop();
		
		//driver.quit();
	}
	
	
	@Test
	@Order(2)
	public void login_unhappyPath_wrongUsername() {
		
		
		
		/*
		 * 
		 * here is the test
		 */
		
		
	}
	
	@Test
	@Order(3)
	public void login_unhappyPath_blankField() {
		
		
		/*
		 * 
		 * here is the test
		 */
		
		
	}
	
	
}
