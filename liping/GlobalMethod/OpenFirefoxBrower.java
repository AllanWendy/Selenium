package GlobalMethod;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefoxBrower {
	 // 设置WebDriver的变量，根据你具体存放位置来设置路径
	public  WebDriver driver = null;
	//1&2 如果下面的1&2未被注释，就定义这句 
	//public String url="http://www.imooc.com";
   //下面这两句先定义变量值，然后在System.setProperty中调用
	public String key="webdriver.firxfox.bin";
	public String FireFoxPath = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
/*	
 * qqq
 * private Dimension Dimension() 
	{
		int i1=1180;
		int j1=1180;

	// TODO Auto-generated method stub
	return null;
	}*/
   //初始方法，设置chromedriver的安装路径	 static
    public   WebDriver openFirefoxBrower() throws InterruptedException
    {
    	System.setProperty(key, FireFoxPath);
    	//下面这句改为新实例化对象，在关闭方法中变得不到 WebDriver driver  = new ChromeDriver();
    	driver  = new FirefoxDriver();
    	//driver.manage().window().maximize();
    	// 备注AA  如果不用下面这句，则在类CallChrome的方法中调用注释掉的备注AA
    	//1&2 driver.navigate().to(url);
    	//设置窗口大小 
    		driver.manage().window().setSize(new Dimension(1260,1260));
    		// qqq ****driver.manage().window().setSize(Dimension());
    		return driver;
	
 	}
	public void waitForTime()
	{
		try{
			Thread.sleep(4000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
// 设置退出浏览器方法
	public void quitDrvier()  
    	{  
		if ( driver != null)  
       	
       		{  
              	driver.quit();  
       		}   
    	}
}
