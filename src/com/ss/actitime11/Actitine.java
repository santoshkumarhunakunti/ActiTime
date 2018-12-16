package com.ss.actitime11;

import java.awt.AWTException;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericlibrary.GenaricMethod;

//import genericLib.GenaricMethod;

public class Actitine 
{
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
    GenaricMethod gm= new GenaricMethod();
    System.setProperty("webdriver.firefox.marionette", "Resource/geckodriver.exe");
     FirefoxDriver driver = new 	FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost/login.do");

	driver.findElementByXPath(".//*[@id='username']").sendKeys("admin");
	driver.findElementByXPath(".//*[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[2]/td/input").sendKeys("srcsrc1122");
	driver.findElementByXPath(".//*[@id='loginButton']/div").click();
	Thread.sleep(3000);
	gm.clickQuickLaunch(716, 340);		
	driver.findElementsByXPath(".//*[@id='enterTTMainContent']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[6]/a/img");
	WebElement src =driver.findElementByXPath(".//*[@id='ext-gen32']");
 	Select drop_down=new Select(src);
	drop_down.selectByIndex(2);
	Thread.sleep(1000);
	driver.findElementByXPath(".//*[@id='createTasksPopup_newCustomer']").sendKeys("Santosh chavan");
	Thread.sleep(1000);
    driver.findElementByXPath(".//*[@id='createTasksPopup_newProject']").sendKeys("SANTRO");
	Thread.sleep(1000);
	driver.findElementByXPath(".//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[1]/td[1]/input").sendKeys("TestDrive");
	driver.findElementByXPath(".//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[2]/td[1]/input").sendKeys("Test");
	driver.findElementByXPath(".//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[3]/td[1]/input").sendKeys("Approved");
	driver.findElementByXPath(".//*[@id='ext-gen32']");
	driver.findElementByXPath(".//*[@id='createTasksPopup_commitBtn']/div/span").click();
	
	
	
	
	
	
	
	
}

}



