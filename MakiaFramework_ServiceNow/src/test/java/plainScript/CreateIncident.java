package plainScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class CreateIncident {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev128088.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. Login with valid credentials username as admin and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();

		// 3. Click All
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[@aria-label='Search']").click();
		shadow.findElementByXPath("//input[contains(@placeholder,'Search')]").sendKeys("INC0000001",Keys.ENTER);
		/*
		 * shadow.findElementByXPath("//div[@id='all']").click();
		 * 
		 * shadow.findElementByXPath("//input[@id='filter']").sendKeys("incident");
		 * shadow.setImplicitWait(10);
		 * shadow.findElementByXPath("//div[@id='all']").click();
		 * shadow.setImplicitWait(10);
		 * shadow.findElementByXPath("//span[text()='All']").click();
		 * 
		 * driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(
		 * "INC0000001",Keys.ENTER);
		 */
		
		
	}

}
