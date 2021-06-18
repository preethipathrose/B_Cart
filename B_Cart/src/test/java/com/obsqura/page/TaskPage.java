package com.obsqura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	WebDriver driver;

	public TaskPage( WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='New Task']")
	public WebElement newTaskTab;
	
	@FindBy(xpath="//input[@name='task_name']")
	public WebElement taskName;
	
	@FindBy(xpath="//select[@name='related_to']")
	public WebElement relation;
	
	@FindBy(xpath="//input[@name='task_start_date']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@name='due_date']")
	public WebElement dueDate;
	
	@FindBy(xpath="//input[@name='hourly_rate']")
	public WebElement hourlyRate;
	
	@FindBy(xpath="//select[@name='task_status']")
	public WebElement taskStatus;
	
	@FindBy(xpath="//input[@name='task_hour']")
	public WebElement estimatedHours;
	
	@FindBy(xpath="//div[@class='note-editable']")
	public WebElement taskDescription;
	
	@FindBy(xpath="//label[@class='btn btn-success toggle-on']")
	public WebElement billable;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-primary']")
	public WebElement save;
	
	@FindBy(xpath="//a[text()='Import Tasks']")
	public WebElement importtask;
	
	@FindBy(xpath="//*[@name='upload_file']")
	public WebElement selectFile;
	
	@FindBy(xpath="//select[@name='task_status']")
	public WebElement taskNameView;
	
	@FindBy(xpath="//p[@class='form-control-static label label-info  ']")
	public WebElement taskStatusView;
	
	
	@FindBy(xpath="//*[@id=\"task_details\"]/div/div[1]/h3/text()")
	public WebElement TaskNameView;
	
	@FindBy(xpath="//a[text()='On Hold']")
	public WebElement onholdStatus;
	
	@FindBy(xpath="//a[text()='In Progress']")
	public WebElement inProgressStatus;
	
	@FindBy(xpath="//a[text()='Completed']")
	public WebElement completedStatus;
	
	@FindBy(xpath="//a[text()='Not Started']")
	public WebElement notStartedStatus;
	
	@FindBy(xpath="//a[text()='Deferred']")
	public WebElement deferredStatus;
	
	@FindBy(xpath="//a[text()='Waiting For Someone']")
	public WebElement waitingStatus;
		
	@FindBy(xpath="//button[@class='btn btn-xs btn-success dropdown-toggle']")
	public WebElement changeStatus;	
	
	@FindBy(xpath="//p[@class='form-control-static label label-warning  ']")
	public WebElement newStatus;
	
	@FindBy(xpath="//*[@id='DataTables']/tbody/tr[1]/td[2]//a")
	public WebElement selectTask;	
}
