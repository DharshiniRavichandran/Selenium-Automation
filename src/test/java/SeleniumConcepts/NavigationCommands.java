package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		
		String url = driver.getCurrentUrl();
		System.out.println("Button page URL " + url);
		
		Thread.sleep(3000);
		driver.findElement(By.id("home")).click();
		String homeURL = driver.getCurrentUrl();
		System.out.println("Home page URL " + homeURL);
		
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().forward();
		System.out.println("returns to button page " + driver.getCurrentUrl());
		
		driver.navigate().refresh();
		driver.navigate().to("https://letcode.in/");
		System.out.println("returns to home page " + driver.getCurrentUrl());
        
		driver.quit();
		/*
		 * Navigation nav = driver.navigate(); nav.back(); nav.forward(); nav.refresh();
		 * nav.to("");
		 */

	}

}
