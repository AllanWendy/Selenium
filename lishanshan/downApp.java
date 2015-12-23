import GlobalMethod.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class downApp{
	@Test
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
		WebElement app = driver.findElement(By.xpath("//a[@class='goto_top_app']"));
	    app.click();
	    
	    // 获取 网页的 title
	    System.out.println("2 Page title is: " + driver.getTitle());
	    Thread.sleep(1000); 

		//通过target找到iOS下载按钮
		WebElement iOS = driver.findElement(By.xpath("//a[@target='_blank']"));
		//driver.findElement(By.xpath("//input[@id='username' and @name='userID']"));

		iOS.click();
		
		Thread.sleep(5000); 
		
		// 退出浏览器
		driver.quit();
		

	}
	}
