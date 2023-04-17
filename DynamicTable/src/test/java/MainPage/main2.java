package MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class main2 {
    public WebDriver driver;
    public String Baseurl = "https://www.techlistic.com/p/demo-selenium-practice.html";

    @BeforeTest
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(Baseurl);
        driver.manage().window().maximize();
    }
    @Test
    public void TestTable() {
        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
        if (table.isDisplayed()) {
            List<WebElement> rows = driver.findElements(By.tagName("tr"));

            int rowCount = rows.size();
            System.out.println("No of Rows " + rowCount);

            for (int i = 0; i < rowCount; i++){

                List<WebElement> column = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j < column.size(); j++){
                    String cellText = column.get(j).getText();
                    if (cellText.equals("Taiwan")) {
                        System.out.println("City is : " + column.get(1).getText() + " and height is : " + column.get(2).getText());

                    }
                }

            }

        }
    }
}
