package com.obsqura.testcase;
import com.obsqura.page.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Utility.ExcelUtility;
import Utility.GeneralUtility;
import Utility.Utility1;
import Utility.WaitUtility;	

public class login {
	
	Utility1 obj=new Utility1();
	WaitUtility waitobj=new WaitUtility();
	ExcelUtility exlobj=new ExcelUtility();
	GeneralUtility genobj=new GeneralUtility();
	
	WebDriver driver;
	loginPage loginpge;
	RegisterPage registerpge;
	String alertText;
	
	
	@BeforeClass
	void BeforeClass() {
		driver=obj.launchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
		loginpge=new loginPage(driver);
		registerpge=new RegisterPage(driver);
		
	}
	
					///BLANK USERNAME AND PASSWORD/////
	
	@Test(priority=1)
	public void blankValue() throws IOException {
		
		genobj.click(loginpge.SignIn);
		alertText=genobj.gettext(loginpge.useralert);
		String alert_Text=genobj.gettext(loginpge.passalert);
	    Assert.assertEquals(alertText, "This value is required.");
		
	}
	
				//////INVALID USERNAME//////
	
	@Test(priority=2)
	public void invalidUsername() throws IOException {
		
		genobj.sendKeys(loginpge.username,exlobj.readExcelFun(2,0,"Login"));
		genobj.sendKeys(loginpge.password,exlobj.readExcelFun(2,1,"Login"));
		genobj.click(loginpge.SignIn);
		alertText=genobj.gettext(loginpge.alertmessage);
		Assert.assertEquals(alertText, "username or password information doesn't exist!");
		
	}
	
				//////INVALID PASSWORD//////
	
	@Test(priority=3)
	public void invalidPassword() throws IOException {
		
		genobj.sendKeys(loginpge.username,exlobj.readExcelFun(5,0,"Login"));
		genobj.sendKeys(loginpge.password,exlobj.readExcelFun(5,1,"Login"));
		genobj.click(loginpge.SignIn);
		alertText=genobj.gettext(loginpge.alertmessage);
		Assert.assertEquals(alertText, "username or password information doesn't exist!");
		
	}
	
			/////VALID LOGIN//////
	
	@Test(priority=5)
	public void validLogin() throws IOException {
		
		genobj.sendKeys(loginpge.username,exlobj.readExcelFun(8,0,"Login"));
		genobj.sendKeys(loginpge.password,exlobj.readExcelFun(8,1,"Login"));
		genobj.click(loginpge.SignIn);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String pageUrl=driver.getCurrentUrl();
		Assert.assertEquals(pageUrl,"http://buffalocart.com/demo/erp/admin/dashboard");

	}
			////CREATE USER/////
	
	@Test(priority=4)
	public void createUser() throws IOException {
		
		genobj.click(loginpge.getAccount);
		
		genobj.sendKeys(registerpge.compName,exlobj.readExcelFun(11,1,"Login"));
		genobj.sendKeys(registerpge.compEmail,exlobj.readExcelFun(12,1,"Login"));
		genobj.sendKeys(registerpge.username,exlobj.readExcelFun(13,1,"Login"));
		genobj.sendKeys(registerpge.password,exlobj.readExcelFun(14,1,"Login"));
		genobj.sendKeys(registerpge.confirmPassword,exlobj.readExcelFun(14,1,"Login"));
		genobj.dropdownByVisibleText(registerpge.lang, exlobj.readExcelFun(15,1,"Login"));
		genobj.click(registerpge.SignUp);
		
		String alertText=genobj.gettext(registerpge.toastMessage);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		genobj.click(registerpge.sign_in);
		Assert.assertEquals(alertText, "You have successfully registered! Check your email address to activate your account.");
	
	}
	
	@AfterTest()
	void closebrowser() {
		driver.close();
	}

}
