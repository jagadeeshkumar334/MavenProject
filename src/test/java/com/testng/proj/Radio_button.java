package com.testng.proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Radio_button {
  @Test(priority=5,groups="Login")
  public void Test1() {
	  System.out.println("Test1");
  }
  @Test(priority=3,enabled=false)
  public void Test2() {
	  System.out.println("Test2");
  }
  @Test(priority=4,groups="Login")
  public void Test3() {
	  System.out.println("Test3");
  }
  @Test(priority=2)
  public void Test4() {
	  int a=0;
	  int b=10;
	  System.out.println(b/a);
  }
  @Test(priority=1,dependsOnMethods="Test4")
  public void Test5() {
	  System.out.println("Test5");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

}
