package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddToCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        String[] veggiesList = {"Cucumber", "Beetroot", "Onion","Beans","Mango"};
        String couponCode="rahulshettyacademy";
        addItemstoCart(driver,veggiesList);
    }

    public static void addItemstoCart(WebDriver driver,String[] veggiesList) {

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int countofveggiestobeadded = 0;
        for (int i = 0; i < products.size(); i++) {
            String[] splittednames = products.get(i).getText().split("-");
            String productname = splittednames[0].trim();
            List VeggiesToBeadded = Arrays.asList(veggiesList);
            if (VeggiesToBeadded.contains(productname)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                countofveggiestobeadded++;
                if (countofveggiestobeadded == veggiesList.length) {
                    break;
                }
            }
        }
    }

}
