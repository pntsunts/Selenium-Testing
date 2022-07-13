package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Selecting {
	
	WebDriver driver;
	
	public Selecting(WebDriver driver) {
		this.driver = driver;
	}
	By career = By.xpath("/html/body/header/div/div/div[3]/nav/ul/li[4]/a");
	By country = By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a");
	
	public void career() {
			
		driver.findElement(career).click();
			
		System.out.println("Her Man");
	
	}
	public void country() {
		
		driver.findElement(country).click();
	}

}
