package Practize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

public class TestClass {
    public WebDriver driver;
    public String Url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    @Test
    public void TestClas(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(Url);
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("//table[@id ='customers']//tbody"));

        List <WebElement> rows = driver.findElements(By.tagName("tr"));

        int rowCount = rows.size();

        for (int i = 0; i < rowCount; i++){
            
            List<WebElement> column = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < column.size(); j++){
                String cellText = column.get(j).getText();
                if (cellText.equals("Mexico")){
                    System.out.println("Company is : " + column.get(0).getText() + " and Contact is : " + column.get(1).getText() );
                }

            }
        }
    }

}
