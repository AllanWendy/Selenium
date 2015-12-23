import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class download_app {
	private static WebDriver driver;
	static final int MAX_TIMEOUT_IN_SECONDS = 5;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver();
	    String url = "http://www.imooc.com";
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    driver.manage().timeouts()
	        .implicitlyWait(MAX_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	    driver.get(url);
	  }
	
	
	@Test
	public  void download() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		//new 创建对象
	//	WebDriver driver = new ChromeDriver();
		//设置浏览器窗口最大化
	//   driver.manage().window().maximize();
	//   String web_url = "http://www.imooc.com";
	   //to方法打开url地址
	//   driver.navigate().to(web_url);
	   Thread.sleep(3000);
	   
	   String currentWindow = driver.getWindowHandle();
	   System.out.println(currentWindow);
	   try {  
           Thread.sleep(3000);  
   } catch (InterruptedException e) {  
              e.printStackTrace();  
   }
	   
	   
	   Thread.sleep(3000);
	   
	   WebElement app_down = driver.findElement(By.xpath("//a[@class='goto_top_app']"));
	   app_down.click();	 
	   Thread.sleep(3000);
	   
	   WebElement Android_down = driver.findElement(By.xpath("//a[@class='android-down']"));  
	   Android_down.click();
	 
     

     }
}