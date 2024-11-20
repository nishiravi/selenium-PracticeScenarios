package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CalenderProgramPracticeTest {
    public static void main(String[] args) {
        String month="6";
        String date="15";
        String year="2027";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span")).click();
        driver.findElement(By.xpath("//button[contains(.,'"+year+"')]")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        String  monthCalender=driver.findElement(By.cssSelector(".react-date-picker__inputGroup__month ")).getAttribute("value");
        Assert.assertEquals(month,monthCalender);
        String  dateCalender=driver.findElement(By.cssSelector(".react-date-picker__inputGroup__day")).getAttribute("value");
        Assert.assertEquals(date,dateCalender);
        String  yearCalender=driver.findElement(By.cssSelector(".react-date-picker__inputGroup__year")).getAttribute("value");
        Assert.assertEquals(year,yearCalender);
        System.out.println(" date matched");

    }
}
