package Entrance;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Selecting;

import org.testng.annotations.AfterTest;


public class Main {
	
	  public String baseUrl = "https://www.ilabquality.com/";
	  String driverpath = "C:\\chromedriver.exe";
	  public WebDriver driver;
	  
	  @BeforeTest 
	  public void launch() throws InterruptedException {
	    	
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	     
	  driver.manage().window().maximize();
	     
	  Thread.sleep(1000);
	     
	  driver.get(baseUrl);
	  }
	  
	  @Test (priority = 0)
	  
	  public void start() throws IOException, InterruptedException {
		
		  Selecting sele = new Selecting(driver);
		  sele.career();
		  sele.country();
		  
		  
	  } 
	  
		   
	  
	  
	  
	    

}
