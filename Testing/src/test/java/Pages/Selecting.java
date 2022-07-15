package Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selecting {
	
	WebDriver driver;
	
	public Selecting(WebDriver driver) {
		this.driver = driver;
	}
	By career = By.xpath("/html/body/header/div/div/div[3]/nav/ul/li[4]/a");
	By country = By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a");
	By Job = By.xpath("//a[@class = 'wpjb-job_title wpjb-title']");
	By apply = By.xpath("//a[@class ='wpjb-button wpjb-form-toggle wpjb-form-job-apply']");
	By name = By.id("applicant_name");
	By email = By.id("email");
	By phone = By.id("phone");
	By submit = By.id("wpjb_submit");
	By errormessage = By.xpath("//div[contains(@class,'wpjb-flash-error wpjb-flash-small')]");
	
	
	public void career() {
			
		driver.findElement(career).click();
	
	}
	public void country() {
		
		driver.findElement(country).click();
	}
	public void Job() {
		
		driver.findElement(Job).click();
	}
	public void apply() {
		
		driver.findElement(apply).click();
	}
	public void name() {
		
		driver.findElement(name).sendKeys("Peter");
	}
	public void email() {
		
		driver.findElement(email).sendKeys("automationAssessment@iLABQuality.com");
	}
	public void phoneNumber() {
		
		Random Phone = new Random();
		
		int No;
		
		String Store[] = new String[10];
		
		for(int i = 0; i < 10; i++) {
			
			No = Phone.nextInt(10);
			
			Store[i] = Integer.toString(No);
			Store[0] = Integer.toString(0);
		}
		driver.findElement(phone).sendKeys(Store);
		
	 }
	public void submit() {
		
		driver.findElement(submit).click();
	}
	public void error() {
		
		driver.findElement(errormessage);
		
		if (((WebElement) errormessage).isDisplayed()) {
			
			System.out.println("You need to upload at least 1 Document");
			
		}
		else {
			System.out.println("No error");
		}
	}
	

}
