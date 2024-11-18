import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebElementEnabled {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("Div1")).getAttribute("style");
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("Div1")).getAttribute("style");
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Return date element is enabled ");
			//Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Return date element is  not enabled ");
			//Assert.assertTrue(false);
		}
		
	}

}
