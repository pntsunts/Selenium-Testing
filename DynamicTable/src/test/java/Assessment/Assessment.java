package Assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class Assessment {
    public WebDriver driver;

    public String BaseUrl = "https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(BaseUrl);
        driver.manage().window().maximize();

    }
    @Test (priority = 1)
    public void Run1() throws InterruptedException, AWTException {

        WebElement FirstName = driver.findElement(By.id("RESULT_TextField-1"));
        FirstName.sendKeys("Peter");
        WebElement LastName = driver.findElement(By.id("RESULT_TextField-2"));
        LastName.sendKeys("Ntsuntsha");
        WebElement phone = driver.findElement(By.id("RESULT_TextField-3"));
        phone.sendKeys("07864722");
        WebElement country = driver.findElement(By.id("RESULT_TextField-4"));
        country.sendKeys("South africa");
        WebElement city = driver.findElement(By.id("RESULT_TextField-5"));
        city.sendKeys("Germiston");
        WebElement emailAdress = driver.findElement(By.id("RESULT_TextField-6"));
        emailAdress.sendKeys("peter@gmail.com");


    }
    @Test (priority = 2)
    public void Run2(){
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> Gender = driver.findElements(By.xpath("//input[@name = \"RESULT_RadioButton-7\"]"));
        for (int i = 0; i < Gender.size(); i++) {
            //actions.moveToElement(Gender.get(0)).click().perform();
            js.executeScript("arguments[0].click(); ", Gender.get(0));
        }
    }
    @Test (priority = 3)
    public void Run3() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> days = driver.findElements(By.xpath("//input[@name = \"RESULT_CheckBox-8\"]"));
        for (int i = 0; i < days.size(); i++) {
            js.executeScript("arguments[0].click(); ", days.get(i));
        }
    }

    @Test (priority = 4)
    public void Run4() {

        String opt = "Evening";
        driver.findElement(By.id("RESULT_RadioButton-9")).click();
        List<WebElement> option = driver.findElements(By.xpath("//option[@value]"));
        for (WebElement ele : option) {
            String CellText = ele.getText();
            if (CellText.contains(opt)) {
                System.out.println(ele.getText());
                ele.click();
                break;
            }
        }
    }
    @Test (priority = 5)
    public void Run5() throws AWTException {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//input[@id = \"RESULT_FileUpload-10\"]"));

//        button.sendKeys("C:\\Users\\Peter\\Downloads\\sample.pdf");
//
//        Thread.sleep(5000);


		 actions.moveToElement(button).click().perform();
		 Robot rb = new Robot();

		 StringSelection ss = new StringSelection("C:\\Users\\Peter\\Downloads\\sample.pdf");

		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		 rb.keyPress(KeyEvent.VK_CONTROL);
		 rb.keyPress(KeyEvent.VK_V);

		 rb.keyRelease(KeyEvent.VK_CONTROL);
		 rb.keyRelease(KeyEvent.VK_V);

		 rb.keyPress(KeyEvent.VK_ENTER);

         driver.findElement(By.id("FSsubmit")).click();


    }
}
