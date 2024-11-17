package machinetest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class AddCustomer extends BaseClass {
	public static Select sel;

	@Parameters({ "leadname", "refnumber", "contactperson", "mobile", "email" })
	@Test(priority = 2)
	public void addCustomer(String lead_name, String ref_number, String contact_person, String mobile, String email)
			throws InterruptedException {
		// Finding the My customers element in the web page and clicking on it
		driver.findElement(By.xpath("//span[text()='My Customers']")).click();
		// Clicking on the New Customer button
		driver.findElement(By.xpath("//span[text()=' New Customer ']")).click();
		/*
		 * Changing the controller or thread to the popup window for adding a new
		 * customer after clicking on New Customer button..... By using getWindowHandles
		 * method of the WebDriver interface
		 */
		Set<String> handles = driver.getWindowHandles();
		for (String str : handles)
			driver.switchTo().window(str);
		Thread.sleep(2000);
		// Storing the expected parameters
		String expected_leadname = "Saurav";
		String expected_ref_no = "1234567890";
		String expected_contact_person = "Mr Rahul";
		String expected_mobile = "9876543210";
		String expected_email = "admin123@nimapinfotech.com";
		/*
		 * Validating the email and password using Assert class using Hard assert type and 
		 * Passing the parameters lead name, reference number, contact person, mobile, email from the XML file
		 */
		Assert.assertEquals(expected_leadname, lead_name, "*** Lead Name is IN-VALID ***");
		// Printing the message in the console using Reporter class
		Reporter.log("*** Lead Name is VALID ***", true);
		driver.findElement(By.xpath("//input[@formcontrolname='LeadName']")).sendKeys(lead_name);

		Assert.assertEquals(expected_ref_no, ref_number, "*** Reference number is IN-VALID ***");
		Reporter.log("*** Reference number is VALID ***", true);
		driver.findElement(By.xpath("//input[@formcontrolname='RefNo']")).sendKeys(ref_number);

		Assert.assertEquals(expected_contact_person, contact_person, "*** Contact person is IN-VALID ***");
		Reporter.log("*** Contact person is VALID ***", true);
		driver.findElement(By.cssSelector("input[data-placeholder='Contact Person Name']")).sendKeys(contact_person);

		Assert.assertEquals(expected_mobile, mobile, "*** Mobile is IN-VALID ***");
		Reporter.log("*** Mobile is VALID ***", true);
		driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']")).sendKeys(mobile);

		Assert.assertEquals(expected_email, email, "*** Email is IN-VALID ***");
		Reporter.log("*** Email is VALID ***", true);
		driver.findElement(By.cssSelector("input[data-placeholder='Email']")).sendKeys(email);
		
		// clicking on the Save button after validating all the data
		driver.findElement(By.xpath("//span[text()=' Save ']")).click();
		Reporter.log("Add Customer test script executed successfully......");
	}
}
