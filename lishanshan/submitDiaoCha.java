import GlobalMethod.*;
import java.io.File;
import java.io.IOException;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class submitDiaoCha {
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
		
		// 打开imooc调查
		driver.get("http://www.imooc.com/activity/diaocha");
		// 打开imooc
		// driver.navigate().to("http://www.imooc.com/activity/diaocha");

		// 获取 网页的 title
		System.out.println("1 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 

		//driver.findElement(By.xpath("//input[@id='username' and @name='userID']"));
		
		//定位到iframe
		WebElement iFrame =driver.findElement(By.xpath(".//*[@id='main']/div/iframe"));
		//在fiame中定位元素
		driver.switchTo().frame(iFrame);
		//定位到第一题第一个选项    
    	WebElement option1 =  driver.findElement(By.xpath("//input[@id='q1_1']"));
    	option1.click();
        Thread.sleep(1000);
        //定位到第二题第一个选项    
		WebElement option2 = driver.findElement(By.xpath("//input[@id='q2_1']"));
		option2.click();
		Thread.sleep(1000);
        //定位到第三题第一个选项   
		WebElement option3 = driver.findElement(By.xpath("//input[@id='q3_1']"));
		option3.click();
		Thread.sleep(1000);
        //定位到第四题第一个选项   
		WebElement option4 = driver.findElement(By.xpath("//input[@id='q4_1']"));
		option4.click();
		Thread.sleep(1000);
        //定位到第五题第一个选项    
		WebElement option5 = driver.findElement(By.xpath("//input[@id='q5_1']"));
		option5.click();
		Thread.sleep(1000);
		//定位到第六题第一个选项   
		WebElement option6 = driver.findElement(By.xpath("//input[@id='q6_1']"));
		option6.click();
		Thread.sleep(1000);
		//定位到第七题第一个选项   
		WebElement option7 = driver.findElement(By.xpath("//input[@id='q7_1']"));
		option7.click();
		Thread.sleep(1000);
		//定位到第八题第一个选项   
		WebElement option8 = driver.findElement(By.xpath("//input[@id='q8_1']"));
		option8.click();
		Thread.sleep(1000);
		//定位到第九题第一个选项   
		WebElement option9 = driver.findElement(By.xpath("//input[@id='q9_1']"));
		option9.click();
		Thread.sleep(1000);
		//定位到第十题第一个选项   
		WebElement option10 = driver.findElement(By.xpath("//input[@id='q10_1']"));
		option10.click();
		Thread.sleep(1000);
		//定位到第十一题第一个选项   
		WebElement option11 = driver.findElement(By.xpath("//input[@id='q11_1']"));
		option11.click();
		Thread.sleep(1000);
		//确定提交按钮
		WebElement submit = driver.findElement(By.id("submit_button"));
		submit.click();
		// 获取 网页的 title
		System.out.println("5 Page title is: " + driver.getTitle());
		Thread.sleep(3000); 		
		// 退出浏览器
		driver.quit();
		
	}

}