package test.java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandel {

	public static void main(String[] args) {
   WebDriver driver=new ChromeDriver();
   driver.get("https://rahulshettyacademy.com/loginpagePractise/");
   driver.findElement(By.cssSelector(".blinkingText")).click();
  Set<String> windows= driver.getWindowHandles();
  Iterator<String> it=windows.iterator();
  String parentWindowId=it.next();
  String childWindowId=it.next();
  driver.switchTo().window(childWindowId);
  String name=driver.findElement(By.xpath("//a[@href='mailto:mentor@rahulshettyacademy.com']")).getText();
  driver.switchTo().window(parentWindowId);
  driver.findElement(By.id("username")).sendKeys(name);
  
	}

}
