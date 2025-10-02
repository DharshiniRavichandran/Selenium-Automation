package SeleniumConcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputHandindling {

	public static void main(String[] args) {

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Loading URL
		driver.get("https://letcode.in/edit");
		
		// Enter your full Name
		driver.findElement(By.id("fullName")).sendKeys("Koushik Chatterjee");

		// Append a text and press keyboard tab
		driver.findElement(By.id("join")).sendKeys(" person", Keys.TAB);

		// What is inside the text box
		String myValue = driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(myValue);

		// Clear the text
		driver.findElement(By.id("clearMe")).clear();

		// Confirm edit field is disabled
		boolean isEdit = driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println(isEdit);

		// Confirm text is read only, If this doesn't have any value, then It'll return true or false
		String isReadOnly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(isReadOnly);

		// quit browser
		driver.quit();

	}

}
