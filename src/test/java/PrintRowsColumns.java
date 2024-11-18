import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintRowsColumns {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//JavascriptExecutor jc=(JavascriptExecutor)driver;
	      System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size()+ " rows present");
	      System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size()+ " columns present");
	      List<WebElement> data=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
	      for (int i=0;i<data.size();i++)
	      {
	    	  System.out.println(data.get(i).getText());
	      }
	      
	}

}
