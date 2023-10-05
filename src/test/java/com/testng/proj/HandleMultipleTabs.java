package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class HandleMultipleTabs {
	public WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://demo.guru99.com/popup.php");
	  WebElement ClickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
	  ClickHere.click();
	  System.out.println(driver.getTitle());
	  
	  Set <String> tab = driver.getWindowHandles();
	  Iterator<String> li = tab.iterator();
	  String Parent = li.next();	//Tab1
	  String child = li.next();		//Tab2
	  
	  driver.switchTo().window(child);
	  System.out.println(driver.getCurrentUrl());
	  
	  driver.switchTo().window(Parent);
	  System.out.println(driver.getCurrentUrl());
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
