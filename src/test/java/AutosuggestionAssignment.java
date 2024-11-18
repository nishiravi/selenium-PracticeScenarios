import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutosuggestionAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> states=driver.findElements(By.cssSelector(".ui-menu .ui-menu-item"));
		for (WebElement option: states)
		{
			if(option.getText().equalsIgnoreCase("INDIA"))
			{
				System.out.println(option.getText());
				option.click();
				System.out.println();
				break;
			}
		}
		
		
	}

}
