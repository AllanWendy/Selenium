package OK;

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

public class playVideo{
	public static void main(String[] args) throws IOException, InterruptedException {
		// 设置 chrome 的路径
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Documents and Settings\\sq\\Local Settings\\Application Data\\Google\\Chrome\\Application\\chrome.exe");
		// 创建一个 ChromeDriver 的接口，用于连接 Chrome
		@SuppressWarnings("deprecation")
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File(
								"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
		// 创建一个 Chrome 的浏览器实例
		WebDriver driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());

		//浏览器最大化
		driver.manage().window().maximize(); 
		
		// 打开imooc
		driver.get("http://www.imooc.com");
		// 打开imooc
		// driver.navigate().to("http://www.imooc.com");

		// 获取 网页的 title
		System.out.println("1 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 

		// 通过 id 找到 
		WebElement course = driver.findElement(By.xpath("//a[@href='/course/list']"));
		course.click();
	    
	    // 获取 网页的 title
	    System.out.println("2 Page title is: " + driver.getTitle());
	    Thread.sleep(1000); 
	    
	    //进入某一课程
		WebElement view = driver.findElement(By.xpath("//a[@href='/view/127']"));
	    view.click();
	    
	    System.out.println("3 Page title is: " + driver.getTitle());
	    Thread.sleep(1000); 
	    //进入章节列表
		WebElement learn = driver.findElement(By.xpath("//a[@href='/learn/127']"));
	    learn.click();
	    
	    System.out.println("4 Page title is: " + driver.getTitle());
	    Thread.sleep(1000); 
	    //进入视频播放页
	    WebElement video = driver.findElement(By.xpath("//a[@href='/video/1896']"));
	    video.click();
	    
	    System.out.println("5 Page title is: " + driver.getTitle());
	    Thread.sleep(1000); 
	    //输入账号
	    WebElement email = driver.findElement(By.name("email"));
	    //也可用xpath
	    //WebElement element4 = driver.findElement(By.xpath("//input[@name='email']"));
	    email.sendKeys("111@qq.com");
	    //输入密码
	    WebElement password = driver.findElement(By.name("password"));
	    //也可用xpath
	    //WebElement element5 = driver.findElement(By.xpath("//input[@name='password']"));
	    password.sendKeys("111111");
	    //点击登录
	    WebElement signin = driver.findElement(By.id("signin-btn"));
	    signin.click();
	    Thread.sleep(5000); 
	    
		// 退出浏览器
		driver.quit();
		

	}
	}
