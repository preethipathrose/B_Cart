package com.obsqura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	public WebDriver driver;


	public DashboardPage( WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	@FindBy(xpath="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a/span")
	public WebElement projectsTab;
	
	@FindBy(xpath="//a[@title='Tasks']")
	public WebElement tasksTab;
}
