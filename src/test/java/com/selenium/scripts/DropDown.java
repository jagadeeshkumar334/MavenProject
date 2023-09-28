package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		DropDown obj = new DropDown();
		obj.dropdown();

	}
	
	public void dropdown() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\ChromeDriver_117\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		WebElement signup = driver.findElement(By.xpath("//div[@id='login_link']//a[2]"));
		System.out.println(signup.isDisplayed());
		signup.click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		
		System.out.println(dropdown.isMultiple());
		dropdown.selectByIndex(3);
	
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		dropdown1.selectByVisibleText("Jun");
		
		Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		dropdown2.selectByValue("2022");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		//driver.close();
		
		
	}

}
