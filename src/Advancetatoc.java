import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Advancetatoc {

	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.Driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		 driver.get("http://10.0.1.86/tatoc");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.linkText("Advanced Course")).click();
		 Thread.sleep(2000);
		
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[1]"));
		  
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	 
	        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click();

	}
	
	
}
