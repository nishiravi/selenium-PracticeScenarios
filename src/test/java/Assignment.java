import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.name("checkBoxOption2")).click();
		String optionSelected=driver.findElement(By.xpath("//label[@for='benz']")).getText();
		Select dropdown=new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByIndex(2);
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage=driver.switchTo().alert().getText();
		alertMessage.contains(optionSelected);
		Assert.assertTrue(alertMessage.contains(optionSelected));
		driver.switchTo().alert().accept();
		System.out.println(optionSelected +" is present in the alert message " );



		}

}
