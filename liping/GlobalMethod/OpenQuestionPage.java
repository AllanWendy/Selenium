package GlobalMethod;
import org.junit.Test;
//import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenQuestionPage 
{
	//定义需要用到的各种全局变量
 public String url="http://www.imooc.com";
 public String email="jiangsf@mukewang.com";
 public String pwd="111111";
 public WebDriver driver=null;
 public String ChromeDriverPath="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
 public String key="webdriver.chrome.driver";
//public ChromeDriver driver =new ChromeDriver();
 
 	public void init()
 	{
 		System.setProperty(key, ChromeDriverPath);
 	}
 	//定义休眠时长方法--2秒
 	public void waitForTimeTwo()
 	{
 		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 	}
 	//定义休眠时长方法--10秒 --为了看到不同效果，在不同页面调用不同的休眠时长方法
	public void waitForTimeTen()
 	{
 		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 	}
 	public Dimension Dimensions(int i, int j) 
 	{
		return new Dimension(i, j);
	}
 	public void login()
 	{
 		/*String url="http://www.imooc.com";
 		String email="jiangsf@mukewang.com";*/
 		//获取网站url
 		driver  = new ChromeDriver();
 		driver.manage().window().setSize(Dimensions(1180,1180));
 		
 		Window win = driver.manage().window();
 		if(win != null){
 			win.setSize(new Dimension(1180,1180));
 		}
 		
 		driver.navigate().to(url);
 		//获取当前网页title
 		System.out.println("当前页 Title为："+driver.getTitle());
 		waitForTimeTwo();
 		WebElement element_login =driver.findElement(By.id("J_Login"));
 		//WebElement element_login = driver.findElement(By.xpath("//button[@class='login-btn']"));
 		element_login.click();
 		waitForTimeTwo();
 		//WebElement text = driver.findElement(By.xpath("//input[@class='js-keyword']"));
 		WebElement element_mail =driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-email']"));
 		element_mail.sendKeys(email);
 		WebElement element_pwd =driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-pwd']"));
 		element_pwd.sendKeys(pwd);
 		waitForTimeTwo();
 		driver.findElement(By.id("signin-btn")).click();
 		waitForTimeTwo();
 	}
 	
 	public void comeWenDa()
 	{
 		/*如果不登录直接进入问答，就可以打开这段注释，同时将login方法注释掉
 		 * driver  = new ChromeDriver();
 		String url="http://www.imooc.com";
 		waitForTime();
 		driver.navigate().to(url);
 		driver.manage().window().setSize(Dimensions(1180,1180));
 		Window win = driver.manage().window();
 		if(win != null){
 			win.setSize(new Dimension(1180,1180));
 		}*/
 		//进入问答列表
 		driver.findElement(By.xpath("//a[@href='/wenda']")).click();
 		//获取当前网页title
 		System.out.println("当前页 Title为："+driver.getTitle());
 		waitForTimeTwo();
 	}

 	public void quitDriver()
 	{
 		if (driver !=null)
 		{
 			driver.close();
 		}
 	}
@Test
	public void openQuestionPage()throws InterruptedException
 	{
		OpenQuestionPage openQuestionPage = new OpenQuestionPage();
 		openQuestionPage.init();
 		openQuestionPage.login();
 		openQuestionPage.comeWenDa();
 		waitForTimeTen();
 		openQuestionPage.quitDriver();
 	}
 	
}
