package machinetest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class LoginJourney extends BaseClass {

	@Parameters({ "Email", "Password" })
	@Test(priority = 0)
	public void signup(String email, String password) throws InterruptedException {

		String expected_email = "siddiqshaikh1@nimapinfotech.com";
		String expected_password = "admin@123";
		/*
		 * Validating the email and password using Assert class Printing the message in
		 * the console using Reporter class and Passing the parameterised email and
		 * password variables in the text field respectively
		 */
		Assert.assertEquals(expected_email, email, "*** Email is IN-VALID ***");
		Reporter.log("*** Email is VALID ***", true);
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(email);

		Assert.assertEquals(expected_password, password, "*** Password is IN-VALID ***");
		Reporter.log("*** Password is VALID ***", true);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);

		/*
		 * Creating the object of scanner class to take the input from the user manually
		 * of the captcha because it can't be automated
		 */
		Scanner sc = new Scanner(System.in);
		// Entering the value of captcha in the console
		System.out.print("ENTER THE CAPTCHA : ");
		String captcha = sc.next();
		System.out.println();
		// Finding the captcha textfield to the manual data
		WebElement captcha_field = driver.findElement(By.xpath("//input[@formcontrolname='captchaValue']"));
		captcha_field.sendKeys(captcha);
		Thread.sleep(2000);
		// clicking on sign in button
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		sc.close();
		Reporter.log("Login test script executed successfully......");
		
	}
}
