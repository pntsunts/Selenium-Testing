package Entrance;

import Pages.Page1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Main {
    public WebDriver driver;


    Page1 page = new Page1(driver);


        @Test (priority = 0)
        public void launch() {
            page.browser();

        }
        @Test (priority = 1)
        public void signup(){

            page.Signup();
        }

}


