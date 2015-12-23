import java.awt.List;
import java.util.concurrent.TimeUnit;

import GlobalMethod.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class userinfo  {
	
	  private  static String uinfo = "http://www.imooc.com/user/userinfo";
	  private  static String setpwd = "http://www.imooc.com/user/setresetpwd";
      private  static String  settings="我们活在浩瀚的宇宙里，漫天漂浮的宇宙尘埃和星河光尘，我们是比这些还要渺小的存在。我们都是小小的星辰--郭敬明";
   @Test
   public void userinfo() throws InterruptedException {

		   GlobalMethod userinfo = new GlobalMethod();
		   //调用初始化方法
		   userinfo.init();
		   //打开chrome浏览器
		   userinfo.openChromeBrower();
		   //通过邮箱登录慕课网前端
		   userinfo.openLoginPage();
		   userinfo.loginByEmail();
		   //定位userinfo页面
		   userinfo.driver.navigate().to(uinfo);
		   //xpath定位个人设置页面元素
		   userinfo.driver.findElement(By.xpath("//input[@name='nickname']")).clear();
		   userinfo.waitForSecond();
		   userinfo.driver.findElement(By.xpath("//input[@name='nickname']")).sendKeys("userinfo");
		   //select定位下拉列表元素
		   Select jobselect = new Select(userinfo.driver.findElement(By.id("job")));		
		   jobselect.selectByVisibleText("移动开发工程师");
		   
		   Select proselect = new Select (userinfo.driver.findElement(By.id("province-select")));
		   proselect.selectByVisibleText("河北");
		   userinfo.waitForSecond();
		   
		   Select cityselect = new Select (userinfo.driver.findElement(By.id("city-select")));
		   cityselect.selectByVisibleText("石家庄市");
		   
		   Select areaselect = new Select (userinfo.driver.findElement(By.id("area-select")));
		   areaselect.selectByVisibleText("赞皇县");
		   
		   WebElement bookMode = userinfo.driver.findElement(By.xpath("//input[@value='1']"));
            bookMode.click();
     	   userinfo.waitForSecond();
     	   //xpath定位个人前面输入框
            WebElement info = userinfo.driver.findElement(By.xpath("//textarea[@id='aboutme']"));
            //调用clear()方法清空输入框
            info.clear();
            //输入新个人签名信息
            info.sendKeys(settings);
     	   userinfo.waitForSecond();
     	   //xpath定位提交按钮，调用click()方法
            WebElement submit = userinfo.driver.findElement(By.xpath("//span[@id='profile-submit']"));
            submit.click();
            
          //定位重置密码页面
            userinfo.driver.navigate().to(setpwd);
            //xpath定位密码输入框
            WebElement oldpwd =userinfo.driver.findElement(By.xpath("//input[@name='oldpwd']"));
            //输入旧密码
            oldpwd.sendKeys("111111");
           //xpath定位密码输入框
            WebElement newpwd =userinfo.driver.findElement(By.xpath("//input[@name='newpass']"));
           //输入旧密码
             newpwd.sendKeys("222222");
            //xpath定位密码输入框
            WebElement confirmpwd =userinfo.driver.findElement(By.xpath("//input[@id='confirm']"));
           //输入旧密码
            confirmpwd.sendKeys("222222");
            userinfo.waitForSecond();
            //定位保存按钮
            WebElement resetpwd =userinfo.driver.findElement(By.xpath("//span[@id='resetpwd-btn-save']"));
            resetpwd.click();         
            
            //更换用户头像
            userinfo.driver.navigate().to("http://www.imooc.com/user/setavator");
            //WebElement setava =userinfo.driver.findElement(By.xpath("//input[@id='upload']"));
            //userinfo.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    		userinfo.driver.findElement(By.xpath("//input[@id='upload']")).sendKeys("d://11.jpg");
    		 
            
	    }
     
   
}



