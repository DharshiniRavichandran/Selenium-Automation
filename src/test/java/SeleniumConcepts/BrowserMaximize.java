package SeleniumConcepts;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMaximize {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// URL loading
		driver.get("https://letcode.in/test");
		Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();
		// driver.manage().window().maximize();
		
		//quit the browser
		driver.quit();
	}
}
