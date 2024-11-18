import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).contextClick().build().perform();
		WebElement typeText=driver.findElement(By.id("twotabsearchtextbox")); 
		a.moveToElement(typeText).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().perform();
	}}