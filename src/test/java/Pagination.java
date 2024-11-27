package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pagination {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".sort-icon.sort-icon.sort-descending")).click();
        //// check price of a veggiee and handel pagination
        do {
            List<WebElement> elementList=driver.findElements(By.xpath("//tbody/tr/td[1]"));
            // list of veggies displayed on the page
            List<String> originalList= elementList.stream().map(s->s.getText()).collect(Collectors.toList());
            // using sorting method to sort the veggies list using streams
            List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
            // check if the list dispayed in the webpage is in sorted order or not
            Assert.assertTrue(originalList.equals(sortedList));
          //  sortedList.stream().filter(s->s.getPRiceofVeggies()).map(s->s.getText())
                   // .
        } while(2<1);




    }
}
