package test.java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertion {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// count the number of checkbox
		System.out.println("number of checkboxes are ");
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		List<WebElement> checkboxOptions=driver.findElements(By.xpath("//div[@id='discount-checkbox'] //div"));
		for(WebElement options: checkboxOptions)
		{
			
			if(options.getText().equalsIgnoreCase("Senior Citizen"))
			{
				options.click();
				System.out.println(options.getText() +" is selected");
				break;
			}
				
		}
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// assertion to check if the text displayed is as expected 
		driver.findElement(By.id("divpaxinfo")).click();
		int i=1;
		while(i<5) 
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		i++;
		}
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText()+ " selected");
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

}
