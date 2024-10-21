package excelIntegration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class ProjectSpecificMethod {
	
	public ChromeDriver driver;
	public ChromeOptions options;
	
	@BeforeMethod
	public void precondition() {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		
	}
	
	
	@AfterMethod
	public void postcondition() {
		driver.close();
	}
	
	@DataProvider(name = "getdata")
	public String[][] fetchData() throws IOException {

		return ExcelDataFile.excelCode();

	}
	

}
