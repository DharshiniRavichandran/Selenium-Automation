package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonHandling {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://letcode.in/button");
		
		// Get the X & Y coordinates
		/* driver.findElementById("position").getLocation(); */

		Point point = driver.findElement(By.id("position")).getLocation();
		int x = point.getX();
		int y = point.getY();
		System.out.println("Finding x and y coordinates using pointer class: "+"x => "+x +" y => "+y);

		// Find the color of the button
		String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("\nThe color of the button: "+color);
		
		// Find the height & width of the button
		WebElement element1 = driver.findElement(By.id("property"));
		Rectangle rect = element1.getRect();
		System.out.println("\nFinding x, y, width and height using rectangle class:");
		System.out.println("The x and y coordinates: "+rect.getPoint());
		System.out.println("The width: "+rect.getWidth());
		System.out.println("The height: "+rect.getHeight());
		
		WebElement element2 = driver.findElement(By.id("property"));
		Rectangle rect1 = element2.getRect();
		Dimension dime = rect1.getDimension();
		System.out.println("\nFinding width and height using dimension class:");
		System.out.println("The dimension: "+dime);
		System.out.println("The width: "+dime.getWidth());
		System.out.println("The height: "+dime.getHeight());
		
		// Confirm button is disabled
		boolean isDisabled = driver.findElement(By.id("isDisabled")).isEnabled();
		System.out.print("\nChecking whether the button is enabled or disabled: "+isDisabled);
		driver.quit();

	}

}
