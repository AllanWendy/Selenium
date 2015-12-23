


import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.jna.platform.mac.Carbon.EventHotKeyID.ByValue;

public class SearchClass {
	private static WebDriver driver;
	static final int MAX_TIMEOUT_IN_SECONDS = 5;


	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
		  
		// ����chromedriver�İ�װĿ¼
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver(); //����driver����
	    String url = "http://www.imooc.com"; // ����Ľ��������
	    driver.manage().window().maximize();
	    driver.manage().timeouts()
	        .implicitlyWait(MAX_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	    driver.get(url); //��������������ʾ
	  }
	 
	  @AfterClass
	  public static void tearDownAfterClass() throws Exception {
	    if (driver != null) {
	      System.out.println("���н�����");
	      driver.quit();
	    }
	  }
	
	
   @Test
	public  void login() throws InterruptedException {
	   
	   // ����chromedriver�İ�װĿ¼
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		
	  driver.findElement(By.id("J_Login")).click(); //ͨ��id��λ�������ϵ� ��¼��ť
	  Thread.sleep(3000);
	  String currentWindow = driver.getWindowHandle(); //���嵱ǰ����
     
	  WebElement logButton = driver.findElement(By.xpath("//*[@id='signup-form']/div[1]/input")); //ͨ��xpath��λ�����������
	  logButton.sendKeys("mukexiaogan@163.com");
      Thread.sleep(3000);
	  
	   WebElement logMail = driver.findElement(By.xpath("//*[@id='signup-form']/div[2]/input")); //ͨ��xpath��λ�����������
	   logMail.sendKeys("151162");
	   Thread.sleep(3000);
	  
       WebElement loginQQ = driver.findElement(By.id("signin-btn"));//ͨ��id��λ����¼�����ϵĵ�¼��ť
	   Thread.sleep(3000);
	   loginQQ.click();
	  
	   String CurrentTitle = driver.getTitle();
	   System.out.println(CurrentTitle);
       try {  
           Thread.sleep(3000);  
   } catch (InterruptedException e) {  
              e.printStackTrace();  
   }
	
		   
	    String feed_url ="http://www.imooc.com/course/list"; //��ת�� �γ�ҳ��
        driver.get(feed_url);
        Thread.sleep(3000);
 	  
	    WebElement textarea = driver.findElement(By.className("js-keyword")); //ͨ��classname��λ�������γ̰�ť
	    textarea.sendKeys("PHP");
	  
	    Thread.sleep(5000);

	    WebElement searchbtn = driver.findElement(By.xpath("//a[@class='btn_search js-search']"));  //ͨ��classname��λ��������ť
	    
	    searchbtn.click();
	    Thread.sleep(5000);
	  
 

     }
}