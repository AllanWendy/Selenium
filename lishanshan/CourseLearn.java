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

import GlobalMethod.CourseStudy;

public class CourseLearn {
	public  WebDriver driver = null;
	private String ChromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	
	public static WebDriver getchWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	   //new 创建一个driver 对象
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	@Test
	public  void globalImportTest() throws InterruptedException {
		
    CourseStudy courseStudy = new CourseStudy();
    //调用CourseStudy中init方法
	courseStudy.init();
	//调用CourseStudy中open方法
	courseStudy.open();
	//调用CourseStudy中study方法
	courseStudy.study();
	//调用CourseStudy中login方法
	courseStudy.login();
	
	//通过xpath找到体验学习按钮
	WebElement learn = driver.findElement(By.xpath("//a[@href='/learn/153']"));
    learn.click();
    //通过id找到开始学习按钮
    WebElement start = driver.findElement(By.id("start-btn"));
    start.click();
    
	}
}