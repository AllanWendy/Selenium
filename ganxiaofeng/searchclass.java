


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
		  
		// 定义chromedriver的安装目录
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver(); //创建driver对象
	    String url = "http://www.imooc.com"; // 进入慕课网官网
	    driver.manage().window().maximize();
	    driver.manage().timeouts()
	        .implicitlyWait(MAX_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	    driver.get(url); //设置浏览器最大化显示
	  }
	 
	  @AfterClass
	  public static void tearDownAfterClass() throws Exception {
	    if (driver != null) {
	      System.out.println("运行结束！");
	      driver.quit();
	    }
	  }
	
	
   @Test
	public  void login() throws InterruptedException {
	   
	   // 定义chromedriver的安装目录
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		
	  driver.findElement(By.id("J_Login")).click(); //通过id定位到官网上的 登录按钮
	  Thread.sleep(3000);
	  String currentWindow = driver.getWindowHandle(); //定义当前窗口
     
	  WebElement logButton = driver.findElement(By.xpath("//*[@id='signup-form']/div[1]/input")); //通过xpath定位到邮箱输入框
	  logButton.sendKeys("mukexiaogan@163.com");
      Thread.sleep(3000);
	  
	   WebElement logMail = driver.findElement(By.xpath("//*[@id='signup-form']/div[2]/input")); //通过xpath定位到密码输入框
	   logMail.sendKeys("151162");
	   Thread.sleep(3000);
	  
       WebElement loginQQ = driver.findElement(By.id("signin-btn"));//通过id定位到登录界面上的登录按钮
	   Thread.sleep(3000);
	   loginQQ.click();
	  
	   String CurrentTitle = driver.getTitle();
	   System.out.println(CurrentTitle);
       try {  
           Thread.sleep(3000);  
   } catch (InterruptedException e) {  
              e.printStackTrace();  
   }
	
		   
	    String feed_url ="http://www.imooc.com/course/list"; //跳转到 课程页面
        driver.get(feed_url);
        Thread.sleep(3000);
 	  
	    WebElement textarea = driver.findElement(By.className("js-keyword")); //通过classname定位到搜索课程按钮
	    textarea.sendKeys("PHP");
	  
	    Thread.sleep(5000);

	    WebElement searchbtn = driver.findElement(By.xpath("//a[@class='btn_search js-search']"));  //通过classname定位到搜索按钮
	    
	    searchbtn.click();
	    Thread.sleep(5000);
	  
 

     }
}