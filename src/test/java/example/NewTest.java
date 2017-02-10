package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {
	private WebDriver driver;

	@Test
	public void testEasy() {
		driver.get("http://www.guru99.com/selenium-tutorial.html");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Free Selenium Tutorials"));
	}

	@Test
	public void htmlsampleTest0() {
		assertTrue(1 < 2);
	}

	@Test
	public void htmlsampleTest1() {
		assertTrue(1 > 2);
	}

	@Test
	public void htmlsampleTest2() {
		assertTrue(1 < 2);
	}

	@Test
	public void htmlsampleTest4() {
		assertTrue(1 > 2);
	}

	@BeforeTest
	public void beforeTest() {
		// System.setProperty("webdriver.gecko.driver","c:\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
		 

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("Page title is: " + os);
		if (os.contains("win")) {
			System.setProperty("webdriver.gecko.driver", "c:\\webdrivers\\chromedriver.exe");
		} else if (os.contains("nux") || os.contains("nix")) {
			System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}