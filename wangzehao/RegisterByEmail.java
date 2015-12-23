import java.awt.List;

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

public class RegisterByEmail {
   @Test
	public  void registerByEmail() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		//new 创建对象
		WebDriver dr = new ChromeDriver();
		//设置浏览器窗口最大化
	   dr.manage().window().maximize();
	   String web_url = "http://www.imooc.com";
	   //to方法打开url地址
	   dr.navigate().to(web_url);
	   //通过id找到登录按钮，调用click方法
	   dr.findElement(By.id("J_Login")).click();
	   Thread.sleep(5000);
	   String currentWindow = dr.getWindowHandle();
      //WebElement register =  dr.findElement(By.xpath("//input[@id='go-signup-btn']/"));
      //WebElement register =  dr.findElement(By.xpath("//input[@class='rlf-btn-blue l']"));
	  //跳转至立即注册主页面
     WebElement reg_button = dr.findElement(By.id("go-signup-btn"));
	   reg_button.click();
	   //等待5秒
	   Thread.sleep(5000);
	   //xpath匹配到email输入框
	 WebElement reg_mail = dr.findElement(By.xpath("//input[@class='rlf-input rlf-input-email']"));
	 //输入邮箱用户名信息
	 reg_mail.sendKeys("username@163.com");
	 //xpath匹配到passwordl输入框
	 WebElement reg_passwd = dr.findElement(By.xpath("//input[@class='rlf-input rlf-input-pwd']"));
	 //输入邮箱密码信息
     reg_passwd.sendKeys("password");
     //xpath匹配到昵称输入框
	 WebElement reg_nickname = dr.findElement(By.xpath("//input[@class='rlf-input rlf-input-nick']"));
	 //输入用户昵称信息
     reg_nickname.sendKeys("automate");
	   Thread.sleep(5000);
	   //定位注册按钮，通过xpath
	 WebElement reg_signbtn = dr.findElement(By.xpath("//input[@id='signup-btn']"));
	 //调用按钮的click方法，执行注册操作
     reg_signbtn.click();
	   
     

     }
}