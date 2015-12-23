package GlobalMethod;
import org.junit.Test;
//import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuestionSwitch 
{
	private String all="/wenda/0";
	private String couse_taolun="/wenda/2";
	private String tech_wd="/wenda/1";
	private String tech_share="/wenda/4";
	private String suggestion="/wenda/3";
	OpenQuestionPage openQuestionPage = new OpenQuestionPage();
	//public WebElement cur_element =null;
	public void init()
	{
		openQuestionPage.init();
		openQuestionPage.login();
		openQuestionPage.comeWenDa();
		/*//跳转到课程讨论
		WebElement course_tab=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/2']"));
		course_tab.click();
		openQuestionPage.waitForTimeTwo();
		 //跳转到技术问答
		 openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/1']")).click();
		 System.out.println("当前页Title为："+openQuestionPage.driver.getTitle());
		 openQuestionPage.waitForTimeTwo();
		 //跳转到技术分享
		 openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/4']")).click();
		 System.out.println("当前页Title为："+openQuestionPage.driver.getTitle());
		 openQuestionPage.waitForTimeTwo();
		 //跳转到活动建议
		 openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/3']")).click();
		 System.out.println("当前页Title为："+openQuestionPage.driver.getTitle());
		 openQuestionPage.waitForTimeTen();
		// 通过xpath跳转到全部问答
			WebElement all_wd=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/0']"));
			all_wd.click();
			openQuestionPage.waitForTimeTwo();
		    openQuestionPage.quitDriver();
		//通过链接文字跳转到全部问答
		 openQuestionPage.driver.findElement(By.linkText("全部问答")).click();
		 openQuestionPage.waitForTimeTwo();
		 System.out.println("当前页Title为："+openQuestionPage.driver.getTitle());
		 openQuestionPage.quitDriver();*/
	}
	//跳转到课程讨论
	public void comeCourseWD()
	{
		//WebElement course_tab=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/2']"));
		WebElement course_tab=openQuestionPage.driver.findElement(By.linkText("课程讨论"));
		course_tab.click();
		System.out.println("跳转到课程讨论的Title为："+openQuestionPage.driver.getTitle());
		openQuestionPage.waitForTimeTwo();
	}
	//跳转到技术问答
	public void comeTechWD()
	{
		//WebElement tech_wd=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/1']"));
		WebElement tech_wd=openQuestionPage.driver.findElement(By.linkText("技术问答"));
		tech_wd.click();
		System.out.println("跳转到技术问答的Title为："+openQuestionPage.driver.getTitle());
		openQuestionPage.waitForTimeTwo();
	}
	//跳转到技术分享
	public void comeTechShare()
	{
		//WebElement tech_share=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/4']"));
		WebElement tech_share=openQuestionPage.driver.findElement(By.linkText("技术分享"));
		tech_share.click();
		System.out.println("跳转到技术分享的Title为："+openQuestionPage.driver.getTitle());
		openQuestionPage.waitForTimeTwo();
	}
	//跳转到活动建议
	public void comeSuggestion()
	{
		//WebElement suggestion=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/3']"));
		WebElement suggestion=openQuestionPage.driver.findElement(By.linkText("活动建议"));
		suggestion.click();
		System.out.println("跳转到活动建议 的Title为："+openQuestionPage.driver.getTitle());
		openQuestionPage.waitForTimeTwo();
	}
	//跳转到全部问答
	public void comeAll()
	{
		//WebElement all=openQuestionPage.driver.findElement(By.xpath("//a[@href='/wenda/0']"));
		WebElement all=openQuestionPage.driver.findElement(By.linkText("全部问答"));
		all.click();
		System.out.println("跳转到全部问答的Title为："+openQuestionPage.driver.getTitle());
		openQuestionPage.waitForTimeTen();
		openQuestionPage.quitDriver();
	}
	@Test
	public void questionSwitch()
	{
		QuestionSwitch questionSwitch = new QuestionSwitch();
		questionSwitch.init();
		
	    //执行方法跳转到课程讨论
		questionSwitch.comeCourseWD();
		
		//执行方法跳转到技术问答
		questionSwitch.comeTechWD();
		
		//执行方法跳转到技术分享
		questionSwitch.comeTechShare();
		
		//z执行方法跳转到活动建议
		questionSwitch.comeSuggestion();
		//执行方法跳转到全部问答
		questionSwitch.comeAll();
		
	}

}
