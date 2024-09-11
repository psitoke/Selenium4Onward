package seleniumversion4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class swithcwindoPartSS_HeightWidth {


		public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\pranavsitoke\\Downloads\\Pranav_PersonalDocs\\Selenium_Automation\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Switching Window

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles=driver.getWindowHandles();

		Iterator<String> it=handles.iterator();

		String parentWindowId = it.next();

		String childWindow =it.next();

		driver.switchTo().window(childWindow);

		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

		.get(1).getText();

		driver.switchTo().window(parentWindowId);

		WebElement name=driver.findElement(By.cssSelector("[name='name']"));

		name.sendKeys(courseName);

		//Screenshot

		File file=name.getScreenshotAs(OutputType.FILE);

		Files.copy(file, new File("logo.png"));

		//driver.quit();

		//GEt Height & Width

		System.out.println(name.getRect().getDimension().getHeight());

		System.out.println(name.getRect().getDimension().getWidth());

		}



		

}

