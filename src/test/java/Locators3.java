import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// sibling to sibling
		driver.findElement(By.xpath("//div/a/following-sibling::button[1]")).click();
		//parent to child
		driver.findElement(By.xpath("//div/button[1]/parent::div/parent::header/a[@class='blinkingText']")).click();
		
	}

}
