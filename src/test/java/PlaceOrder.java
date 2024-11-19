package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PlaceOrder {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        String[] veggiesList = {"Cucumber", "Beetroot", "Onion", "Beans", "Mango"};
        String couponCode = "rahulshettyacademy";
        AddToCart a=new AddToCart();
        a.addItemstoCart(driver, veggiesList);
        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button")).click();
        checkout(driver, couponCode);

    }

    public static void checkout(WebDriver driver, String couponCode) {
        driver.findElement(By.cssSelector(".promoCode")).sendKeys(couponCode);
        driver.findElement(By.cssSelector(".promoBtn")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
       WebElement countriesList= driver.findElement(By.xpath("//select[@fdprocessedid='uf3p0n']"));
        Select dropdown=new Select(countriesList);
        dropdown.selectByValue("India");
        dropdown.getFirstSelectedOption().click();
        driver.findElement(By.cssSelector(".chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}
