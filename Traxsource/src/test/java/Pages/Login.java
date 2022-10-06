package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    By log = By.id("loginTxt");
    By Password = By.id("passwordTxt");

    public void setLogin(){
        driver.findElement(log).clear();
        driver.findElement(log).sendKeys("Peeeee");
        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("HSdjxnsjcn");
    }
}
