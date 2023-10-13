package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class JavascriptScrolling {
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://www.spicejet.com/");
	  Thread.sleep(5000);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,600)", "");
	  Thread.sleep(5000);
	  js.executeScript("window.scrollBy(0,-600)", "");
	  Thread.sleep(5000);
	  js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	  Thread.sleep(5000);
	  WebElement explore_btn = driver.findElement(By.xpath("//div[contains(text(),'Explore More')]/parent::div"));
	  js.executeScript("arguments[0].scrollIntoView();", explore_btn);
	  js.executeScript("arguments[0].click();", explore_btn);
	  
	  /*try {
		  WebElement explore_btn = driver.findElement(By.xpath("//div[contains(text(),'Explore More')]/parent::div"));
		  js.executeScript("arguments[0].click();", explore_btn);
		  } catch (Exception e) {
		    
			  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(text(),'Explore More')]/parent::div")));
		  }*/
	  
	  
	 // Thread.sleep(5000);
	  //explore_btn.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  
	  driver = new ChromeDriver(options);
	  
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
