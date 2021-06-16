package Utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Utility1 {

	WebDriver driver;
	String browser,url;
	int count=0;
	
	public WebDriver launchBrowser(String browser,String url)  {
		
		this.browser=browser;
		this.url=url;
		
		switch(browser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_java\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", "D:\\Selenium_java\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_java\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void screenshot() throws IOException {
		
		count++;
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("D:\\screenshot\\ElementScreenshot_"+count+".jpg");
		Files.copy(SrcFile, DestFile);
		
	}
	
	public Alert alert() {
		Alert obj1=driver.switchTo().alert();
		return obj1;
	}	
	
	
	public void close() {
		driver.close();
	}	
}
