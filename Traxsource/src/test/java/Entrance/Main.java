package Entrance;

import Pages.Page1;
import Pages.Page2;
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

        @BeforeTest
        public void launch() {
            String baseUrl = "https://www.traxsource.com/";
            String driverpath = "C:\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);

        }
        @Test (priority = 1)
        public void signup() throws InterruptedException {
            Page1 page = new Page1(driver);

            page.Signup();
            Thread.sleep(5000);
        }
        @Test (priority = 2)
        public void register() throws InterruptedException {
            Thread.sleep(1000);
            Page2 page2 = new Page2(driver);
            page2.login();

        }

}


