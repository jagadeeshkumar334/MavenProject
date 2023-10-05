package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class FileUpload {
	public WebDriver driver;
  @Test
  public void UploadFile() throws AWTException, InterruptedException {
	  
	  driver.get("https://demo.guru99.com/test/upload/");
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement choosefile = driver.findElement(By.xpath("//input[contains(@id, 'uploadfile_0')]"));
	  Actions act = new Actions(driver);
	  act.moveToElement(choosefile).click().build().perform();
	  //choosefile.sendKeys("D:\\Jack\\Data Driven Testing\\DDT.xlsx");
	  //choosefile.click();
	  
	  
	  
	  //String file = "D:\\Screenshot.jpg";
	  String file = "D:\\Jack\\Data_Driven_Testing\\DDT.xlsx";
	  StringSelection selector = new StringSelection(file);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selector, null);
	  Thread.sleep(5000);
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Robot robot = new Robot();
	  
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  Thread.sleep(5000);
	  
	  WebElement termsch_bx = driver.findElement(By.xpath("//input[contains(@id,'terms')]"));
	  termsch_bx.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement submit_btn = driver.findElement(By.xpath("//button[contains(@id,'submitbutton')]"));
	  submit_btn.click();
	  
	  WebElement success_msg = driver.findElement(By.xpath("//div[@class='formbuttons']/h3/center[text()='has been successfully uploaded.']"));
	  System.out.println(success_msg.getText());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}
