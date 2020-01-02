package testQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidationTest {

	public static void main(String[] args) {
		String URL="http://marksandspicy.com/login_back=my-account.html";
        String Browser ="Chrome";                                          
        String User="";
        String password= "";
        if (Browser == "Chrome") {
        	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			WebElement Userid = driver.findElement(By.id("email"));
			Userid.sendKeys(User);
			WebElement pswd = driver.findElement(By.id("passwd"));
			pswd.sendKeys(password);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String sText = js.executeScript(
					"return document.getElementsByClassName(\"is_required validate account_input form-control\")[1].validationMessage;")
					.toString();

			//System.out.println(sText);
			if (sText.isEmpty()) {
				System.out.println("Tool-Tip Validation Passed!!");
			} else {
				System.out.println("Tool-Tip Validation Failed");
			}
			driver.close();
        }
	}

}
