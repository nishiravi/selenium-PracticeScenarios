import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLError {

	public static void main(String[] args) {

		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
