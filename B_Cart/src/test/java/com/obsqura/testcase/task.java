package com.obsqura.testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.obsqura.page.DashboardPage;
import com.obsqura.page.ProjectPage;
import com.obsqura.page.TaskPage;
import com.obsqura.page.loginPage;

import Utility.ExcelUtility;
import Utility.GeneralUtility;
import Utility.Utility1;
import Utility.WaitUtility;

public class task {
	
	Utility1 obj=new Utility1();
	WaitUtility waitobj=new WaitUtility();
	ExcelUtility exlobj=new ExcelUtility();
	GeneralUtility genobj=new GeneralUtility();
	
	WebDriver driver;
	Select dropdown;
	DashboardPage dashbrd;
	ProjectPage projectpge;
	loginPage loginpge;
	TaskPage taskpge;
	
	@BeforeClass
	void beforeclass() {
		
		driver=obj.launchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
		loginpge=new loginPage(driver);
		dashbrd=new DashboardPage(driver);
		projectpge=new ProjectPage(driver);
		taskpge=new TaskPage(driver);
		
		genobj.sendKeys(loginpge.username,"admin");
		genobj.sendKeys(loginpge.password,"123456");
		genobj.clickButton(loginpge.SignIn);
		//List<WebElement> rows=(List<WebElement>) driver.findElements(By.tagName("tr"));
		//click task tab on dashboard
		genobj.clickButton(dashbrd.tasksTab);
		
	}
	
	@Test(priority=1)
	public void newTask() throws IOException {
		
		
		//click new project tab on projects section
		genobj.clickButton(taskpge.newTaskTab);
		
		genobj.sendKeys(taskpge.taskName,exlobj.readExcelFun(2,1,"Task"));
		genobj.sendKeys(taskpge.relation,exlobj.readExcelFun(3,1,"Task"));
		genobj.sendKeys(taskpge.startDate,exlobj.readExcelFun(5,1,"Task"));
		genobj.sendKeys(taskpge.dueDate,exlobj.readExcelFun(6,1,"Task"));
		genobj.sendKeys(taskpge.hourlyRate,exlobj.readExcelFun(7,1,"Task"));
		genobj.sendKeys(taskpge.estimatedHours,exlobj.readExcelFun(8,1,"Task"));
		genobj.sendKeys(taskpge.taskStatus,exlobj.readExcelFun(9,1,"Task"));
		genobj.sendKeys(taskpge.taskDescription,exlobj.readExcelFun(10,1,"Task"));
		genobj.clickButton(taskpge.save);
		
		try {
			
		
		Assert.assertEquals(exlobj.readExcelFun(8,1,"Task"), taskpge.TaskNameView.getText());
		}
		
		catch (Exception e) {
			
			obj.screenshot("task_creation");
		}
	}
	
	@Test(priority=2)
	public void changeStatus() throws IOException {
		try {
			
		String statusFromExcel=exlobj.readExcelFun(14,1,"Task");
		switch(statusFromExcel) 
		{
			case "On Hold": genobj.clickButton(taskpge.onholdStatus);
				break;
			case "In Progress": genobj.clickButton(taskpge.inProgressStatus);
				break;
			case "Completed": genobj.clickButton(taskpge.completedStatus);
				break;
			case "Not Started": genobj.clickButton(taskpge.notStartedStatus);
				break;
			case "Deferred": genobj.clickButton(taskpge.deferredStatus);
				break;
			case "Waiting For Someone": genobj.clickButton(taskpge.waitingStatus);
				break;
			default:
				break;
		}
		
		
			
			Assert.assertEquals(exlobj.readExcelFun(14,1,"Task"),taskpge.newStatus.getText());	
		}
		
		catch (Exception e) {
			
			obj.screenshot("task_statusCheck");
		}
	}

	@AfterClass
	void afterclass() {
		driver.close();
	}

}
