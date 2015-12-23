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

public class SubmitFeedback {
	@Test
	public  void submitFeedback() throws InterruptedException {
		// 定义chromedriver的安装目录
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		//创建driver对象
		WebDriver driver = new ChromeDriver();
		//设置浏览器最大化显示
		driver.manage().window().maximize(); 
		//get方法得到url地址
		//driver.get("http://www.imooc.com/oms");   
		String web_url = "http://www.imooc.com";
	    driver.navigate().to(web_url);
	    //刷新一下页面元素
	    driver.navigate().refresh();
	    //输出当前页面的title
	    System.out.println(driver.getTitle()); 
	    //Thread.sleep(5000);
       try {  
                Thread.sleep(3000);  
        } catch (InterruptedException e) {  
                   e.printStackTrace();  
        }
	    driver.findElement(By.id("J_Login")).click();
	    Thread.sleep(5000);
	  //定义当前窗口
	   String currentWindow = driver.getWindowHandle();
	   System.out.println(currentWindow);
	   //WebDriver window = driver.switchTo().window(currentWindow);
	   //通过name定位邮箱输入框
	   WebElement email = driver.findElement(By.name("email"));
	   //输入邮箱信息
	   email.sendKeys("wenyu757123@163.com");
	   //等待3秒
	   Thread.sleep(3000);
	   //通过name定位邮箱密码输入框
	   WebElement password = driver.findElement(By.name("password"));
	   //输入密码信息
	   password.sendKeys("111111");
	   //定位登录按钮
	   WebElement signin = driver.findElement(By.id("signin-btn"));
	   //执行登录按钮的click方法，执行登录操作
	   signin.click();
	   Thread.sleep(3000);
	   //为了验证登录成功，返回当前窗口的title
	   String CurrentTitle = driver.getTitle();
	   System.out.println(CurrentTitle);
       try {  
           Thread.sleep(3000);  
   } catch (InterruptedException e) {  
              e.printStackTrace();  
   }
	   //WebElement feedBack = driver.findElement(By.id("feedBack"));
	   //feedBack.click();
       String feed_url ="http://www.imooc.com/user/feedback";
       driver.get(feed_url);
	   WebElement textarea = driver.findElement(By.id("info"));
	   //driver.findElement(By.xpath(".//*[@id='info']")).sendKeys("12345");
	   //输入用户的意见反馈信息
	   textarea.sendKeys("autotest自动化测试测试");
	   //定位用户的联系方法页面元素，通过name
	   WebElement contact = driver.findElement(By.name("contact"));
	   //输入用户联系方法信息
	   contact.sendKeys("QQ:3654784512");
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
	   WebElement addsugg =  driver.findElement(By.xpath("//div[@class='result-wrap']/a"));
	   addsugg.click();
	  
	}
}