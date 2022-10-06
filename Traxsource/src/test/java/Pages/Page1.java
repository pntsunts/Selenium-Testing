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
    By name = By.id("login");


    public void Signup()  {
        driver.findElement(signup).click();
    }
    public void login(){
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys("Peter");
    }

}
