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
import java.util.concurrent.TimeUnit;

public class Main {
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

//    @Test
//    public void TestTable() {
//        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
//        if (table.isDisplayed()) {
//            System.out.println("Ready To test");
//            List<WebElement> rows =
//                    driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody/tr"));
//            System.out.println(rows.size());
//            for (int i = 0; i < rows.size(); i++) {
//                List<WebElement> column =
//                        rows.get(i).findElements(By.xpath("//table[@class='tsc_table_s13']//tbody/tr//td"));
//                System.out.println(column.size());
//                for (int j = 0; j < column.size(); j++) {
//
//                    String cellText = column.get(1).getText();
//                    System.out.println(cellText);

//                    if (cellText.equals("Taiwan")) {
//                        System.out.println("Dubai was built in : " + column.get(2).getText());
//                    }

//                }


//            }
//        }

    @Test
    public void TestClass() {

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr"));
        int rowCount = rows.size();
        System.out.println(rowCount);
        for (int i = 0; i < rowCount; i++) {
            List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr/td"));
            int columnCount = column.size();

            for (int j = 0; j < column.size(); j++) {

                String cellText = column.get(j).getText();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                if (cellText.equals("hhhjhk")) {
                    System.out.println("Taiwan was built in : " + column.get(4).getText());
                }

            }
        }
    }

 }
