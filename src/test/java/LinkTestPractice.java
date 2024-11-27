package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LinkTestPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement footerLinks=driver.findElement(By.id("gf-BIG"));
        System.out.println(footerLinks.findElements(By.tagName("a")).size());
        WebElement footerLinkFirstColumn= footerLinks.findElement(By.xpath("//tbody/tr/td[1]/ul"));
        int NumberOflinks=footerLinkFirstColumn.findElements(By.tagName("a")).size();
        for(int i=0;i<NumberOflinks;i++)
        {
            String clickNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footerLinkFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickNewTab);
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
