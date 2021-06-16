package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	
	public void explicitWait(WebElement element,int time,By value) {
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(value));
	}
	
}
