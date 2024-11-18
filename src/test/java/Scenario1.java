package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario1 {

	public static  void main(String[] args) {
         WebDriver driver=new ChromeDriver();
         driver.get("https://rahulshettyacademy.com/angularpractice/");
         driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("nishi");
         driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys("nfj@gmail.com");
         driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
         driver.findElement(By.id("exampleCheck1")).click();
         Select dropdown=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
         dropdown.selectByIndex(1);
         driver.findElement(By.id("inlineRadio1")).click();
         //driver.findElement(By.xpath("//div[@class='form-group']/input[@name='bday']")).click();
         driver.findElement(By.name("bday")).sendKeys("02/02/1992");

         driver.findElement(By.cssSelector(".btn-success")).click();
         System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
	}

}
