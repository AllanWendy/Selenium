package GlobalMethod;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.jna.platform.mac.Carbon.EventHotKeyID.ByValue;

public class CourseStudy {
	public  WebDriver driver = null;
	private String ChromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	
	private String moocurl = "http://www.imooc.com";
	// 设置登录用户username
	private String username = "111@qq.com";
	// 设置登录用户的访问密码
	private String psword = "111111";

	public static WebDriver getchWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	   //new 创建一个driver 对象
		WebDriver driver = new ChromeDriver();
		return driver;
	 
 }
	
	//初始化方法
	public void init()	{
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		//driver = new ChromeDriver();
	
	}

	// 设置打开imooc操作执行方法
	public void open() throws InterruptedException{
	
		// driver.navigate().to(loginurl);
		driver = new ChromeDriver();
		driver.get(moocurl);
		//浏览器最大化
		driver.manage().window().maximize(); 
		System.out.println("1 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 
	}
	
	//设置进入课程页
	public void study()	{
		// 通过 xpath 找到 
		WebElement course = driver.findElement(By.xpath("//a[@href='/course/list']"));
		course.click();
	    
	    // 获取 网页的 title
	    System.out.println("2 Page title is: " + driver.getTitle());
	    OpenByChBrower.waitForSecond(); 
	    
	    //进入某一课程
		WebElement view = driver.findElement(By.xpath("//a[@href='/view/110']"));
	    view.click();
	    
	    System.out.println("3 Page title is: " + driver.getTitle());
	    OpenByChBrower.waitForSecond(); 
	
	}
	
	//设置登录
	public void login()	{
		//通过id找到登录按钮
        WebElement login = driver.findElement(By.id("J_Login"));	
	    //输入账号
        WebElement email = driver.findElement(By.name("email"));
        //也可用xpath
       //WebElement element4 = driver.findElement(By.xpath("//input[@name='email']"));
       email.sendKeys(username);
       //输入密码
       WebElement password = driver.findElement(By.name("password"));
       //也可用xpath
       //WebElement element5 = driver.findElement(By.xpath("//input[@name='password']"));
       password.sendKeys(psword);
       //点击登录
       WebElement signin = driver.findElement(By.id("signin-btn"));
       signin.click();
	}
	
    @Test
	public  void CourseStudy() throws InterruptedException{

    	CourseStudy courseStudy = new CourseStudy();
    	courseStudy.init();
    	courseStudy.open();	
    	courseStudy.study();

	}

}


		