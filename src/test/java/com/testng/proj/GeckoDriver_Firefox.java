package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GeckoDriver_Firefox {
	public WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.facebook.com/");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.Gecko.driver", "D:\\FirefoxGeckoDriver\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
