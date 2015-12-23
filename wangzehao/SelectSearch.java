import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class SelectSearch {
	// 设置IEDriverServer的路径，根据你具体存放位置来设置路径
	private WebDriver driver = null;
	private String ChromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	// 设置loginurl登录地址
	private String loginurl = "http://www.imooc.com/oms";
	// 设置问答管理访问入口
	private String questionurl = "http://www.imooc.com/oms/question/tlist";
	// 设置登录用户username
	private String username = "admin@imooc.com";
	// 设置登录用户的访问密码
	private String password = "111111";

	// 设置初始化方法
	public void init()	{
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
	
	}

	// 设置退出浏览器方法
	public void quitBrower(){

		if (null != driver) {
			driver.quit();
			// driver.close();
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
	public void loginoms(){
		// 打开后台oms登录主页面
		// driver.navigate().to(loginurl);
		driver.get(loginurl);
		// 最大化浏览器窗口
		// driver.manage().window().maximize();
		// 执行进程等待方法
		waitForSecond();
		// 通过email元素定位username输入框
		WebElement element_uname = driver.findElement(By.id("email"));
		// 执行进程等待方法
		waitForSecond();
		// 输入框输入username参数
		element_uname.sendKeys(username);
		// 执行进程等待方法
		waitForSecond();
		// 通过pass元素定位password
		WebElement element_password = driver.findElement(By.id("pass"));
		// 输入passwod参数
		element_password.sendKeys(password);
		// 执行进程等待方法
		waitForSecond();
		// 执行button的click方法，执行登录操作
		driver.findElement(By.className("btn")).click();

	}

	// 切换至问答管理页面搜索（按问答，输入搜索条件：问答管理自动化测试回复）
	public void selector(){
		
		// 定位question地址
		driver.get(questionurl);
		// 最大化浏览器窗口
		// driver.manage().window().maximize();
		// 执行进程等待方法
		waitForSecond();
		// 通过id定位栏目下拉选择框
		Select programselect = new Select(driver.findElement(By.id("channel")));
		// 选择按活动建议进行匹配
		programselect.selectByVisibleText("技术分享");
		// 执行进程等待方法
		waitForSecond();
		// 通过id定位问题下拉选择框
		Select keywordselect = new Select(driver.findElement(By.id("wordtype")));
		// 选择按问题进行搜索
		keywordselect.selectByVisibleText("按问题");
		// 执行进程等待方法
		waitForSecond();
		// 通过xpath匹配定位关键字输入框
		WebElement searchInput = driver.findElement(By
				.xpath("//input[@class='search-text']"));
		// 执行进程等待方法
		waitForSecond();
		// 输入框输入搜索关键字
		searchInput.sendKeys("自动化关键字搜索测试");
		// 通过xpath匹配搜索按钮
		WebElement searchbtn = driver.findElement(By
			.xpath("//input[@class='btnbtnDarksearch']"));
		// 执行进程等待方法
		waitForSecond();
		// 单击搜索按钮
		searchbtn.click();

	}

	public void ShotScreen()	{
		
		// 页面进行截图并保存在D盘下，文件名:test.png
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(screenShotFile, new File("D:/test.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	public void execute()	{
		
		// 执行初始化方法
		init();
		// 执行后台oms登录
		loginoms();
		// 执行选择下拉列表，搜  索关键字方法
		selector();
		// 执行退出浏览器方法
		// quitBrower();
		// 执行屏幕截图方法
		ShotScreen();
	}

	@Test
	public void selectSearch() throws InterruptedException{

		SelectSearch selectSearch = new SelectSearch();
		selectSearch.execute();

	}

}
