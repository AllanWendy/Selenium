package GlobalMethod;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenByFFBrower {

	public static void main(String[] args) {
    	// 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
    	//System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
    	// 创建一个 FireFox 的浏览器实例
        WebDriver driver = new FirefoxDriver();

        // 让浏览器访问 imooc
        driver.get("http://www.imooc.com");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.imooc.com");
        driver.manage().window().maximize(); 

        // 获取 网页的 title
        System.out.println("1 Page title is: " + driver.getTitle());
         
	}
}