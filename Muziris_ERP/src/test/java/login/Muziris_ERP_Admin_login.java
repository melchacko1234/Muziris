package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Muziris_ERP_Admin_login {

	public static void main(String[] args) throws InterruptedException {
	
		loginpage();
	}
	
	public static void loginpage() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://192.168.0.131:8394/posmodules/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		driver.findElement(By.linkText("Sales Invoice - Estimate")).click();
		Thread.sleep(5000);
		String handlewindow = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow);
		Thread.sleep(5000);
	    driver.findElement(By.id("btnCustomerInfo_add")).click();
	    driver.findElement(By.id("ddlCustomerInfo_customerType")).click();
		
		
				
		//driver.close();
		//driver.quit();
		
		
		
		
		
	}

}
