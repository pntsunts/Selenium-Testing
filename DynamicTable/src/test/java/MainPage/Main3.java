package MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Main3 {
    public WebDriver driver;
    public String BaseUrl = "https://www.w3schools.com/html/default.asp";

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
    }
    //a[@class = "active_overview\

    @Test
    public void Test(){
        WebElement htmlButton = driver.findElement(By.xpath("//*[@id=\"leftmenuinnerinner\"]/a[19]"));
        htmlButton.click();
        System.out.println("Clicked");
        WebElement table = driver.findElement(By.xpath("//table[@id = \"customers\"]"));
        if (table.isDisplayed()){
            System.out.println("Table Displayed");
            List<WebElement> rows = driver.findElements(By.tagName("tr"));
            int rowCount = rows.size();
            System.out.println("No of Rows is : " + rowCount);
            for (int i = 0; i < rowCount; i++){

                List<WebElement> column = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j < column.size(); j++){
                    String cellText = column.get(j).getText();
                    if (cellText.equals("Italy")) {
                        System.out.println("Name is : " + column.get(1).getText() + " and company is : " + column.get(0).getText());
                        int atid = rows.indexOf(column);
                        System.out.println(atid);
                    }
                }

        }
    }
}}
