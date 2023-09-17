package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Yahoo_Login {
	public WebDriver driver;
  @Test
  public void Yahoo() {
	  driver.get("https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fin.mail.yahoo.com%2Fd");
		
		WebElement username = driver.findElement(By.id("login-username"));
		System.out.println(username.isDisplayed());
		username.click();
		username.sendKeys("pavankumar334@myyahoo.com");		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		WebElement signincheck = driver.findElement(By.xpath("//span[@class='stay-signed-in checkbox-container']"));
		WebElement signincheck1 = driver.findElement(By.xpath("//input[contains(@id,'persistent')]"));
		System.out.println(signincheck.isDisplayed());
			
		System.out.println(signincheck1.isSelected());
		
		if(signincheck1.isSelected()) 
		{			
			Actions act = new Actions(driver);
			act.moveToElement(signincheck).click().build().perform();	
		}
		
		System.out.println(signincheck1.isSelected());
		
		WebElement nextbtn = driver.findElement(By.xpath("//input[contains(@id,'login-signin')]"));
		System.out.println(nextbtn.isDisplayed());
		nextbtn.click();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'login-passwd')]"));
		System.out.println("Password displayed: " +password.isDisplayed());	
		password.click();
		password.sendKeys("Yahoo@2023");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement nextbtn1 = driver.findElement(By.xpath("//button[contains(@id,'login-signin')]"));
		nextbtn1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement logoff = driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']"));
		Actions Log = new Actions(driver);
		Log.moveToElement(logoff).build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(@id,'profile-signout-link')]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(logout).click().build().perform();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\\\ChromeDriver_116\\\\chromedriver-win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
  }

}
