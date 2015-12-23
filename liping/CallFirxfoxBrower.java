import GlobalMethod.OpenFirefoxBrower;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Test
public class CallFirxfoxBrower {
	public String url="http://www.imooc.com";
	public void callFirxfox() throws InterruptedException
	{
		//调用类并实例化一个对象
		OpenFirefoxBrower openfirefox = new OpenFirefoxBrower();
		//调用类OpenFirefoxBrower中的打开火狐浏览器
		openfirefox.openFirefoxBrower();
		//打开主页
		openfirefox.driver.navigate().to(url);
		//调用休眠时长方法
		openfirefox.waitForTime();
		//调用关闭窗口方法，如果不想关闭，注释掉即可
		//openfirefox.quitDrvier();
	}	
}
