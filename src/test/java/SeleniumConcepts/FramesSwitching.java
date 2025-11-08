package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesSwitching {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// URL loading
		driver.get("https://letcode.in/frame");
		
		//Switching to the main frame to 1st child frame
		WebElement myFrame = driver.findElement(By.xpath("//iframe[@id='firstFr']"));
		driver.switchTo().frame(myFrame);
		driver.findElement(By.name("fname")).sendKeys("koushik");
		driver.findElement(By.name("lname")).sendKeys("C");
        //driver.switchTo().frame(0).switchTo().frame(0);-->Directly going to the inner child frame
		driver.switchTo().frame(0);
		driver.findElement(By.name("email")).sendKeys("email");
		//Going back to the parent frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("Chatterjee");
		//Going back to the main frame
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()='Watch tutorial']")).click();
	
		//quit the browser
		driver.quit();
	}

}
