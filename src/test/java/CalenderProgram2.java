package test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderProgram2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String year="2027";
		String  month="10";
		String day="12";
		String[] expectedDate= {month,day,year};
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//div[@class='react-calendar__decade-view__years']/button[text()='"+year+"']")).click();
		driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']/button")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		String selectedDate=driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@type='date']")).getAttribute("value");
		System.out.println("date selected from calender "+selectedDate);
		String selectedYear=driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@name='year']")).getAttribute("value");
		Assert.assertEquals(selectedYear,year);
		System.out.println("year given "+year);
		String selectedMonth=driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@name='month']")).getAttribute("value");
		Assert.assertEquals(selectedMonth,month);
		System.out.println("month given "+month);
		String selectedDay=driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@name='day']")).getAttribute("value");
		Assert.assertEquals(selectedDay,day);
		System.out.println("day given "+day);
		// another way of checking the date matched using assertion
		List<WebElement> calenderDate=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		System.out.println(" another way of checking using asseertions");
		for(int i=0;i<calenderDate.size();i++)
		{
			System.out.println(calenderDate.get(i).getAttribute("value"));
			Assert.assertEquals(calenderDate.get(i).getAttribute("value"), expectedDate[i]);
			
		}
		System.out.println(" date entered and date selected matched using assertions");
		
	
		
	}

}
