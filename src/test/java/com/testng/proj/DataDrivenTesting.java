package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DataDrivenTesting {
	public WebDriver driver;
  @Test(enabled=false)
  public void DDT() throws IOException {
	  File DDT = new File("D:\\Jack\\Data Driven Testing\\DDT.xlsx");
	  FileInputStream Fis = new FileInputStream(DDT);
	  XSSFWorkbook Book = new XSSFWorkbook(Fis);
	  XSSFSheet Sheet = Book.getSheetAt(0);
	  System.out.println("Total no.of Rows: " +Sheet.getLastRowNum());
	  XSSFRow col = Sheet.getRow(0);
	  System.out.println("Total no.of Columns: " +col.getLastCellNum());
	  
	  for(int i=0; i<=Sheet.getLastRowNum();i++) {
		  for(int j=0; j<col.getLastCellNum();j++) {
			  System.out.println(Sheet.getRow(i).getCell(j).getStringCellValue());
			  
			  //Yahoo Login for testing DDT
			  driver.get("https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fin.mail.yahoo.com%2Fd");
				
				WebElement username = driver.findElement(By.id("login-username"));
				System.out.println(username.isDisplayed());
				username.click();
				username.sendKeys(Sheet.getRow(i).getCell(j).getStringCellValue());		
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
				
				WebElement signincheck = driver.findElement(By.xpath("//span[@class='stay-signed-in checkbox-container']"));
				WebElement signincheck1 = driver.findElement(By.xpath("//input[contains(@id,'persistent')]"));
				System.out.println(signincheck.isDisplayed());
					
				System.out.println(signincheck1.isSelected());
				
				if(signincheck1.isSelected()) {
					Actions act = new Actions(driver);
					act.moveToElement(signincheck).click().build().perform();	
				}
				System.out.println(signincheck1.isSelected());
				
				WebElement nextbtn = driver.findElement(By.xpath("//input[contains(@id,'login-signin')]"));
				System.out.println(nextbtn.isDisplayed());
				nextbtn.click();
				
				try {
					WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
					System.out.println("Password displayed: " +password.isDisplayed());	
					password.click();
					password.sendKeys(Sheet.getRow(i).getCell(j=j+1).getStringCellValue());
					}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
					System.out.println("Password displayed: " +password.isDisplayed());	
					password.click();
					password.sendKeys(Sheet.getRow(i).getCell(j=j+1).getStringCellValue());
					
				}
				
				/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
				
				System.out.println("Password displayed: " +password.isDisplayed());	
				password.click();
				password.sendKeys(Sheet.getRow(i).getCell(j+1).getStringCellValue()); */
		  }
	  }	  
  }
  
  @Test
  public void Facebook() throws IOException {
	  File file1= new File("D:\\Jack\\Data Driven Testing\\DDT.xlsx");
	  FileInputStream Fis1 = new FileInputStream(file1);
	  XSSFWorkbook book1 = new XSSFWorkbook(Fis1);
	  XSSFSheet sheet1 = book1.getSheetAt(1);
	  System.out.println("No.of Rows: " +sheet1.getLastRowNum());
	  XSSFRow col = sheet1.getRow(0);
	  System.out.println("No.of Coumuns: " +col.getLastCellNum());
	  
	  
	  
	  for(int i=0; i<=sheet1.getLastRowNum();i++){
		  
		  for(int j=0; j<col.getLastCellNum();j++) {
			  System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue());
			  
			  driver.get("https://www.facebook.com/");
			  
			  WebElement UserName = driver.findElement(By.xpath("//input[contains(@id,'email')]"));
			  UserName.click();
			  UserName.sendKeys(sheet1.getRow(i).getCell(j).getStringCellValue());
			  
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  
			  WebElement Password = driver.findElement(By.xpath("//input[contains(@id,'pass')]"));
			  Password.click();
			  Password.sendKeys(sheet1.getRow(i).getCell(j=j+1).getStringCellValue());			  
		  }
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
	  //driver.close();
  }
}
