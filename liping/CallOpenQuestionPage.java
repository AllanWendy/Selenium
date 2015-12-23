import GlobalMethod.OpenQuestionPage;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import GlobalMethod.OpenChromeBrower;

@Test
public class CallOpenQuestionPage 
{
	/* public void callOpenQuestionPage() throws InterruptedException
	 {
	
		OpenChromeBrower openChromeBrower =new OpenChromeBrower();
		 openChromeBrower.quitDrvier();
		 openChromeBrower.waitForTime();
	 }*/
	public void callOpenQuestionPage()throws InterruptedException
 	{
		OpenQuestionPage openQuestionPage = new OpenQuestionPage();
 		/*openQuestionPage.init();
 		openQuestionPage.login();
 		openQuestionPage.comeWenDa();
 		openQuestionPage.waitForTimeTen();
 		openQuestionPage.quitDriver();*/
		openQuestionPage.init();
		openQuestionPage.login();
		openQuestionPage.comeWenDa();
		openQuestionPage.quitDriver();
 	}
}
