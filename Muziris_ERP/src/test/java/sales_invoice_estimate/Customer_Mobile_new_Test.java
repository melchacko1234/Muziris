package sales_invoice_estimate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import listners.Allure_listner;
import manager.BaseClass;


@Listeners({Allure_listner.class})
public class Customer_Mobile_new_Test {

	WebDriver driver = null;
	public File scrFile;

	@BeforeClass 
	public void setUp()
	{
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("http://192.168.0.131:8394/posmodules/");
	}

	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=1, description="Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP0008")
	@Feature("Feature 1: Registration for Customer_Mobile_New ")
	@Story("Story: User registration for Customer_Mobile_New")
	@Step("Verify login Registration for Customer_Mobile_New")
	public void login_Customer_Mobile_New() throws InterruptedException 
	{


		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Sales Invoice - Estimate Page

		driver.findElement(By.linkText("Sales Invoice - Estimate")).click();
		Thread.sleep(5000);

		for (String window : driver.getWindowHandles())
		{

			System.out.println(window);

		}
		// System.out.println(((String) driver.getWindowHandles()).toArray().length);
		String handlewindow = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow);
		Thread.sleep(5000);
	}

	@Severity(SeverityLevel.CRITICAL)	
	@Test(priority=2, description="Verify user can complete new mobile number registration")
	@Description("Verify user can complete new mobile number registration........")
	@Epic("EP0008")
	@Feature("Feature2: Registration for Customer_Mobile_New ")
	@Story("Story:User registration for Customer_Mobile_New")
	@Step("Verify Registration for Customer_Mobile_New in Customer_Mobile_New page ")
	public void Customer_Mobile_New_registration() throws InterruptedException, IOException {



		driver.findElement(By.cssSelector("#btnCustomerInfo_add")).click();

		new Select(driver.findElement(By.id("ddlCustomerInfo_customerType"))).selectByVisibleText("Retail");
		driver.findElement(By.id("ddlCustomerInfo_customerType")).click();



		new Select(driver.findElement(By.id("ddlCustomerInfo_customerType"))).
		selectByVisibleText("Retail");
		driver.findElement(By.id("ddlCustomerInfo_customerType")).click();

		Thread.sleep(3000);
		driver.findElement(By.id("txtCustomerInfo_customerName")).clear();
		driver.findElement(By.id("txtCustomerInfo_customerName")).sendKeys("rishi Singh");
		Thread.sleep(3000);

		// checkbox click--not working
		driver.findElement(By.xpath("//input[@id='rbnCustomerInfo_Male']")).sendKeys(Keys.RETURN);

		driver.findElement(By.xpath("//input[@name='customerInfo_address1']")).sendKeys("Kariparambil house");
		driver.findElement(By.xpath("//input[@name='customerInfo_address2']")).sendKeys("burma road");

		new Select(driver.findElement(By.id("ddlCustomerInfo_country"))).selectByVisibleText("India");
		driver.findElement(By.id("ddlCustomerInfo_country")).click();

		// if Dropdown selected by India only then show the other selection dropdowns
		// State dropdown

		new Select(driver.findElement(By.id("ddlCustomerInfo_state"))).selectByVisibleText("Kerala");
		driver.findElement(By.id("ddlCustomerInfo_state")).click();

		// District DropDown
		new Select(driver.findElement(By.id("ddlCustomerInfo_District"))).selectByVisibleText("Ernakulam");
		driver.findElement(By.id("ddlCustomerInfo_District")).click();

		// Entering pincode

		driver.findElement(By.xpath("//input[@name='customerInfo_pincode']")).sendKeys("682030");

		// Contactdetails section

		// Entermobilenumber

		driver.findElement(By.xpath("//input[@name='customerInfo_mobno']")).clear();
		driver.findElement(By.xpath("//input[@name='customerInfo_mobno']")).sendKeys("8921763153");

		// Emailid
		driver.findElement(By.xpath("//input[@name='customerInfo_email']")).sendKeys("abrham@gmail.com");

		// PAN textbox

		driver.findElement(By.xpath("//input[@name='customerInfo_panno']")).sendKeys("ABBDED098F");
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales Invoice-Customer_Mobile_New_registation.png"));
		// updatebutton click


		driver.findElement(By.xpath("//button[@id='btnCustomerInfo_update']")).click();
		Thread.sleep(4000);
	}

	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=3, description="Verify first Bradcode scan for new Customer mobile registered")
	@Description("Verify user can complete first Bradcode scan.......")
	@Epic("EP0008")
	@Feature("Feature3: First Bradcode scan for Customer_Mobile_New  ")
	@Story("Story:First barcode")
	@Step("Verify scanning of first barcode")
	public  void Barcode1_new_cust_mob() throws InterruptedException, IOException
	{

		/*driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).clear();
		driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("8921763152");
		driver.findElement(By.id("form")).submit();*/

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("205749484");
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

		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales Invoice-Barcode1_new_cust_mob.png"));


	}



	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=4, description="Verify Second Bradcode scan for new Customer mobile registered")
	@Description("Verify user can complete Second Bradcode scan.......")
	@Epic("EP0008")
	@Feature("Feature4: Second Bradcode scan for Customer_Mobile_New ")
	@Story("Story:Second Bradcode")
	@Step("Verify scanning of Second Bradcode")

	public  void barcode2_new_cust_mob() throws InterruptedException, IOException
	{
		//code to check validation of enough stock.

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("205749533");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).click();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDone']")).click();

		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales Invoice-Barcode2_new_cust_mob.png"));


		Thread.sleep(2000);
	}

	// cancel button 

	//driver.findElement(By.xpath("//*[@id='hbnTBCancel']/button")).sendKeys(Keys.RETURN);



	@Severity(SeverityLevel.TRIVIAL)	
	@Test(priority=5, description="Verify Advanced Search for new Customer mobile registered")
	@Description("Verify user can do Advanced Search.......")
	@Epic("EP0008")
	@Feature("Feature5: Advanced Search  for Customer_Mobile_New ")
	@Story("Story:Advanced Search")
	@Step("Verify Advanced Search")

	public  void Advanced_Search_new_cust_mob() throws InterruptedException, IOException
	{


		// Save button 

		driver.findElement(By.xpath("//*[@id='hbnTBSave']/button")).sendKeys(Keys.RETURN);
		String handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='confirmCancel']")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='tab-adv-search']/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'#generalSearch') and @data-toggle='collapse']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtSearch_phNo']")).sendKeys("8921763153");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales Invoice-Advanced_search_new_cust_mob.png"));

		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='salesInvoiceList']/tbody/tr[1]/td[5]"))).doubleClick().perform();


		Thread.sleep(4000);






	}


	@Severity(SeverityLevel.TRIVIAL)	
	@Test(priority=6, description="Verify EAN_barcodeScan for new Customer mobile registered")
	@Description("Verify user can do EAN_barcodeScan.......")
	@Epic("EP0008")
	@Feature("Feature6: EAN_barcodeScan  for Customer_Mobile_New ")
	@Story("Story:EAN_barcodeScan")
	@Step("Verify EAN_barcodeScan")

	public  void EAN_barcodeScan_new_cust_mob() throws InterruptedException
	{

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("8905209766868");
		driver.findElement(By.id("form")).submit();

		String handlewindow4 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow4);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='productMRPList']/tbody/tr[2]/td[2]"))).doubleClick().perform();
		Thread.sleep(3000);



	}


	@AfterClass
	public void afterTest_Customer_Mobile_New() {

		driver.close();
		driver.quit();
	}

}
