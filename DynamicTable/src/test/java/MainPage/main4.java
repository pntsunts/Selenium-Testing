package MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class main4 {
    public WebDriver driver;
    public String Url = "https://www.w3schools.com/java/java_data_types.asp";

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Url);
    }
    @Test
    public void Test4() throws InterruptedException {
        WebElement table = driver.findElement(By.xpath("//table[@class = \"ws-table-all notranslate\"]"));
        if (table.isDisplayed()){
            System.out.println("Table is Displayed");
            List <WebElement> Rows = driver.findElements(By.tagName("tr"));
            int rowCount = Rows.size();
            System.out.println(rowCount);
            for (int i = 0; i < rowCount; i++){
                List <WebElement> column = Rows.get(i).findElements(By.tagName("td"));
                int columnCount = column.size();
                for (int j = 0; j < columnCount; j++){
                    String celltext = column.get(j).getText();
                    if (celltext.equals("float")){
                        System.out.println(celltext + " Size : " +column.get(1).getText() + " Description "+column.get(2).getText());
                    }
                }
            }
            //Scrolling
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0, 10000)");
            Thread.sleep(2000);
//            driver.quit();
        }
        else{
            System.out.println("Table was not found");

            driver.quit();
        }
    }
}
