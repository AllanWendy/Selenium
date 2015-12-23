import org.testng.annotations.Test;
import java.awt.List;
    
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.jna.platform.mac.Carbon.EventHotKeyID.ByValue;
public class RealseQuestion {
	@Test
	/*变量命名规则：变量名首字母必须为字母(a-z A-Z)，下划线(_)，或者美元符号($)开始，php编程中所有变量必须以$开始*/
	public void realseQuestion() throws InterruptedException{
		//定义浏览器安装目录
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		//定义对象
		WebDriver driver =new ChromeDriver();
		//使窗口最大化
		driver.manage().window().maximize();
		//定义网站url
	/*	String url="http://www.imooc.com";
		driver.getCurrentUrl();
		//输出当前url
		System.out.println("1 网站url为："+url);
        //使用navigate方法获取网站url
     	driver.navigate().to(url);
			 * */
		driver.get("http://www.imooc.com");
		//停留2秒,1秒=1000毫秒
		Thread.sleep(2000);
		//未登录时跳转至问答页，通过xpaht方法获取问答链接
		WebElement quesLink = driver.findElement(By.xpath("//a[@ href='/wenda']"));
		quesLink.click();
		/*	点击发布按钮*/
	/*	方法一
	 * WebElement newque =driver.findElement(By.id("js-newques"));
		newque.click();*/
		//方法二
		driver.findElement(By.id("js-newques")).click();
		Thread.sleep(3000);
		//*如果是未登录，系统自动先弹出登录窗口
		//下面这句有不有都没关系		
		String currentWin = driver.getWindowHandle();  
	    //在输入框中输入邮箱
		WebElement email = driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-email']"));
		email.sendKeys("415890978@qq.com");
		//在输入框中输入密码
		WebElement  passWord= driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-pwd']"));
		passWord.sendKeys("123456");
		Thread.sleep(800);
		//找到登录按钮并进行点击操作
		//WebElement goBtn =driver.findElement(By.id("signin-btn")).click();
		driver.findElement(By.id("signin-btn")).click();
		Thread.sleep(2500);
		String curUrl =driver.getCurrentUrl();
		// 登录后需再次点发布按钮
		driver.findElement(By.id("js-newques")).click();
		Thread.sleep(1500);
		String currentUrl=driver.getCurrentUrl();
		String currentTitle=driver.getTitle();
		//在控制台打印出当前页的url和标题
	    System.out.println("2进入发问题页面的url:"+currentUrl+"标题为:"+currentTitle);
	    //选择发布的问答类型 data-type等于1时为技术问答，data-type等于4时为技术分享
	    WebElement dataType =driver.findElement(By.xpath("//a[@data-type='4']"));
	    dataType.click();
	    //输入标题
		WebElement title = driver.findElement(By.id("ques-title"));
		title.sendKeys("技术分享--标题--自动化测试11");
		/*输入内容,由于内容中使用了frame框架，所以需要切到frame
		关于切换，请参照如下网址：http://shijincheng0223.iteye.com/blog/1481446
		 */		
		driver.switchTo().frame("ueditor_0");
		WebElement  content= driver.findElement(By.xpath("//body[@class='view']"));
		content.sendKeys("技术分享--内容--自动化测试11");
		Thread.sleep(1500);
		//填写内容后需要从frame跳出，所以再用switchTo切出来，不然没法提交
		driver.switchTo().defaultContent();
		WebElement queBtn =driver.findElement(By.id("ques-submit-btn"));
		queBtn.click();
		Thread.sleep(3000);
		//发布成功后跳转的页面url和标题显示
		String url =driver.getCurrentUrl();
		System.out.println("发布成功后跳转的页面地址为"+url+"标题为："+driver.getTitle());
		/*跳转至问答列表页
		driver.findElement(By.xpath("//a[@href='/wenda']")).click();
		System.out.println("发布成功后的问答地址"+driver.getCurrentUrl());*/
		//成功后，查看我发布的问题
		driver.findElement(By.xpath("//a[@class='myques']")).click();
		System.out.println("发布成功后查看发布的问题url地址为："+driver.getCurrentUrl());
		Thread.sleep(12000);   //停留6秒
		driver.quit();
	}

}
