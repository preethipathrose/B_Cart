package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {
	
	WebDriver driver;

		public void click(WebElement value) {
			value.click();
		}

		public void sendKeys(WebElement value,String s) {
			value.sendKeys(s);
		}
		
		public  void dropdownIndex(WebElement value,int index) {
		      Select drop = new Select(value);
		      drop.selectByIndex(index);  
		}
		
		public  void dropdownByValue(WebElement value,String text) {
		      Select drop = new Select(value);
		      drop.selectByValue(text);  
		}
		
		public  void dropdownByVisibleText(WebElement value,String text) {
		      Select drop = new Select(value);
		      drop.selectByVisibleText(text);  
		}
		
		public Select multidropdownlist(WebElement value) {
			Select drop = new Select(value);
			return drop;
			
		}
		
		public String getattribute(WebElement value) {
			String temp=value.getAttribute("value");
			return temp;
		}
		
		public String gettext(WebElement value) {
			String text=value.getText();
			return text;
		}

		
}
