package testQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String a[]) {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://marksandspicy.com/login_back=my-account.html");
		
		driver.findElement(By.name("email")).sendKeys("test@test.com");
		driver.findElement(By.name("passwd")).sendKeys("ThisIs@T3st");
		driver.findElement(By.name("SubmitLogin")).click();
		
		String actualUrl= "https://marksandspicy.com/login.html";
		String expectedUrl = driver.getCurrentUrl();
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Pass: No error displayed");
		}
		else {
			System.out.println("Fail"); 
		}		
		driver.close();
	}
}
