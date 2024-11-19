package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SpiceJetBookingE2E {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[1]")).click();
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'r-cfp7ip')]/div[text()='BLR']")).click();
        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'r-cfp7ip')]/div[text()='DEL']")).click();

    }
}
