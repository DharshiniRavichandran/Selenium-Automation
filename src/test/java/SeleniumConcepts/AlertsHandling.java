package SeleniumConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		
		//Simple Alert
        //driver.switchTo().alert().accept();
		driver.findElement(By.id("accept")).click();
		TargetLocator locator = driver.switchTo();
		Alert simpleAlert = locator.alert();
		String simpleAlertText = simpleAlert.getText();
		System.out.println("Simple alert text "+simpleAlertText);
		simpleAlert.accept();
		
		//Confirm Alert
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert = driver.switchTo().alert();
		String confirmAlertText = confirmAlert.getText();
		System.out.println("Confirm alert text "+confirmAlertText);
		confirmAlert.dismiss();
		
		//Prompt Alert
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("koushik");
		promptAlert.accept();
		String name = driver.findElement(By.id("myName")).getText();
        System.out.println(name);
        
		//quit the browser
		driver.quit();
	}

}
