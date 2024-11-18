import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowsScrollAndTable {

	public static void main(String[] args) throws InterruptedException {
        int sum=0;
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<values.size();i++)
		{
			String amount=values.get(i).getText();
			sum=sum+ Integer.parseInt(amount);
		}
		String text=driver.findElement(By.cssSelector(".totalAmount")).getText();
		String[] splittedtext=text.split(":");
		int actualAmount=Integer.parseInt(splittedtext[1].trim());
		Assert.assertEquals(sum, actualAmount);
		System.out.println("total amount is "+sum);
		driver.close();
		
	}


}
