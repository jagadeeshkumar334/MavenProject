package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class BootStrapDD {
	public WebDriver driver;
  @Test(enabled=false)
  public void f() {
	  driver.get("https://www.spicejet.com/");
	  String currencyval = "EUR";
	  
	  WebElement ddicon = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div"));
	  System.out.println(ddicon.isDisplayed());
	  ddicon.click();
	  
	  List <WebElement> DDList = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq']/div/div/div"));
	  System.out.println(DDList.size());
	  
	  for(int i=0; i<DDList.size();i++) {
		  System.out.println(DDList.get(i).getText());
		  
		  if(DDList.get(i).getText().contentEquals(currencyval)) {
			  DDList.get(i).click();
		  }
	  }
	  
  }
  
  @Test
  public void Icici() {
	  driver.get("https://www.icicibank.com/");
	  
	  WebElement Personal = driver.findElement(By.xpath("//a[contains(@id, 'loginsection')]"));
	  Actions Personalact = new Actions(driver);
	  Personalact.moveToElement(Personal).build().perform();
	  
	  List <WebElement> Bankinglist = driver.findElements(By.xpath("//div[contains(@class, 'personal-list')]/ul/li"));
	  System.out.println(Bankinglist.size());
	  
	  for(int i=0;i<Bankinglist.size();i++) {
		  
		  System.out.println(Bankinglist.get(i).getText());
		  
		  if(Bankinglist.get(i).getText().contentEquals("NRI banking")) {
			  Bankinglist.get(i).click();
		  }
	  }
	  
	  
	 /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement Corporate = driver.findElement(By.xpath("//a[contains(text(), 'Corporate banking')]"));
	  Actions Corporateact = new Actions(driver);
	  Corporateact.moveToElement(Corporate).click().build().perform(); */
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_116\\chromedriver-win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
