import GlobalMethod.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class feedback{
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
		WebElement feedback = driver.findElement(By.xpath("//a[@class='goto_top_backMeg']"));
	    feedback.click();
	    
	    
	   String currentWindow = driver.getWindowHandle();
        //得到所有窗口的句柄
       Set<String> handles = driver.getWindowHandles();
       Iterator<String> it = handles.iterator();
       while(it.hasNext()){
       String handle = it.next();
       if(currentWindow.equals(handle)) continue;
       WebDriver window = driver.switchTo().window(handle);
       System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());

		// 获取 网页的 title
		System.out.println("2 Page title is: " + driver.getTitle());
		Thread.sleep(1000); 

		// 通过 id 找到 意见输入框
		WebElement info = driver.findElement(By.xpath("//*[@id='info']"));
		//输入用户的意见反馈信息
		info.sendKeys("testlss");
		//定位用户的联系方法页面元素，通过name
		WebElement contact = driver.findElement(By.id("contact"));
		//WebElement element1 = driver.findElement(By.xpath("//input[class='phd error-field']"));
		//输入用户联系方法信息
		contact.sendKeys("13510000000");
		//为了看得效果，等待3秒钟
		Thread.sleep(3000);
		//执行提交操作
		driver.findElement(By.id("submit")).click();
	    try {  
	           Thread.sleep(5000);  
	   } catch (InterruptedException e) {  
	              e.printStackTrace();  
	   }   
		//单击继续添加意见，继续访问意见反馈页面，继续提交
		WebElement goOn = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		goOn.click();
		   
		//通过href属性找到关于我们
		WebElement aboutUs = driver.findElement(By.xpath("//a[@href='/about/us']"));
		aboutUs.click();
		// 获取 网页的 title
		System.out.println("2 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 
		
		//通过href属性找到人才招募
		WebElement aboutJob = driver.findElement(By.xpath("//a[@href='/about/job']"));
		aboutJob.click();
		// 获取 网页的 title
		System.out.println("3 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 

		//通过href属性找到讲师招募
		WebElement aboutRecruit = driver.findElement(By.xpath("//a[@href='/about/recruit']"));
		aboutRecruit.click();
		// 获取 网页的 title
		System.out.println("4 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 
		
		//通过href属性找到联系方式
		WebElement aboutContact = driver.findElement(By.xpath("//a[@href='/about/contact']"));
		aboutContact.click();
		// 获取 网页的 title
		System.out.println("5 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 
		
		// 退出浏览器
		driver.quit();
		
		}
	}
	
}

