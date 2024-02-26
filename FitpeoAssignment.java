package miscellaneous;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitpeoAssignment {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		1. open www. flipkart.com
		driver.get("https://www.flipkart.com/");
		WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
 
//		2. type ipad in the search box
		Actions act =new Actions(driver);
		act.keyDown(searchbox, Keys.SHIFT).sendKeys("ipad").build().perform();

//		3. when the suggestions are displayed, click one of them
		List<WebElement> li = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']"));
		Thread.sleep(5000);
		
		for(WebElement element : li)
		{
			if(element.getText().contains("ipad 9th generation"))
			{
				element.click();
			}
		}

//		4. on results page, filter all results by the Online Only filter
		WebElement apple = driver.findElement(By.xpath("//div[@class='_24_Dny']"));
		apple.click();
		Thread.sleep(5000);
		
//		5. select one of the results
		WebElement ipadpro  =driver.findElement(By.xpath("//a[@title='Apple iPad Pro (4th Gen) 128 GB ROM 11.0 inch with Wi-Fi Only (Space Grey)']"));
		ipadpro.click();
		
		Thread.sleep(5000);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		
		Thread.sleep(5000);
		
//		6. Checkout the order
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		
//		7. Place the order		
		driver.findElement(By.xpath("//input[@maxlength='auto']")).click();
		
//		8. Enter Random Email and Phone number		
		driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']")).click();
		
		
		
		
	}

}
