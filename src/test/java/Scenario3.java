import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scenario3 {
	// Variable to store the list of items to be added
	String[] items = { "Cucumber", "Brocolli", "Beetroot", "Beans", "Raspberry" };
	static String promoCode = "rahulshettyacademy";

	public static void main(String[] args) {

		// ADD VEGGIES ITEMS TO CART
		WebDriver driver = new ChromeDriver();
		Scenario3 obj = new Scenario3();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		obj.addItems(driver);
		// code for checkout
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys(promoCode);
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// wait till the promo message id displayed
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement staticDropdown = driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

	}

	public void addItems(WebDriver driver) {
		int j = 0;
		// WebElement to get the all the products in the page
		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		// for loop to get the each product and verify if its matching with the item to
		// be added
		for (int i = 0; i < productList.size(); i++) {
			// get the text of each items
			String vegNames = productList.get(i).getText();
			String[] splittedNames = vegNames.split("-");
			// formatted item names
			String formatedName = splittedNames[0].trim();
			// converting the string into array
			List<String> itemsTobeAdded = Arrays.asList(items);
			if (itemsTobeAdded.contains(formatedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (j == itemsTobeAdded.size())
					break;
			}
		}
	}

}
