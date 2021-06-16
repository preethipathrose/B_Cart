package com.obsqura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public WebDriver driver;
	//PageFactory.initElements(driver, loginPage.class);
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath=".//*[@class='btn btn-primary  btn-flat']")
	public WebElement SignIn;

	@FindBy(xpath="//a[@class='text-muted']")
	WebElement forgetPassword;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-default']")
	public WebElement getAccount;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement alertmessage;
	
	@FindBy(xpath=".//*[@id=\"parsley-id-4\"]//li")
	public WebElement useralert;
	
	@FindBy(xpath=".//*[@id=\"parsley-id-6\"]//li")
	public WebElement passalert;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement toastMessage;

}
