package MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {

    public WebDriver driver;
    public String BaseUrl = "https://www.makemytrip.com/";
    public String opt = "Mumbai, India";

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(BaseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void Run() throws IOException {
        driver.findElement(By.xpath("//input[@id = \"fromCity\"]")).sendKeys("Mumbai");
        List<WebElement> Country = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
        for (WebElement ele : Country){
            String CellText = ele.getText();
            if (CellText.contains(opt)){
                ele.click();
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement cont = driver.findElement(By.xpath("//input[@class =\"topbarInputBox footerInput\"]"));
        js.executeScript("arguments[0].scrollIntoView();", cont);
        cont.sendKeys("12345");

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot1, new File("C:\\Users\\Peter\\Desktop\\New folder (8)\\"+"Screen"+"1.png"));



    }
}
