package amazonlinksetup;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseAmazon 
{
	public WebDriver driver;
	@Test(priority=1)
	
	public void aamazonsearch() throws Throwable
	
	{
		
		configreader config=new configreader();
		String browser;
		
		
		if(System.getProperty("browser")!=null)
		{
			browser=System.getProperty("browser");
		}
			
		else
		{
			

	     browser=config.browserName();
         }
			
		if(browser.equals("chrome"))
		{
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\GridFile\\chromedriver.exe" );
		 driver=new ChromeDriver();
		}
		if(browser.equals("edge"))
		{
		
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\GridFile\\chromedriver.exe" );
		 driver=new EdgeDriver();
		 
		
		}
		
	
	System.getProperty("browser");
	
	
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
