package com.testng.proj;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {
	public WebDriver driver;
	
	public static void main(String args[]) {
		
		
		Amazon call = new Amazon();
		//call.Amazon();
		call.window();
	}
	public void Amazon() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebElement BH = driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]"));
		Actions Accounts = new Actions(driver);
		Accounts.moveToElement(BH).build().perform();
		
		WebElement BH1 = driver.findElement(By.xpath("//span[contains(text(),'Browsing History')]"));
		Accounts.moveToElement(BH1).click().build().perform();	
		
		
	}
	
	public void window()
{
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_117\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		WebElement newmessage = driver.findElement(By.id("messageWindowButton"));
		newmessage.click();
		
		Set <String> window = driver.getWindowHandles();
		Iterator <String> li = window.iterator();
		String parent = li.next();
		String child = li.next();
		
		//driver.manage().window().
		
		driver.switchTo().window(parent);
		newmessage.click();
		driver.switchTo().window(parent);
		newmessage.click();
		driver.switchTo().window(parent);
		newmessage.click();
		driver.switchTo().window(parent);
		newmessage.click();
		
	
		
		
		
		
		
		}
}
