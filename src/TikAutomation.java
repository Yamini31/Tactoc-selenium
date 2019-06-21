
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;

public class TikAutomation {


	public static void main(String args[]) throws InterruptedException
	{
		String colorofbox2=null;
		System.setProperty("webdriver.chrome.Driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		 driver.get("http://10.0.1.86/tatoc");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//a[@href=\"/tatoc/basic\"]")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//div[@onclick=\"passthru();\"]")).click();
		 Thread.sleep(2000);
		 driver.switchTo().frame("main");
		 
		 String colorofbox1=driver.findElement(By.id("answer")).getAttribute("class");
		 System.out.print(colorofbox1);
	     
		 
		 do
		 {
			 driver.findElement(By.xpath("/html/body/center/a[1]")).click();
			 driver.switchTo().frame("child");
			 colorofbox2=driver.findElement(By.id("answer")).getAttribute("class");
			 System.out.println(colorofbox2);
			 driver.switchTo().parentFrame();
			 
			
			 
	     }while(!(colorofbox1.equals(colorofbox2)));
		 
		   //  driver.switchTo().parentFrame();
		 
			 driver.findElement(By.linkText("Proceed")).click();
			 Thread.sleep(2000);
			 WebElement drag=driver.findElement(By.xpath("//*[@id=\"dragbox\"]"));
			 WebElement drop=driver.findElement(By.xpath("//*[@id=\"dropbox\"]"));
			 Actions a = new Actions(driver);
			 a.dragAndDrop(drag,drop).build().perform();
			 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();	
			 Thread.sleep(1000);
			 driver.findElement(By.linkText("Launch Popup Window")).click();	
			 Thread.sleep(1000);
		
			  String MainWindow=driver.getWindowHandle();		
      		
			    Set<String> s1=driver.getWindowHandles();		
		        Iterator<String> i1=s1.iterator();		
		
		        while(i1.hasNext())			
		        {		
		            String ChildWindow=i1.next();		
		            		
		            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		            {    		
		                 
		                    // Switching to Child window
		                  driver.switchTo().window(ChildWindow);	
		        
		      	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("yaminigupta");
			      Thread.sleep(3000);
			       driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		 }
		            
		            }
		        driver.switchTo().window(MainWindow);
		        
		       
		        driver.findElement(By.linkText("Proceed")).click();	
				 Thread.sleep(1000);
				 
				  driver.findElement(By.linkText("Generate Token")).click();	
					 Thread.sleep(1000);
			
				 String token =driver.findElement(By.id("token")).getText();
				System.out.println(token);
				
				
				Cookie name =new Cookie("mycookie",token);
				driver.manage().addCookie(name);
				
				Set<org.openqa.selenium.Cookie> cookiesList =  driver.manage().getCookies();
				for(Cookie getcookies :cookiesList) {
				    System.out.println(getcookies );
				}
				
				driver.findElement(By.linkText("Proceed")).click();
				
				
				
				
	}
	
}
