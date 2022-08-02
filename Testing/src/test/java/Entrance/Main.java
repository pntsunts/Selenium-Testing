package Entrance;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.Selecting;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class Main {
	
	  public String baseUrl = "https://www.ilabquality.com/";
	  String driverpath = "C:\\chromedriver.exe";
	  public WebDriver driver;
	  
	  public ExtentHtmlReporter htmlReporter;
	  public ExtentReports extent;
	  public ExtentTest test;
	  
	  @BeforeTest
	  public void Setextent() {
		  
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Report.html");
		  htmlReporter.config().setDocumentTitle("Automation Report");
		  htmlReporter.config().setReportName("Functional Report");
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent = new ExtentReports();
		  
		  extent.attachReporter(htmlReporter);
		  
		  extent.setSystemInfo("Hostname", "LocalHost");
		  extent.setSystemInfo("OS", "Windows10");
		  extent.setSystemInfo("Tester Name", "Peter");
		  extent.setSystemInfo("Browser", "Chrome");
		
		  
	  }
	  
	  
	  @BeforeMethod 
	  public void launch() throws InterruptedException {
	    	
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	     
	  driver.manage().window().maximize();
	     
	  Thread.sleep(1000);
	     
	  driver.get(baseUrl);
	  }
	 
	  @Test (priority = 0)
	  
	  public void career() throws IOException, InterruptedException {
		  
		  test = extent.createTest("career");
		
		  Selecting sele = new Selecting(driver);
		  sele.career();
		  sele.country();
		  sele.Job();
	  } 
	  
	  
	  @AfterMethod 
	  public void Teardown(ITestResult result) {
		  
		  if (result.getStatus() == ITestResult.FAILURE) {
			  test.log(Status.FAIL, "TEST FAILED IS "+ result.getName());
			  test.log(Status.FAIL, "TEST FAILED IS "+ result.getThrowable());
		  }
		  else if (result.getStatus() == ITestResult.SKIP) {
			  test.log(Status.SKIP, "TEST CASE SKIPPED IS" + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
			  test.log(Status.PASS, "TEST PASSED IS "+ result.getName());
		  }
	  }
	  
	  @AfterTest
	  
	  public void endReport() {
		  
		  extent.flush();
	  }	
	  
//	  @Test (priority = 1)
// 
//	  public void apply() {
//		  Selecting sele = new Selecting(driver);
//		  sele.apply();
//		  sele.name();
//		  sele.email();
//		  sele.phoneNumber();
//		  sele.submit();
//	  }
	 

 }
	  
		   
	  
	  
	  
	    


