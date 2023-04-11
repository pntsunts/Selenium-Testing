package Practize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Practize {

    public WebDriver driver;
    public String baseUrl = "https://www.google.com/gmail/about/";

    @Test (priority = 1)

    public void Practize() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"cookieBar\"]/div/span[2]/a[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(2000);



//        List<WebElement> li = driver.findElements(By.xpath("//*[text() = 'Create an account']"));
//        System.out.println(li.size());
//
//        for (int i = 0; i < li.size(); i++) {
//            System.out.println(li.get(i).getText());
//            li.get(0).click();
//        }

    }

//    @Test (priority = 2)
//    public void start() {
//        List<WebElement> li = driver.findElements(By.xpath("//*[text() = 'Create an account']"));
//        System.out.println(li.size());
//
//        for (int i = 0; i < li.size(); i++) {
//            System.out.println(li.get(i).getText());
//            li.get(0).click();
//        }
////        for (WebElement eachbutton : li){
////            System.out.println(eachbutton.getText());
////        }
//
//    }


}