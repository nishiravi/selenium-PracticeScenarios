package test.java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String userName="rahul";
		String passWord= Locators2.getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(passWord);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button[class*='submit']")).click();
		Thread.sleep(1000);
		String s=driver.findElement(By.tagName("p")).getText();
		//Assert.assertEquals(s ,"You are successfully logged in.");
		//Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), "Hello " +userName+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println("pass");
		driver.quit();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String s=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[]splittedString=s.split("'");
		String[] a=splittedString[1].split("'");
		String password=a[0];
		return password;
	}


}
