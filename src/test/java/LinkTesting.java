import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTesting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// total link present in the web page.
		System.out.println(" total Links present in  the page ");
		System.out.println(driver.findElements(By.tagName("a")).size());
		// count of link present in only footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links present in footer section of the page  below");
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		// get the number of link present in the first column in the footer section
		WebElement firstColumnLink = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println("Links present in footer section first column only");
		System.out.println(firstColumnLink.findElements(By.tagName("a")).size());
		// Click on each link in the first column
		int links = firstColumnLink.findElements(By.tagName("a")).size();
		for (int i = 0; i <links; i++) {
			String clickNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumnLink.findElements(By.tagName("a")).get(i).sendKeys(clickNewTab);
		}
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			while (it.hasNext()) // check if their is window present
			{
				driver.switchTo().window(it.next());
				System.out.println("title is:  " + driver.getTitle());
			}

		}

	}


