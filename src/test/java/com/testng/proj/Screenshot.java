package com.testng.proj;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
public class Screenshot {
	public WebDriver driver;
  @Test
  public void Screenshot_Image() {	
driver.get("https://www.icicibank.com/");
	  
	  WebElement Personal = driver.findElement(By.xpath("//a[contains(@id, 'loginsection')]"));
	  Actions Personalact = new Actions(driver);
	  Personalact.moveToElement(Personal).click().build().perform();
	  
	  List <WebElement> Bankinglist = driver.findElements(By.xpath("//div[contains(@class, 'personal-list')]/ul/li"));
	  System.out.println(Bankinglist.size());	
	  
	  
	  /*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	  
	  try {
	  FileUtils.copyFile(src, new File("D://screenshot.jpeg"));
	  }
	  catch(Exception e1) {
		  System.out.println(e1);
	  }*/
  }
  @BeforeMethod
  public void beforeMethod() {	 
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE == result.getStatus()) //ITest result is a interface. getStatus() method is use in case if test fails
	  {
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("D://screenshot1.jpeg"));
		  System.out.println("Successfully captured screenshot");		  
	  }	  
	  driver.close();
  }
}
 