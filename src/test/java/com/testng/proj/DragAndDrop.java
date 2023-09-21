package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DragAndDrop {
	public WebDriver driver;
	Actions act;
  @Test
  public void f() {
	  driver.get("https://www.demo.guru99.com/test/drag_drop.html");
	  	WebElement drag = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
	  	System.out.println(drag.isDisplayed());
	  	
	  	WebElement drop = driver.findElement(By.xpath("//ol[@id='bank']/li"));
	  	System.out.println(drop.isDisplayed());
	  	
	  	act = new Actions(driver);
	  	act.dragAndDrop(drag, drop).build().perform();
	  	
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	
	  	WebElement drag1 = driver.findElement(By.xpath("//li[4]/a[contains(text(),'5000')]"));
	  	System.out.println(drag1.isDisplayed());
	  	
	  	WebElement drop1 = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
	  	System.out.println(drop1.isDisplayed());
	  	
	  	act = new Actions(driver);
	  	act.dragAndDrop(drag1, drop1).build().perform();
	  	
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	
	  	WebElement drag2 = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
	  	System.out.println(drag2.isDisplayed());
	  	
	  	WebElement drop2 = driver.findElement(By.xpath("//ol[@id='loan']/li"));
	  	System.out.println(drop2.isDisplayed());
	  	
	  	act = new Actions(driver);
	  	act.dragAndDrop(drag2, drop2).build().perform();
	  	
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	
	  	WebElement drag3 = driver.findElement(By.xpath("//li[2]/a[contains(text(),'5000')]"));
	  	System.out.println(drag3.isDisplayed());
	  	
	  	WebElement drop3 = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
	  	System.out.println(drop3.isDisplayed());
	  	
	  	act = new Actions(driver);
	  	act.dragAndDrop(drag3, drop3).build().perform();
	  	
	  	WebElement Perfect = driver.findElement(By.xpath("//a[contains(text(),'Perfect')]"));
	  	System.out.println(Perfect.getText());
	  	if(Perfect.getText().contains("Perfect")) {
	  		
	  		System.out.println("Perfect text printed successfully");
	  	}
	  	
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
	  ChromeOptions opt = new ChromeOptions();
	  opt.addArguments("--disable-notifications");
	  
	  driver =new ChromeDriver(opt);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
