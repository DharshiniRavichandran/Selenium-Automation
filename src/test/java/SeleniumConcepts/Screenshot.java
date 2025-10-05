package SeleniumConcepts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		
		// get page screenshot
		File firstSrc = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Snaps/img1.png");
		FileHandler.copy(firstSrc, dest);
		
		// get element screenshot
		WebElement ele = driver.findElement(By.id("home"));
		File eleSrc = ele.getScreenshotAs(OutputType.FILE);
		File eledst = new File("./Snaps/img2.png");
		FileHandler.copy(eleSrc	, eledst);
		
		// get sections screenshot
		WebElement info = driver.findElement(By.xpath("//div[@class='column is-3-desktop is-4-tablet']"));
		eleSrc = info.getScreenshotAs(OutputType.FILE);
		eledst = new File("./Snaps/img3.png");
		FileHandler.copy(eleSrc	, eledst);
		
		// quit the browser
		driver.quit();

		

	}

}
