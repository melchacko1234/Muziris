package sales_invoice_estimate;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;

public class Customer_Mobile_new_existingTest {

	WebDriver driver=null;
	
	String handlewindow;


	@Test
	public void Customer_Mobile_existing() throws InterruptedException {

		//Login Page
		driver.get("http://192.168.0.131:8394/posmodules/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Sales Invoice - Estimate Page

		driver.findElement(By.linkText("Sales Invoice - Estimate")).click();
		Thread.sleep(5000);
		handlewindow = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9496531046");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("121600478873");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
		String handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow1);
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Care of");
		driver.findElement(By.id("ddlPdt_additionalDisType")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).click();
		driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).sendKeys("5");
		new Select(driver.findElement(By.name("pdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
		driver.findElement(By.name("pdt_additionalApprovedBy")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();


		//Scanning 2nd item of the barcode

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("121600547595");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
		String handlewindow2 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow2);
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Damage");
		driver.findElement(By.id("ddlPdt_additionalDisType")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).click();
		driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).sendKeys("40");



		Thread.sleep(3000);


		new Select(driver.findElement(By.id("ddlPdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
		driver.findElement(By.name("pdt_additionalApprovedBy")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();

		//3rd bardcode scan and also validation of enough stock for the particular barcode.


		//code to check validation of enough stock.

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("121600547596");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).click();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDone']")).click();

		Thread.sleep(2000);




		//4th barcode scan
		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("121600547597");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).click();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDone']")).click();


		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@id='btnGenDiscount']")).click();
		//delete general discount
		
		
		//Actions action = new Actions(driver);
		//WebElement we = driver.findElement(By.xpath("//button[@id='btnGenDiscount']"));
		//action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//button[@id='btnGenDiscount']"))).click().build().perform();
		/* WebElement element = driver.findElement(By.id("something"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
		
		
		driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);
		//driver.findElement(By.id("ddlGenDisc_additionalDisType")).click();
		String handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow3);
		Thread.sleep(5000);

		/* Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		 WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Select");
		    	 WebElement xpathelement= driver.findElement(By.name("genDisc_additionalDisType"));
		    	 if(xpathelement.isEnabled())
		    	 {
		    		 System.out.println("Element found");
		    	 }
				return xpathelement;
		     }
		   });
		   
		   element.click();   */
			   
		new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Damage");
		driver.findElement(By.name("genDisc_additionalDisType")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
		driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("15");
		Thread.sleep(3000);


		new Select(driver.findElement(By.name("genDisc_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
		driver.findElement(By.name("genDisc_additionalApprovedBy")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
		Thread.sleep(3000);




		//4th barcode delete.
		
		/*Actions action1 = new Actions(driver);
		WebElement we1 = driver.findElement(By.xpath("//button[@id='btnGenDiscount']"));
		action1.moveToElement(we1).moveToElement(driver.findElement(By.xpath("//button[@id='btnGenDiscount']"))).click().build().perform();*/
		//driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);
		
		
		 WebElement element = driver.findElement(By.id("btnGenDiscount"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		String handlewindow4 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow4);
		Thread.sleep(3000);


		new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Select");
		driver.findElement(By.name("genDisc_additionalDisType")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
		driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).clear();
		Thread.sleep(3000);


		new Select(driver.findElement(By.name("genDisc_additionalApprovedBy"))).selectByVisibleText("Select");
		driver.findElement(By.name("genDisc_additionalApprovedBy")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();

		
		
		//First delete of barcode
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='tblSalesInvoiceDtls']/tbody/tr[2]/td[4]"))).doubleClick().perform();

		
		driver.findElement(By.xpath(("//*[@id='rbnDelete']/following-sibling::span"))).click();    
		driver.findElement(By.xpath("//button[@id='btnDone']")).click();



		//Second delete of barcode
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("//*[@id='tblSalesInvoiceDtls']/tbody/tr[1]/td[2]/span"))).doubleClick().perform();
		driver.findElement(By.xpath(("//*[@id='rbnDelete']/following-sibling::span"))).click();    
		driver.findElement(By.xpath("//button[@id='btnDone']")).sendKeys(Keys.RETURN);

		// Save button 
		
		driver.findElement(By.xpath("//*[@id='hbnTBSave']/button")).sendKeys(Keys.RETURN);
		//*[@id="hbnTBSave"]/button



	}
	@BeforeTest
	public void beforeTest_Customer_Mobile_existing() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

	}

	@AfterTest
	public void afterTest_Customer_Mobile_existing() {
		
		
		driver.close();
		driver.quit();
	}

}
