package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CaptureErrMessageInvalidSignin {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyy");
        driver.findElement(By.cssSelector(".signInBtn")).click();
        String errmsg=driver.findElement(By.className("error")).getText();
        System.out.println(" error message for invalid sigin is "+errmsg);
        driver.close();
    }
}
