package GlobalMethod;

//package GlobalMethod.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCourseListByBtn2 {
	
	// 设置ChromeDriverServer的路径，根据你具体存放位置来设置路径
	public  WebDriver driver = null;
	private String ChromeDriverPath = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";
	// 设置loginurl登录地址
	private String loginurl = "http://www.imooc.com";
	
	public static WebDriver getchWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	   //创建一个driver 对象
		WebDriver driver = new ChromeDriver();
		return driver;
	 
}
	
	//初始化方法
	public void init()	{
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	
	}

	// 设置退出浏览器方法
	 public void quitDrvier()  
   {  
          if ( null != driver)  
          	
         {  
                 driver.quit();  
        }   
          
}  
	 
	// 设置进程等待方法，目前等待3秒
	public void waitForSecond(){

		try {

			Thread.sleep(3000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	// 设置登录操作执行方法
	public void login(){
	
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com");
		//将浏览器的大小自定义为1000*1000
		driver.manage().window().setSize(new Dimension(1000, 1000)); 
		waitForSecond(); // 执行进程等待方法
		
		driver.findElement(By.xpath("//*[@id='enterbtn-large']")).click(); //通过xpath 定位到慕课官网上的  课程按钮
		waitForSecond();
		
		String currentWindow = driver.getWindowHandle(); //定义当前窗口
		waitForSecond(); // 执行进程等待方法
		
	}

	@Test
	public  void OpenCourseListByBtn2() throws InterruptedException{

		OpenCourseListByBtn2 openCourseListByBtnn = new OpenCourseListByBtn2();
		openCourseListByBtnn.init();
		openCourseListByBtnn.login();	

	}

}

