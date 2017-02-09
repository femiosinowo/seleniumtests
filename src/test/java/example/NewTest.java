package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
	    
		@Test				
		public void testEasy() {	
			driver.get("http://www.guru99.com/selenium-tutorial.html");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Free Selenium Tutorials")); 		
		}	
		@BeforeTest
		public void beforeTest() {	
			//System.setProperty("webdriver.gecko.driver","G:\\Selenium\\Firefox driver\\geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
		    driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}