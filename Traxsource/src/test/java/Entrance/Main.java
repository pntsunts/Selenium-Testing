package Entrance;

import Pages.Page1;
import Pages.Page2;
import Pages.Page3;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Main {
    public WebDriver driver;
    public String baseUrl = "https://www.traxsource.com/";

        @BeforeTest
        public void launch() {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options =new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
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
            Thread.sleep(2000);
            page2.loginclick();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        @Test (priority = 3)
        public void login(){
            driver.switchTo().frame("loginFrame");
            Page3 page3 = new Page3(driver);
            page3.Login();
            page3.click();
        }


}


