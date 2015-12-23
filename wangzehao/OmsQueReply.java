import java.io.File;  
import org.junit.Test;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.firefox.FirefoxBinary;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.htmlunit.HtmlUnitDriver;  
import org.openqa.selenium.ie.InternetExplorerDriver;  
  
public class OmsQueReply

{   
        // 设置IEDriverServer的路径，根据你具体存放位置来设置路径  
        private WebDriver driver = null;  
        private String ChromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
        //设置loginurl登录地址
        private String loginurl = "http://www.imooc.com/oms";
        //设置问答管理访问入口
        private String queurl = "http://www.imooc.com/oms/question/tlist";
        //设置单击某个问答，对应链接地址
        private String replyurl= "http://www.imooc.com/oms/question/answerlist/id/4343?t=t&channel=1";
        //设置登录用户username和password参数信息
        private String username = "admin@imooc.com";
        private String password = "111111";
  
   //设置初始化方法
   public void init()

   {
   
     System.setProperty( "webdriver.chrome.driver", ChromePath );
            driver = new ChromeDriver();  
               
   }

    //设置退出浏览器方法
    public void quitBrower()

    {

      if ( null != driver)  
             {  
                  //driver.quit();
                   driver.close();  
            }   

    }

    //设置进程等待方法，目前等待3秒
    public void waitForSecond()

    {

      try
      {
        
    	  Thread.sleep(3000);

      }catch (InterruptedException e)

      {
        e.printStackTrace();    
      }
    
    }

    //设置登录操作执行方法
    public void login()

    {
       //打开后台oms登录主页面
       driver.navigate().to(loginurl);
       //浏览器窗口最大化，方便查看结果
       driver.manage().window().maximize();
       //执行进程等待方法
       waitForSecond();
       //通过email元素定位username输入框
       WebElement element_uname = driver.findElement(By.id("email"));
       //执行进程等待方法
       waitForSecond();
       //输入框输入username参数
       element_uname.sendKeys(username); 
       //执行进程等待方法
       waitForSecond();
       //通过pass元素定位password
       WebElement element_password = driver.findElement(By.id("pass")); 
       //输入passwod参数
       element_password.sendKeys(password); 
       //执行进程等待方法
       waitForSecond();
       //执行button的click方法，执行登录操作
       driver.findElement(By.className("btn")).click(); 

     }

    //切换至问答管理页面，回复问答
     public void switchque()
    
     {
       //定位queurl地址
       driver.get(queurl);
       //执行进程等待方法
       waitForSecond();
       //定位replyurl地址
       driver.navigate().to(replyurl);
     //执行进程等待方法
       waitForSecond();
       //通过xpath匹配定位回复输入框
       WebElement reply_text = driver.findElement(By.xpath("//textarea[@class='replyVal']"));
       //调用sendkeys方法输入回复内容
       reply_text.sendKeys("问答管理自动化测试回复");
     //执行进程等待方法
       waitForSecond();
       //通过xpath匹配定位回复按钮
       WebElement reply_button = driver.findElement(By.xpath("//a[@name='rplyArea']"));
      //执行进程等待方法
       waitForSecond();
     //调用click方法实现单机提交
       reply_button.click();
     //执行进程等待方法
       waitForSecond();
     }
      
    public void execute()

    {
      //执行初始化方法
      init();
      //执行后台oms登录
      login();
      //执行回复问答方法
      switchque();
      //执行退出浏览器方法
      //quitBrower();
    }
    
   @Test
       public void omsQueReply() throws InterruptedException 

       {  

        OmsQueReply quesReply = new OmsQueReply();  
              quesReply.execute();  
              
      }  

}  
