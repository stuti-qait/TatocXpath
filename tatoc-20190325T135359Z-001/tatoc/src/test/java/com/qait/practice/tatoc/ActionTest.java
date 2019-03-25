package com.qait.practice.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.practice.tatoc.Pages.DataProvide;

import junit.framework.Assert;

public class ActionTest {

	WebDriver driver;
	
	//setting up the properties and driver
	
	public WebDriver setUpEnvironment() {
		String project = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project+"/driver/ChromeDriverWin/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	
	
	//validate and click on the green grid
	
	public void validateGrid() {
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		DataProvide.greenBox(driver).click();
		
	}
	
	
	/*this method will only run when the validateGrid() is executed. 
	 * clicks on Repaint till both boxes have same color
	 */
	
	public void boxColorMatch() {
		
			switchFrame("main");
	        String expectedBox = DataProvide.Box(driver).getAttribute("class");
	        switchFrame("child");
	        String actualBox = DataProvide.Box(driver).getAttribute("class");

	        while (!expectedBox.equals(actualBox)) {
	        	switchParent();
	            DataProvide.repaintLink(driver).click();
	            
	            switchFrame("child");
	            actualBox = DataProvide.Box(driver).getAttribute("class");
	        }
	        switchParent();
	        DataProvide.proceedLink(driver).click();
	}
	
	
	
	
	//this method will only run when the boxColorMatch() is executed. drags one box onto other
	
	public void dragAndDrop() {				
        Actions act=new Actions(driver);							
        act.dragAndDrop(DataProvide.dragBox(driver), DataProvide.dropBox(driver)).build().perform();
        DataProvide.proceedLink(driver).click();
	}
	
	
	
	
	/* this method will only run when the dragAndDrop() is executed. 
	 * open another window switches to that and enters text and comes back to original page
	 */
		
	public void popUpWindow() {	
		DataProvide.launchPopUpWindowLink(driver).click();
		String handler = driver.getWindowHandle();	
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		DataProvide.newLaunchedWindowTextBox(driver).sendKeys("hey");
		DataProvide.newLaunchedWindowSubmitButton(driver).click();
		driver.switchTo().window(handler);
		DataProvide.proceedLink(driver).click();
		
	}
	
	public void switchFrame(String text) {
		driver.switchTo().frame(text);
	}
	
	public void switchParent() {
		driver.switchTo().parentFrame();
	}
	
	public void verify(String locator, String TextExpected) {
		Assert.assertEquals(driver.findElement(By.xpath(locator)).getText(), TextExpected);
	}
	
	//close the window
		
		public void shutDown() {
		
			driver.quit();
		}
}
