package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropBy {

	public static void main(String[] args) {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// First switching from mainframe to child frame
		driver.switchTo().frame(0);
		
		WebElement ele = driver.findElement(By.cssSelector("#draggable"));
		Actions builder = new Actions(driver);
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		builder.dragAndDropBy(ele, x+70, y+90).perform();

		driver.quit();
	}

}
