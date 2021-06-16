package com.obsqura.testcase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
		genobj.click(loginpge.SignIn);
		//List<WebElement> rows=(List<WebElement>) driver.findElements(By.tagName("tr"));
	}
	
	@Test(priority=1)
	public void newTask() throws IOException {
		
		//click task tab on dashboard
		genobj.click(dashbrd.tasksTab);
		//click new project tab on projects section
		genobj.click(taskpge.newTaskTab);
		
		genobj.sendKeys(taskpge.taskName,exlobj.readExcelFun(2,1,"Task"));
		genobj.sendKeys(taskpge.relation,exlobj.readExcelFun(3,1,"Task"));
		genobj.sendKeys(taskpge.startDate,exlobj.readExcelFun(5,1,"Task"));
		genobj.sendKeys(taskpge.dueDate,exlobj.readExcelFun(6,1,"Task"));
		genobj.sendKeys(taskpge.hourlyRate,exlobj.readExcelFun(7,1,"Task"));
		genobj.sendKeys(taskpge.estimatedHours,exlobj.readExcelFun(8,1,"Task"));
		genobj.sendKeys(taskpge.taskStatus,exlobj.readExcelFun(9,1,"Task"));
		genobj.sendKeys(taskpge.taskDescription,exlobj.readExcelFun(10,1,"Task"));
		genobj.click(taskpge.save);
		
	}
	

	@AfterClass
	void afterclass() {
		driver.close();
	}

}
