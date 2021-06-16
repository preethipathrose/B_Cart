package com.obsqura.testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.obsqura.page.DashboardPage;
import com.obsqura.page.ProjectPage;
import com.obsqura.page.RegisterPage;
import com.obsqura.page.loginPage;

import Utility.ExcelUtility;
import Utility.GeneralUtility;
import Utility.Utility1;
import Utility.WaitUtility;

public class project {
	
	Utility1 obj=new Utility1();
	WaitUtility waitobj=new WaitUtility();
	ExcelUtility exlobj=new ExcelUtility();
	GeneralUtility genobj=new GeneralUtility();
	
	WebDriver driver;
	Select dropdown;
	DashboardPage dashbrd;
	ProjectPage projectpge;
	loginPage loginpge;
	
	
	@BeforeClass
	//@Parameters({"browser"})
	void beforeClass() {
		
		driver=obj.launchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
		loginpge=new loginPage(driver);
		dashbrd=new DashboardPage(driver);
		projectpge=new ProjectPage(driver);
		
		genobj.sendKeys(loginpge.username,"admin");
		genobj.sendKeys(loginpge.password,"123456");
		genobj.click(loginpge.SignIn);
		List<WebElement> rows=(List<WebElement>) driver.findElements(By.tagName("tr"));
	}
	

	@Test(priority=1)
	public void newProject() {
		
		//click project tab on dashboard
		genobj.click(dashbrd.projectsTab);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//click new project tab on projects section
		genobj.click(projectpge.newProjectTab);
		genobj.sendKeys(projectpge.projectName,"Test Project17");
		genobj.dropdownByVisibleText(projectpge.selectClient,"Freddy");
		genobj.sendKeys(projectpge.startDate,"2021-06-01");
		genobj.sendKeys(projectpge.endDate,"2021-06-28");
		genobj.dropdownByVisibleText(projectpge.billingType,"Fixed Price");
		genobj.sendKeys(projectpge.fixedPrice,"100");
		genobj.sendKeys(projectpge.estimateHours,"2021-06-28");
		genobj.dropdownByVisibleText(projectpge.status,"Started");
		genobj.sendKeys(projectpge.demoUrl,"http://buffalocart.com/demo/erp/admin/projects");
		genobj.click(projectpge.assignedTo);
		genobj.sendKeys(projectpge.description,"Sample Project to be tested");
		genobj.click(projectpge.save);
		genobj.click(dashbrd.projectsTab);
		genobj.click(projectpge.allprojects);
		String text=driver.findElement(By.xpath("//*[@id='DataTables']/tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(text,"Test Project17");
	}
	
	@Test(priority=2)
	public void changeStatus() throws IOException {
		
		genobj.sendKeys(projectpge.searchBox, "Test Project15");
		driver.findElement(By.xpath("//*[@id='DataTables']/tbody/tr[1]/td[2]//a")).click();
		
		genobj.click(projectpge.changeStatus);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		genobj.click(projectpge.onholdStatus);
		String text=genobj.gettext(projectpge.getStatus_obhold);
		//SoftAssert.assertEquals(text,"On Hold");
		Assert.assertEquals(text, "On Hold");

	}
	
	@AfterClass
	void afterclass() {
		driver.close();
	}

}
