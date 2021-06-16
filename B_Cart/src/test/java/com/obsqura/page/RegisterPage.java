package com.obsqura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;

	public RegisterPage( WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="name")
	public WebElement compName;
	
	@FindBy(name="email")
	public WebElement compEmail;
	
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(name="confirm_password")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary mt-lg']")
	public WebElement SignUp;
	
	@FindBy(name="language")
	public WebElement lang;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement toastMessage;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-default']")
	public WebElement sign_in;

}