package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page3 {
    WebDriver driver;
    public Page3(WebDriver driver) {
        this.driver = driver;
    }
    By log = By.id("loginTxt");
    By Password = By.id("passwordTxt");
    By Button = By.xpath("//a[@class='com-btn login-button']");

    public void Login(){
        driver.findElement(log).clear();
        driver.findElement(log).sendKeys("pntsunts");
        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("Tamarillo@13");
    }
    public void click(){
        driver.findElement(Button).click();
    }
}
