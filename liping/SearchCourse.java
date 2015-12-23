	import org.testng.annotations.Test;
	import java.awt.List;
    
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.sun.jna.platform.mac.Carbon.EventHotKeyID.ByValue;
	
	@Test
public class SearchCourse {
		public  void  searchCourse() throws InterruptedException {
			//定义浏览器的安装目录
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			//创建一个对象
			WebDriver driver =new ChromeDriver();
			//设置窗口最大化
			driver.manage().window().maximize();
			//获取url地址
			driver.get("http://www.imooc.com");
			//在使用navigate方法前先定义url变量
			String url= "http://www.imooc.com";
			//使用navigate方法获取url,
			driver.navigate().to(url);
			Thread.sleep(1000);
			//WebElement courselink = driver.findElement(By.xpath("//a[@href='/course/list']")).click();
			WebElement courseLnk = driver.findElement(By.xpath("//a[@href='/course/list']"));
			courseLnk.click();
			//通过xpath方法找到课程链接
		/*	driver.findElement(By.xpath("//a[href='/course/list']"));
			String currentwin=driver.getWindowHandle();
			WebDriver currentwin = driver.switchTo().window(driver.getWindowHandle());//
			String curTitle =driver.getTitle();*/
			String currentUrl = driver.getCurrentUrl();
			System.out.println("当前url为："+currentUrl);
			Thread.sleep(2000);
			
			//通过xpath找到搜索框
			WebElement text = driver.findElement(By.xpath("//input[@class='js-keyword']"));
			//在搜索框中输入关键字"+"
			text.sendKeys("+");
			//执行搜索
			WebElement schbtn =driver.findElement(By.xpath("//a[@class='btn_search js-search']"));
			schbtn.click();
			Thread.sleep(2500);
			WebElement histy =driver.findElement(By.xpath("//ul[@class='course-sidebar-result']"));
			histy.click();
			/*WebDriver driver = new InternetExplorerDriver();  
			String  ss = "alert(1)";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(ss);
			method2*/
			
			Thread.sleep(20000);
			driver.close();
		}

}
