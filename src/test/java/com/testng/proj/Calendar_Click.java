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

public class Calendar_Click {
	public WebDriver driver;
	
  @Test
  public void Calendar()  {
	  driver.get("https://www.spicejet.com/");
	  
	  WebElement cal = driver.findElement(By.xpath("//div[contains(@data-testid,'departure-date-dropdown-label-test-id')]"));
	  System.out.println(cal.isDisplayed());
	  cal.click();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
	  WebElement date = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']"));
	  System.out.println(date.isDisplayed());
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(date).click().build().perform();
	  	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement Dep_date = driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']"));
	  System.out.println(Dep_date.isDisplayed());
	  System.out.println(Dep_date.getText());	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
