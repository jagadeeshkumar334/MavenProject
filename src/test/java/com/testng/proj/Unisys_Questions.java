package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Unisys_Questions {
	public WebDriver driver;

  @Test(enabled=false)
  public void f() {
	  driver.get("https://demoqa.com/slider");
	  WebElement slider = driver.findElement(By.xpath("//span[@class='range-slider__wrap']/input[@value='25']"));
	  WebElement slider1 = driver.findElement(By.xpath("//span[@class='range-slider__wrap']/input[@value='90']"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Actions act = new Actions(driver);
	  act.dragAndDrop(slider, slider1).build().perform();
	  //act.click
  }
  @Test
  public void program() {
	  String name = "Jagadeesh";
	  HashSet<String> hs = new HashSet<String>();
	  
	char[] ch=name.toCharArray();
	  for (int i=0;i<ch.length-1;i++) {
		  
		  if(ch[i]==ch[i+1]) {
			System.out.println(ch[i]);  
		  }
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
