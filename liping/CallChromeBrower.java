import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import GlobalMethod.OpenChromeBrower;

@Test
public class CallChromeBrower {
	//定义要打开的网站url
	private String url="http://www.imooc.com";
	public void callChrome() throws InterruptedException{
		//引用类OpenChromeBrower 并实例化一个对象
		OpenChromeBrower openchrome =new OpenChromeBrower();
		/*下面这句错误，未调用OpenChromeBrower类中的方法
		openchbrower.driver.navigate().to(url); 
		*/
		
		// 备注  调用类OpenChromeBrower中的打开chrome浏览器方法
		openchrome.openChromeBrower();
		
		// 备注AA 上面这调用方法，如果在类OpenChromeBrower中未定义url，则可用下面这句打开，如果定义url，则可以不用下面这句代码
		openchrome.driver.navigate().to(url);
		
		//调用页面停留时长方法
		openchrome.waitForTime();
		//调用OpenChromeBrower中的关闭窗口方法
		openchrome.quitDrvier();
	}
}
