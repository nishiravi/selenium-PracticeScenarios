package test.java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkValidation {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	String url=	driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
	System.out.println(url);
	HttpURLConnection  conn=(HttpURLConnection) new URL(url).openConnection();
	conn.setRequestMethod("HEAD");
	conn.connect();
	int responseCode=conn.getResponseCode();
	System.out.println(responseCode);
	// check which all the links present in the page are broken
	List<WebElement> links= driver.findElements(By.cssSelector(".gf-li a"));
	for(WebElement link:links)
	{
		String httpurl=link.getAttribute("href");
		 HttpURLConnection connection=(HttpURLConnection) new URL(httpurl).openConnection();
		 connection.setRequestMethod("HEAD");
		 connection.connect();
		 int ResponseStatusCode=connection.getResponseCode();
		 System.out.println(ResponseStatusCode);
		 if(responseCode>400)
		 {
			 System.out.println("broken link is "+link.getText()+" status code is"+responseCode);
		 }
	}
	}

}
