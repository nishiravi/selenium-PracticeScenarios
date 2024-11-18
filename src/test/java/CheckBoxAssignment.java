import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
   System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()+" checkbox present");
	}

}
