package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {
	private WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@Test
	public void testEasy() {
		test = extent.startTest("testEasy");
		driver.get("http://www.guru99.com/selenium-tutorial.html");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Free Selenium Tutorials"));
		test.log(LogStatus.PASS, "whaever");
	}

	@Test
	public void htmlsampleTest0() {
		test = extent.startTest("htmlsampleTest0");
		assertTrue(1 < 2);
		test.log(LogStatus.PASS, "whaever");
	}

	@Test
	public void htmlsampleTest1() {
		test = extent.startTest("htmlsampleTest1");
		assertTrue(1 > 2);
		test.log(LogStatus.FAIL, "whaever");
	}

	@Test
	public void htmlsampleTest2() {
		test = extent.startTest("htmlsampleTest2");
		assertTrue(1 < 2);
		test.log(LogStatus.PASS, "whaever");
	}

	@Test
	public void htmlsampleTest4() {
		test = extent.startTest("htmlsampleTest4");
		assertTrue(1 > 2);
		test.log(LogStatus.FAIL, "whaever");
	}

	@BeforeTest
	public void beforeTest() {
		// System.setProperty("webdriver.gecko.driver","c:\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/MyOwnReport.html", true);
		extent.addSystemInfo("Host Name", "Krishna").addSystemInfo("Environment", "QA").addSystemInfo("User Name",
				"Krishna Sakinala");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

		//System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");

		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.contains("win")) {
			System.setProperty("webdriver.gecko.driver", "c:\\webdrivers\\chromedriver.exe");
		} else if (os.contains("nux") || os.contains("nix")) {
			System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());

		}
		extent.endTest(test);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		extent.flush();
		extent.close();
	}
}