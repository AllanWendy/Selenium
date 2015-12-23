package GlobalMethod;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalMethod {
	
	// 设置IEDriverServer的路径，根据你具体存放位置来设置路径
	public static  WebDriver driver = null;	
	public static String key="webdriver.chrome.driver";
	private static String ChromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	// 设置loginurl登录地址
	private static String loginurl = "http://www.imooc.com/oms";
	//设置意见反馈地址
	private static String fback ="http://www.imooc.com/user/feedback";
	//设置oms课程列表页url地址
	private static String courselist="http://www.imooc.com/oms/course/totallist";
	//设置oms课程讨论页url地址
	private static String queslist="http://www.imooc.com/oms/question/tlist";
	// 设置登录用户username
	private static String username = "admin@imooc.com";
            private  static String email="wenyu757123@163.com";
	// 设置登录用户的访问密码
	private  static String password = "222222";
	
	/** 
     *  打开chrome浏览器，窗口重新设置1000*1000
	 * @author LiPing
	 * @date 2014/08/04
	 */	
	public static void openChromeBrower(){
	
	    	System.setProperty(key, ChromeDriverPath);
	    	//下面这句改为新实例化对象，在关闭方法中变得不到 WebDriver driver  = new ChromeDriver();
	    	driver  = new ChromeDriver();
	    	//设置浏览器大小为:1000*1000
	    	driver.manage().window().setSize(new Dimension (1000,1000));
	    	//driver.manage().window().maximize();
	        return;
		
	 	}
		
	public static WebDriver getChWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	   //new 创建一个driver 对象
	   WebDriver driver = new ChromeDriver();
		return driver;

 }
	
	//初始化方法
	public static void init(){
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		//driver = new ChromeDriver();
	
	}

	/** 
     *  打开chrome浏览器，访问imooc首页
	 * @author Lishanshan
	 * @date 2014/08/04
	 */
	public static void openByChBrower(){
		//定位打开慕课网首页面
		driver.get("http://www.imooc.com");
	    //调用等待方法
		waitForSecond();
	}
	
	/** 
     *  打开imooc登录主窗口页面
	 * @author Ganxiaofeng
	 * @date 2014/08/04
	 */
	public static void openLoginPage(){
		
		driver.get("http://www.imooc.com");
		// 设置3秒超时等待  
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
		 //超时
		 WebDriverWait wait = new WebDriverWait(driver,5);
		 wait.until(new ExpectedCondition<WebElement>(){
			 @Override
			 public WebElement apply(WebDriver d) {
			 return d.findElement(By.xpath("//a[@id='js-header-login']"));
			 }}).click();
			 //dr.findElement(By.id("b")).click();
 		//WebElement login = driver.findElement(By.xpath("//a[@id='js-header-login']"));
		//waitForSecond();
       
	}
	
	/** 
     *  打开imooc课程列表主页面
	 * @author Ganxiaofeng
	 * @date 2014/08/04
	 */
	public  static void openCourseList(){
		
		//调用openByChBrower方法
		openByChBrower();
		// 执行进程等待方法
		waitForSecond(); 
	   //通过xpath 定位到慕课官网上的 课程按钮,执行单击打开方法
		driver.get("http://www.imooc.com/course/list");
		waitForSecond();
		
	}
	
	/** 
     *  通过邮箱登录imooc前端方法
	 * @author LiPing   
	 * 
	 * 
	 * @date 2014/08/04
	 */
	public static void loginByEmail()
 	{
		
 		waitForSecond();
 		//WebElement text = driver.findElement(By.xpath("//input[@class='js-keyword']"));
 		//WebElement element_mail =driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-email']"));
 		WebElement element_mail =driver.findElement(By.xpath("//input[@name='email']"));
 		element_mail.sendKeys(email);
 		WebElement element_pwd =driver.findElement(By.xpath("//input[@class='rlf-input rlf-input-pwd']"));
 		element_pwd.sendKeys(password);
 		waitForSecond();
 		driver.findElement(By.id("signin-btn")).click();
 		waitForSecond();
 		
 	}
 	
	/** 
     *  课程讨论分享跳转方法
	 * @author LiPing
	 * @date 2014/08/04
	 */
	//跳转到课程讨论
	public static void openCourseQues(){
		
		driver.navigate().to("http://www.imooc.com/wenda");
		//WebElement course_tab=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/2']"));
		WebElement course_tab=driver.findElement(By.linkText("课程讨论"));
		course_tab.click();
		System.out.println("跳转到课程讨论的Title为："+driver.getTitle());
		waitForSecond();
		
	}
	
	//跳转到技术问答
	public static void openTechQues(){
		
		driver.navigate().to("http://www.imooc.com/wenda");
		//WebElement tech_wd=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/1']"));
		WebElement tech_wd=driver.findElement(By.linkText("技术问答"));
		tech_wd.click();
		System.out.println("跳转到技术问答的Title为："+driver.getTitle());
		waitForSecond();
	}
	
	//跳转到技术分享
	public  static void openTechShare(){
		
		driver.navigate().to("http://www.imooc.com/wenda");
		//WebElement tech_share=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/4']"));
		WebElement tech_share=driver.findElement(By.linkText("技术分享"));
		tech_share.click();
		System.out.println("跳转到技术分享的Title为："+driver.getTitle());
		waitForSecond();
		
	}
	
	//跳转到活动建议
	public static  void openSuggestion(){
		
		driver.navigate().to("http://www.imooc.com/wenda");
		//WebElement suggestion=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/3']"));
		WebElement suggestion=driver.findElement(By.linkText("活动建议"));
		suggestion.click();
		System.out.println("跳转到活动建议 的Title为："+driver.getTitle());
		waitForSecond();
	}
	
	//跳转到全部问答
	public  static void openAllQues(){
		
		driver.navigate().to("http://www.imooc.com/wenda");
		//WebElement all=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/0']"));
		WebElement all=driver.findElement(By.linkText("全部问答"));
		all.click();
		System.out.println("跳转到全部问答的Title为："+driver.getTitle());
		waitForSecond();
		
	}
	
	/** 
	*  打开课程列表页，定位至course_id=342的课程
	 * @author Lishanshan
	 * @date 2014/08/04
	 */	
	public static  void openCourseStudy(){
		
		// 通过xpath定位页面元素 
		WebElement course = driver.findElement(By.xpath("//a[@href='/course/list']"));
		course.click();
	    
	    // 获取 网页的 title
	    System.out.println("2 Page title is: " + driver.getTitle());
	    waitForSecond();
	    
	    //进入某一课程
		WebElement view = driver.findElement(By.xpath("//a[@href='/view/342']"));
	    view.click();
	    
	    System.out.println("3 Page title is: " + driver.getTitle());
	    waitForSecond();
	
	}
	
	// 设置退出浏览器方法
	 public static  void quitDrvier() {
		 
            if ( null != driver)  
            	
           {  
                   driver.quit();  
          }   
            
 }  
	 
	 /** 
	     *  页面等待方法，默认3秒钟
		 * @author LiPing
		 * @date 2014/08/04
		 */
	public  static void waitForSecond(){

		try {

			Thread.sleep(3000);

		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}

	/** 
     *  登录后台oms方法(已屏蔽验证码输入框)
	 * @author wangzehao
	 * @date 2014/08/04
	 */
	public  static  void loginoms(){
		
		driver.navigate().to(loginurl);
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

	/** 
     *创建单个下拉选择列表框实现方法
	 * @author wangzehao
	 * @date 2014/08/04
	 */
	public static void selectSingle(){
		    driver.get(queslist);
			// 通过id定位栏目下拉选择框
			Select programselect = new Select(driver.findElement(By.id("channel")));			
			// 选择按活动建议进行匹配
			programselect.selectByVisibleText("技术分享");			
			// 调用LoginByEmail类中的waitForSecond()方法
			waitForSecond();
			// 通过id定位问题下拉选择框
			Select keywordselect = new Select(driver.findElement(By.id("wordtype")));
			// 选择按问题进行搜索
			keywordselect.selectByVisibleText("按问题");
			// 调用LoginByEmail类中的waitForSecond()方法
			GlobalMethod.waitForSecond();
			// 通过xpath匹配定位关键字输入框
			WebElement searchInput = driver.findElement(By.xpath("//input[@class='search-text']"));
			// 执行进程等待方法
			GlobalMethod.waitForSecond();
			// 输入框输入搜索关键字
			searchInput.sendKeys("自动化关键字搜索测试");
			// 通过xpath匹配搜索按钮
			WebElement searchbtn = driver.findElement(By.xpath("//input[@class='btnbtnDarksearch']"));
			// 执行进程等待方法
			GlobalMethod.waitForSecond();
			//waitForSecond();
			// 单击搜索按钮
			searchbtn.click();

		}
	
	/** 
     *  创建多个下拉选择列表框实现方法
	 * @author wangzehao
	 * @date 2014/08/04
	 */
	public static void selectDouble(){
		
		driver.get(courselist);
		waitForSecond();
		// 通过id定位栏目下拉选择框
		Select programselect = new Select(driver.findElement(By.id("companyid")));
		// 选择按活动建议进行匹配
		programselect.selectByVisibleText("慕课网");
		// 执行进程等待方法
		waitForSecond();
		
		Select status = new Select(driver.findElement(By.id("status")));
		// 选择按活动建议进行匹配
		programselect.selectByVisibleText("已下架");
		// 执行进程等待方法
		waitForSecond();
		
		// 通过id定位问题下拉选择框
		Select selectsingle = new Select(driver.findElement(By.id("pcatid")));
		// 选择按问题进行搜索
		selectsingle.selectByVisibleText("web开发");
		waitForSecond();
		
		// 通过id定位问题下拉选择框
		Select selectdouble = new Select(driver.findElement(By.id("catid")));
		// 选择按问题进行搜索
		selectdouble.selectByVisibleText("web开发二级分类");	
		// 执行进程等待方法
		waitForSecond();
		
		// 通过xpath匹配定位关键字输入框
		WebElement searchinput = driver.findElement(By.xpath("//input[@id='name']"));
		// 执行进程等待方法
		waitForSecond();
		// 输入框输入搜索关键字
		searchinput.sendKeys("oms");
		// 通过xpath匹配搜索按钮
		WebElement searchbtn = driver.findElement(By.xpath("//input[@class='btn btnDark search']"));
		// 执行进程等待方法
		waitForSecond();
		// 单击搜索按钮
		searchbtn.click();

	}

	/** 
     *  创建关键字输入框实现方法
	 * @author wangzehao
	 * @date 2014/08/04
	 */
	public static void keywordInput(){
		
		driver.get(courselist);
		waitForSecond();
		// 通过xpath匹配定位关键字输入框
		WebElement searchInput = driver.findElement(By	.xpath("//input[@id='name']"));
		// 执行进程等待方法
		waitForSecond();
		// 输入框输入搜索关键字
		searchInput.sendKeys("oms");
		// 通过xpath匹配搜索按钮
		WebElement searchbtn = driver.findElement(By.xpath("//input[@class='btnbtnDarksearch']"));
		// 执行进程等待方法
		waitForSecond();
		// 单击搜索按钮
		searchbtn.click();

	}
	
	/** 
     *  创建昵称输入框输入实现方法
	 * @author wangzehao
	 * @date 2014/08/04
	 */
	public static void nicknameInput(){
		driver.get(queslist);
		waitForSecond();
		// 通过xpath匹配定位关键字输入框
		WebElement nickname = driver.findElement(By.xpath("//input[@class='search-nickname']"));
		// 执行进程等待方法
		waitForSecond();
		// 输入框输入搜索关键字
		nickname.sendKeys("悲伤逆流成河");
		// 通过xpath匹配搜索按钮
		WebElement searchbtn = driver.findElement(By.xpath("//input[@class='btnbtnDarksearch']"));
		// 执行进程等待方法
		waitForSecond();
		// 单击搜索按钮
		searchbtn.click();

	}
	
	/** 
     *	创建意见反馈提交方法
	 * @author wangzehao
	 * @date 2014/08/08
	 */
	public static void submitFback(){
		
       driver.navigate().to(fback);
	   WebElement textarea = driver.findElement(By.id("info"));
	   //driver.findElement(By.xpath(".//*[@id='info']")).sendKeys("12345");
	   //输入用户的意见反馈信息
	   textarea.sendKeys("autotest自动化测试测试");
	   //定位用户的联系方法页面元素，通过name
	   WebElement contact = driver.findElement(By.name("contact"));
	   //输入用户联系方法信息
	   contact.sendKeys("QQ:3654784512");
	   //为了看得效果，等待3秒钟
	   waitForSecond();
	   //执行提交操作
	   driver.findElement(By.id("submit")).click();
	}
	
	/** 
     *	创建屏幕截图实现方法
	 * @author wangzehao
	 * @date 2014/08/04
	 */
public static void takeScreenshot(){
		
		// 截图并保存在D盘下，文件名:test.png
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {

			FileUtils.copyFile(screenShotFile, new File("D:/test.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public  void GlobalMethod() throws InterruptedException{

		GlobalMethod method = new GlobalMethod();

	}

}
