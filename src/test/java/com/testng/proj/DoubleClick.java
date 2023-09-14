package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DoubleClick {
	public WebDriver driver;
  @Test
  public void doubleclickbtn() throws InterruptedException {
	  
	  driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	  WebElement dbDoublebtn = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
	  System.out.println(dbDoublebtn.isDisplayed());
	 
	  Thread.sleep(5000);
	  Actions act = new Actions(driver);
	  act.doubleClick(dbDoublebtn).build().perform();
	  
	  //act.build().perform();
	  Thread.sleep(5000);
	  
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  //alt.dismiss();
	  
  }
  
  @Test
  public void RightClick() throws InterruptedException {
	  
	  driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	  WebElement rightclk=driver.findElement(By.xpath("//span[contains(@class,'context-menu-one btn btn-neutral')]"));
	  System.out.println(rightclk.isDisplayed());
	  
	  Thread.sleep(5000);
	  Actions act1=new Actions(driver);
	  act1.contextClick(rightclk).build().perform();
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("BeforeMethod");
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("AfterMethod");
	  driver.close();
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

}
