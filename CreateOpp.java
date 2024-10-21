package excelIntegration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateOpp extends ProjectSpecificMethod {

	@Test(dataProvider = "getdata")
	public void createOpp(String uname, String pword, String description, String amount) {

		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", clickOpportunity);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(description);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		WebElement clickStage = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]"));
		js.executeScript("arguments[0].click();", clickStage);
		driver.findElement(By.xpath("//span[@class='slds-media__body']//span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String verOpportunity = driver
				.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by VimalRaj']"))
				.getText();
		if (verOpportunity.equals("Salesforce Automation by VimalRaj")) {
			System.out.println("Opportunity created successfully");
		} else {
			System.out.println("Opportunity was not created");
		}

	}

}
