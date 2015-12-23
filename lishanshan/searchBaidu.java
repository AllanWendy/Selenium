package OK;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchBaidu {
	public static void main(String[] args) throws IOException, InterruptedException {
		// chrome 
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Documents and Settings\\sq\\Local Settings\\Application Data\\Google\\Chrome\\Application\\chrome.exe");
		// 设置chromedriver
		@SuppressWarnings("deprecation")
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File(
								"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
		// 定义 Chrome driver
		WebDriver driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());

		// 打开Baidu
		driver.get("http://www.baidu.com");
		// 也可以用navigate()
		// driver.navigate().to("http://www.baidu.com");

		//打印title
		System.out.println("1 Page title is: " + driver.getTitle());

		// 根据id找到输入框
		WebElement input = driver.findElement(By.id("kw1"));

		// 输入IT
		input.sendKeys("IT");

		// 查询
		input.submit();
		Thread.sleep(5000); 

		//根据titel的开始字符判断是否正确
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("IT");
			}
		});

		// 打印title
		System.out.println("2 Page title is: " + driver.getTitle());
		
		//退出
		driver.quit();

	}
}