package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class MultipleBrowserWindows {
	public WebDriver driver;
	public WebDriver driver1;
  @Test
  public void Driver() {
	  driver = new ChromeDriver();
	  driver.get("https://www.google.co.in");
	  
	  System.out.println(driver.getTitle());
	  driver.close();
	  
  }
  
  @Test
  public void Driver1() {
	  
	  driver1=new ChromeDriver();
	  driver1.get("https://www.facebook.com");
	  System.out.println(driver1.getTitle());
	  driver1.close();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
	  //driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	 
	  
  }
  

}
