package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page2 {
    WebDriver driver;
    public Page2(WebDriver driver) {
        this.driver = driver;
    }
    By name = By.id("login");
    By password = By.id("password1");
    By password2 = By.id("password2");
    By email = By.id("email");
    By email2 = By.id("email2");
    By First_Name = By.id("first_name");
    By Last_Name = By.id("last_name");
    By Country = By.id("country_id");
    By Phone = By.id("phone");

    public void login(){
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys("Peter");
    }
}
