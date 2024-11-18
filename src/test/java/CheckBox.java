import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// count the number of checkbox
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		List<WebElement> checkboxOptions=driver.findElements(By.xpath("//div[@id='discount-checkbox'] //div"));
		for(WebElement options: checkboxOptions)
		{
			
			if(options.getText().equalsIgnoreCase("Senior Citizen"))
			{
				options.click();
				
			}
				
		}
	}

}
