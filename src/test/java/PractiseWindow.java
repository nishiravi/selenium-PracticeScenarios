import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//li/a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@class='example']/a[text()='Click Here']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID=it.next();
		String ChildID=it.next();
		driver.switchTo().window(ChildID);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
