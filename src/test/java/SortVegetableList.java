package test.java;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class SortVegetableList {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rnish\\OneDrive");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> list=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList=list.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> listSorted=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> sortedAfterClick=listSorted.stream().map(s->s.getText()).collect(Collectors.toList());
		//Assert.assertEquals(originalList, sortedAfterClick);
		
		
		
	}

}
