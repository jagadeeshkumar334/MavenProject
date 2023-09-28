package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class FileDownload {
	public WebDriver driver;
	
  @Test
  public void f() {
	  
	  driver.get("https://demo.automationtesting.in/FileDownload.html#google_vignette");
	  WebElement download_btn = driver.findElement(By.xpath("//a[contains(text(),'Download') and (@type='button')]"));
	  System.out.println(download_btn.isDisplayed());
	  download_btn.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  
	  ChromeOptions opt = new ChromeOptions();
	  HashMap<String, Object> pref = new HashMap<String, Object>();
	  pref.put("download.prompt_for_download", false);
	  pref.put("plugins.always_open_pdf_externally", true);
	  opt.setExperimentalOption("pref", pref);
	  
	  driver = new ChromeDriver(opt);
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
