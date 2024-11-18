import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ValidateBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	List<WebElement>	links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	SoftAssert a= new SoftAssert();
	for(int i=0;i< links.size();i++)
	{
		String url =links.get(i).getAttribute("href");
		HttpURLConnection  conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		int responseCode=conn.getResponseCode();
		System.out.println(responseCode);
		a.assertTrue(responseCode<400,"Link broken is"+links.get(i).getText()+" with code "+responseCode);
		
		
	}
	a.assertAll("error message bellow");
	}

}
