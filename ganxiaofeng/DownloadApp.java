

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

public class DownloadApp {
	private static WebDriver driver; //����WebDriver�Ķ��� driver
	static final int MAX_TIMEOUT_IN_SECONDS = 5;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
		
		  // ����chromedriver�İ�װĿ¼
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    
	  	driver = new ChromeDriver(); //����driver����
	    String url = "http://www.imooc.com";
	  
	    driver.manage().window().maximize();  //��������������ʾ
	    Thread.sleep(3000);
	    driver.manage().timeouts()
	        .implicitlyWait(MAX_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	    driver.get(url); //get�����õ�url��ַ
	    Thread.sleep(3000);
	  }
	
	
	@Test
	public  void downloadAPP() throws InterruptedException {
		
		// ����chromedriver�İ�װĿ¼
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    Thread.sleep(3000);
	   
	   String currentWindow = driver.getWindowHandle();  //���嵱ǰ����
	   System.out.println(currentWindow);
	   try {  
           Thread.sleep(3000);  
   } catch (InterruptedException e) {  
              e.printStackTrace();  
   }
	   
	   
	   Thread.sleep(3000);
	   
	   WebElement appDown = driver.findElement(By.xpath("//a[@class='goto_top_app']"));  //ͨ��xpath��λAPP���ذ�ť
	   appDown.click();	 
	   Thread.sleep(3000);
	   
	   WebElement androidDown = driver.findElement(By.xpath("//a[@class='android-down']"));  //ͨ��xpath��λAndroid���ذ�ť
	   androidDown.click();
	 
     

     }
}