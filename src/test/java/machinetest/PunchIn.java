package machinetest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class PunchIn extends BaseClass {
	@Test(priority = 1)
	public void punchIn() throws InterruptedException, ElementClickInterceptedException {
		// Storing the Web element Punch-in and validating that it is displayed in web
		// page
		Thread.sleep(2000);
		WebElement punch_in = driver.findElement(By.xpath("//span[text()='Punch In']"));
		// Validating the element
		if (punch_in.isDisplayed()) {
			// Displaying a message using Reporter class
			Reporter.log("Punch-In element is displayed on the website", true);
			// Clicking on the punch-in element after the validation
			punch_in = driver.findElement(By.xpath("//span[text()='Punch In']"));
			Thread.sleep(2000);
			punch_in.click();
			// Changing the controller to the popup window
			Set<String> punch_in_handles = driver.getWindowHandles();
			for (String str : punch_in_handles)
				driver.switchTo().window(str);
			Thread.sleep(2000);
			// Entering into report text field and clicking on the Done button
			driver.findElement(By.xpath("//textarea[@data-placeholder='Report']")).sendKeys("-");
			WebElement drop_down = driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c80-1441']"));
			Select sel = new Select(drop_down);
			sel.selectByIndex(0);
			driver.findElement(By.xpath("//span[text()='Done']")).click();
			Reporter.log("Punch In executed.....", true);

		} else
			Reporter.log("Punch In button is not displayed on the webpage.....", true);
		Reporter.log("Punch In test script executed successfully......");
	}

}
