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

public class TestProject  {
	@Test
	public void testProject() throws InterruptedException {
		// 定义chromedriver的安装目录
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//设置浏览器最大化显示
		driver.manage().window().maximize(); 
		//get方法得到url地址
		//driver.get("http://www.imooc.com/oms");    
		//定义url变量
		String web_url = "http://www.imooc.com/oms";
		String quest_url ="http://www.imooc.com/oms/question/tlist";
         driver.get(web_url);
		//等待2秒，为看到效果
		Thread.sleep(2000);
		//通过email元素定位username
        WebElement username = driver.findElement(By.id("email"));
       //输入框输入username参数
        username.sendKeys("admin@imooc.com");
    	//通过pass元素定位password
        WebElement password = driver.findElement(By.id("pass"));
        //输入passwod
        password.sendKeys("111111");
        //执行button的click方法
        driver.findElement(By.className("btn")).click();
        //等待2秒
        Thread.sleep(2000);
        driver.get(quest_url);
        //findElemensearch_nickname
        WebElement search_nickname = driver.findElement(By.id("q_nickname"));
        // 输入搜索参数：Eric
        search_nickname.sendKeys("Eric");
        //执行classname元素的click方法
       driver.findElement(By.className("btnbtnDarksearch")).click();
       //logout
       Thread.sleep(3000);
       //close browser
       driver.quit();
       //driver.close();
       
	}
}

