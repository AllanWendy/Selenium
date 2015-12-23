package GlobalMethod;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenByChBrower {
	public  WebDriver driver = null;
	private String ChromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

	public static WebDriver getchWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	   //new 创建一个driver 对象
		WebDriver driver = new ChromeDriver();
		return driver;
	 
 }
	
	//初始化方法
	public void init()	{
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		//driver = new ChromeDriver();
	
	}

	// 设置退出浏览器方法
	 public void quitDrvier()  
    {  
           if ( null != driver)  
           	
          {  
                  driver.quit();  
         }   
           
}  
	 
	// 设置进程等待方法，目前等待1秒
	public static void waitForSecond(){

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}
	
	// 设置打开imooc操作执行方法
	public void open(){
	
		// driver.navigate().to(loginurl);
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com");
		//浏览器最大化
		driver.manage().window().maximize(); 
	
	}
	
	
    @Test
	public  void OpenByChBrower() throws InterruptedException{

    	OpenByChBrower openByChBrower = new OpenByChBrower();
    	openByChBrower.init();
    	openByChBrower.open();	

	}

}