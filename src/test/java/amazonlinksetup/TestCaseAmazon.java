package amazonlinksetup;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseAmazon 
{
	@Test(priority=1)
	public void aamazonsearch() throws Throwable
	
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\GridFile\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		List<WebElement> ele=driver.findElements(By.tagName("a"));
		int count=ele.size();
		System.out.println(count);
		
		WebElement footer=driver.findElement(By.xpath("//div[@id='navFooter']"));
		List<WebElement> ele1=	footer.findElements(By.tagName("a"));
		int count1=ele1.size();
		System.out.println(count1);
		WebElement subfooter=footer.findElement(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[1]"));
		List<WebElement> ele2=	subfooter.findElements(By.tagName("a"));
		int count2=ele2.size();
		System.out.println(count2);
		
		
		for(WebElement link:ele2)
		{
			
			String linkurl=link.getAttribute("href");
			
HttpURLConnection con=(HttpURLConnection) new URL(linkurl).openConnection();
con.setRequestMethod("HEAD");
con.connect();
int response=con.getResponseCode();

if (response==200)
{
	
	
		System.out.println(linkurl+ "-" +con.getResponseMessage());
}
			
			
if (response==con.HTTP_NOT_FOUND)
{
	
	
		System.out.println(linkurl+ "-" +con.getResponseMessage());
}
			
			
		}
		
		
		
		
		
		for(int i=0;i<count2;i++)
		{
			
		  String com= Keys.chord(Keys.CONTROL,Keys.ENTER);
		  ele2.get(i).sendKeys(com);
		  Thread.sleep(2000);
		  
		}
		
		
		String Mainwindow=driver.getWindowHandle();
	    Set<String> windows=	driver.getWindowHandles();
		Iterator<String> check=windows.iterator();
		while(check.hasNext())
		{
			String Childwindow=check.next();
			if(!Mainwindow.equalsIgnoreCase(Childwindow))
			{
				String title=driver.switchTo().window(Childwindow).getTitle();
				System.out.println(title);
				
			}
			
		}
		

	}

}
