package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//First switching from mainframe to child frame
		WebElement ele = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(ele);
		
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement dest = driver.findElement(By.cssSelector("#droppable"));
		
		Actions buider = new Actions(driver);		
		buider.dragAndDrop(source, dest).perform();
		
		driver.quit();

	}

}
