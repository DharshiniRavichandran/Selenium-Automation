package SeleniumConcepts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypesOfWaits {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// URL loading
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[@href='/edit']")).click();

		// Explicit wait
		driver.get("https://letcode.in/button");
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait for the element to be visible
		WebElement element1 = explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("home")));
		element1.click();

		// Fluent Wait
		driver.get("https://letcode.in/edit");
		FluentWait<ChromeDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20)) // Total timeout
				.pollingEvery(Duration.ofSeconds(2)) // Polling frequency
				.ignoring(NoSuchElementException.class); // Ignore this exception

		WebElement element2 = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fullName")));
		element2.sendKeys("Hello");
   
		//quit the browser
		driver.quit();
	}

}
