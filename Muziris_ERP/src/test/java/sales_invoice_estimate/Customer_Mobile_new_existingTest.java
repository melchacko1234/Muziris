package sales_invoice_estimate;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import listners.Allure_listner;
import manager.BaseClass;




import org.testng.SkipException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Listeners;


@Listeners({Allure_listner.class})
public class Customer_Mobile_new_existingTest extends BaseClass {

	public WebDriver driver;

	public File scrFile;
	SoftAssert softassert =new SoftAssert();

	public String handlewindow, handlewindow1, handlewindow2, handlewindow3, handlewindow4;

	@BeforeClass 
	public void setUp() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("http://192.168.0.131:8394/posmodules/");
	}

	@Test(priority = 1, description = "verifying MUziris ERP login test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase description: Verfiy login credentinals of MUziris ERP")
	@Epic("EP001")
	@Feature("Feature1: Login")
	@Story("Story:Valid login")
	//@Step("Verify login")

	public void Customer_Mobile_existing_login() throws InterruptedException, IOException {

		//Login Page



		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


		/* String actualTitle = driver.getTitle();
		String expectedTitle = "Admin home";
		softassert.assertEquals(false, true, expectedTitle);
	   softassert.assertEquals(driver.getTitle(), "Admin home1");
	   softassert.assertAll();*/



		//Sales Invoice - Estimate Page

		driver.findElement(By.linkText("Sales Invoice - Estimate")).click();
		Thread.sleep(5000);
		handlewindow = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow);
		Thread.sleep(5000);

		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales Invoice-Estimate_page.png"));
	}

	@Test(priority = 2, description = "Verifying scanning of first barcode test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase description: Verfiy scanning of first barcode in Sales Invoice - Estimate ")
	@Epic("EP002")
	@Feature("Feature 2: First barcode")
	@Story("Story:First barcode")
	@Step("Verify scanning of first barcode")
	public  void barcode1() throws InterruptedException, IOException
	{

		driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9496531046");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("157895427");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
		handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
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
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales_Invoice-Estimate_Barcode1_scan.png"));

	}


	//Scanning 2nd item of the barcode


	@Test(priority = 3, description = "Verifying sacnning of Second barcode test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase description: Verfiy sacnning of Second barcode in Sales Invoice - Estimate ")
	@Epic("EP003")
	@Feature("Feature 3: Second barcode")
	@Story("Story:Second barcode")
	//@Step("Verify scanning of second barcode")
	public  void barcode2() throws InterruptedException, IOException
	{

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("157895428");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
		handlewindow2 = (String) driver.getWindowHandles().toArray()[1];
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
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales_Invoice-Estimate_Barcode2_scan.png"));

	}
	//3rd bardcode scan and also validation of enough stock for the particular barcode.

	@Test(priority = 4, description = "Verifying sacnning of third barcode test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase description: Verfiy sacnning of third barcode in Sales Invoice - Estimate ")
	@Epic("EP004")
	@Feature("Feature 4: Third barcode")
	@Story("Story:Third barcode")
	@Step("Verify scanning of Third barcode")
	public  void barcode3_enoughstock() throws InterruptedException, IOException
	{
		//code to check validation of enough stock.

		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("157896758");
		driver.findElement(By.id("form")).submit();
		driver.findElement(By.id("txtSalesmanCode")).click();
		driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
		driver.findElement(By.xpath("//button[@id='btnDone']")).click();

		Thread.sleep(2000);
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales_Invoice-Estimate_Barcode3_scan.png"));


	}




	//4th barcode scan


	@Test(priority = 5, description = "Verifying sacnning of fourth barcode test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase description: Verfiy sacnning of fourth barcode in Sales Invoice - Estimate ")
	@Epic("EP005")
	@Feature("Feature 5: Fourth barcode")
	@Story("Story:Fourth barcode")
	@Step("Verify scanning of Fourth barcode")
	public  void barcode4() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("157910948");
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
		handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow3);
		Thread.sleep(5000);



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
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales_Invoice-Estimate_Barcode4_scan.png"));


	}


	//4th barcode delete.


	@Test(priority = 6, description = "Verifying delete of 4th  barcode test")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Testcase description: Verfiy delete Fourth ,Second barcode and then save in Sales Invoice - Estimate ")
	@Epic("EP006")
	@Feature("Feature 6: Fourth ,Second barcode delete and then save")
	@Story("Story:Fourth ,Second barcode delete and then save")
	@Step("Verify Fourth ,Second barcode delete and then save")
	public  void barcode4_2_delete_save() throws InterruptedException, IOException
	{



		WebElement element = driver.findElement(By.id("btnGenDiscount"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		handlewindow4 = (String) driver.getWindowHandles().toArray()[1];
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

		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Sales_Invoice-Estimate_Barcode4_2_delete.png"));


		// Save button 

		driver.findElement(By.xpath("//*[@id='hbnTBSave']/button")).sendKeys(Keys.RETURN);
		//*[@id="hbnTBSave"]/button





	}

	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=7, description="Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP007")
	@Feature("Feature7: Registration")
	@Story("Story:User registration")

	public void registrationTest()
	{
		throw new SkipException("Skipping this Test");
	}


	@AfterClass
	public void tearDown()
	{	
		//driver.close();
		driver.quit();
	}


}
