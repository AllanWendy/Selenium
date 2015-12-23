import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.chrome.ChromeDriver;  
import org.junit.Test;
/** 
* 借助 selenium，启动 chrome浏览器，并登录QQ邮箱的过程 
**/  
public class LoginQQMail  
{       
      
       private String webBrowserPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";   // 浏览器程序的路径  
       private WebDriver driver = null;  
       private String loginUrl = "https://mail.qq.com/cgi-bin/loginpage" ;// QQ邮箱的登录页  
       private String username = "10000"; // QQ帐号  
       private String password = "hellword"; // QQ密码  
 
       // 初始化 selenium要调用的浏览器并启动  
       public void init()  
       {  
             //webBrowserPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe" ;  
             System.setProperty( "webdriver.chrome.driver", webBrowserPath );  
             driver = new ChromeDriver();  
             
     }  
       // 关闭浏览器  
       public void quitDrvier()  
       {  
              if ( null != driver)  
             {  
                     driver.quit();  
            }   
   }  
       //等待4秒钟
       public void waitForSecond()  
        {  
            try  
            {  
                   Thread. sleep(4000);  
             }  
              catch (InterruptedException e)  
           {  
                    e.printStackTrace();  
             }  
    }  
  
      // 模拟登录过程  
       public void Login()  
       {  
              driver.navigate().to(loginUrl); // 进入QQ登录页  
              driver.switchTo().frame("login_frame"); //进入frame
              WebElement element_u = driver .findElement(By.id( "u" ));// 找到id名为 uin的dom 元素  
              //WebElement element = driver.findElement(By.xpath("//input[@class='inputstyle']"));
              element_u.sendKeys(username);// 当前element为 uin输入框，将用户名填到这个输入框  
              waitForSecond(); // 让进程等待一会，避免偶尔出现的元素获取异常  
              WebElement element_p = driver .findElement(By.id( "p" ));// 找到id名为p的 dom元素  
              element_p.sendKeys( password );// 将密码填入  
              waitForSecond();  
              WebElement element_b = driver .findElement(By.id( "login_button" ));// 找到登录按钮  
              waitForSecond();  
              //driver.switchTo().defaultContent(); //跳出frame
              element_b.click(); // 点击登录按钮  
       }  
 
       public void loginMail()  
       {  
             init();              //init()
             Login();          // login()      
             quitDrvier();  // quitDrvier()    
      }  
       
       @Test
       
       public  void loginQQmail() throws InterruptedException 
       {  
    	  LoginQQMail loginQQmail = new LoginQQMail();  
              loginQQmail.loginMail();  
      }  
 
}  
