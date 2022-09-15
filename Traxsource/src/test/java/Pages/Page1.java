package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page1 {
    WebDriver driver;
    public Page1(WebDriver driver) {
        this.driver = driver;
    }

    By signup = By.id("signupLnk");


    public void Signup()  {
        driver.findElement(signup).click();
    }

    public void browser(){
        String baseUrl = "https://www.traxsource.com/";
        String driverpath = "C:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
}
