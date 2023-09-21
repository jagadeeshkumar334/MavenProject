package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class AllConcepts {
	public WebDriver driver;
  @Test
  public void facebookSignup() throws IOException {
	  
	  driver.get("https://www.facebook.com");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
	  
	  WebElement Username = driver.findElement(By.xpath("//input[contains(@name,'firstname')]"));
	  Username.click();
	  Username.sendKeys("pavan");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement Lastname = driver.findElement(By.xpath("//input[contains(@name,'lastname')]"));
	  Lastname.click();
	  Lastname.sendKeys("Kumar");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement emailadd = driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]"));
	  emailadd.click();
	  emailadd.sendKeys("pavankumar334@myyahoo.com");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement Reemailadd = driver.findElement(By.xpath("//input[contains(@name,'reg_email_confirmation__')]"));
	  Reemailadd.click();
	  Reemailadd.sendKeys("pavankumar334@myyahoo.com");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement Password = driver.findElement(By.xpath("//input[contains(@id,'password_step_input')]"));
	  Password.click();
	  Password.sendKeys("Yahoo@2023");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Select Day = new Select(driver.findElement(By.xpath("//select[contains(@id,'day')]")));
	  Day.selectByValue("19");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Select Month = new Select(driver.findElement(By.xpath("//select[contains(@id,'month')]")));
	  Month.selectByVisibleText("Sep");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Select Year = new Select(driver.findElement(By.xpath("//select[contains(@id,'year')]")));
	  Year.selectByValue("1993");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement Male = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
	  Male.click();
	  
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("D://Facebook.jpeg"));
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//div[@class='_1lch']/button[contains(text(),'Sign Up')]")).click();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src1, new File("D://Facebook1.jpeg"));
	  
	  
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
