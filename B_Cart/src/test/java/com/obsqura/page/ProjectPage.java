package com.obsqura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	public WebDriver driver;
	
	public ProjectPage( WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath=".//*[@href=\"#create\"]")
	public WebElement newProjectTab;
	
	@FindBy(xpath=".//*[@name=\"project_name\"]")
	public WebElement projectName;
	
	@FindBy(xpath="//select[@name='client_id']")
	public WebElement selectClient;
	
	@FindBy(xpath="//input[@class='form-control start_date']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@class='form-control end_date']")
	public WebElement endDate;
	
	@FindBy(xpath="//select[@name='billing_type']")
	public WebElement billingType;
	
	@FindBy(xpath="//select[@name='billing_type']")
	public WebElement fixedPrice;
	
	@FindBy(xpath="//input[@name='estimate_hours']")
	public WebElement estimateHours;
	
	@FindBy(xpath="//select[@name='project_status']")
	public WebElement status;
	
	@FindBy(xpath="//input[@name='demo_url']")
	public WebElement demoUrl;
	
	@FindBy(xpath="(.//*[@class=\"col-lg-8\"]//span)[24]")
	public WebElement assignedTo;
	
	@FindBy(xpath="(.//*[@class=\"col-lg-10\"]//div)[158]")
	public WebElement description;
	
	@FindBy(xpath="(.//*[@class=\"panel-body\"]//button)[162]")
	public WebElement save;
	
	@FindBy(xpath="//a[contains(text(),\"Import Projects\")]")
	public WebElement importProject;
	
	@FindBy(xpath=".//*[@type=\"file\"]")
	public WebElement selectFile;
	
	@FindBy(xpath="//span[contains(text(),\"Select Client\")]")
	public WebElement Client;
	
	@FindBy(xpath="(.//*[@class=\"fa fa-circle\"])[1]")
	public WebElement assign;
	
	@FindBy(xpath="//span[contains(text(),\"Select Client\")]")
	public WebElement upload;
	
	@FindBy(xpath=".//*[@href=\"#manage\"]")
	public WebElement allprojects;
	
	@FindBy(xpath="//a[contains(text(),\"Next\")]")
	public WebElement next;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-xs btn-success dropdown-toggle']")
	public WebElement changeStatus;
	
	@FindBy(xpath="//a[text()='On Hold']")
	public WebElement onholdStatus;
	
	@FindBy(xpath="//span[@class='label label-warning']")
	public WebElement getStatus_obhold;
}
