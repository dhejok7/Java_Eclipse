package dhejoprojects.seleniummavenframework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// opening the Website
		driver.get("https://rahulshettyacademy.com/client");
		
		// entering the email address
		driver.findElement(By.id("userEmail")).sendKeys("rani8@gmail.com"); // rani8@gmail.com
		//hello
		// entering the password
		driver.findElement(By.id("userPassword")).sendKeys("Amazon@123"); // Amazon@123
		
		//clicking the sign-in button
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		// entered the home page
		// selects the list of buying items in the page
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); 
		// to check the list of contents in the browser console, use this command -> console.dir(document.getElementsByClassName("mb-3"));
		
		//to select the 'Banarsi Saree' product from the list of all buying items in the page.
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("BANARSI SAREE")).findFirst().orElse(null);
		
		// click on the add to cart button in the selected item
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//after adding to cart waiting for the toast message -> toast-container and disappearing of loading spinner
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ng-animating")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		// click on the cart button in top
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")).click(); // cssselector -> ("[routerlink*='cart']")
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		
		// closing the browser
//		driver.quit();
//		System.out.println("completed successful!");
	}

}

/*
 css selector
 #id
 .class
 //
  **/
