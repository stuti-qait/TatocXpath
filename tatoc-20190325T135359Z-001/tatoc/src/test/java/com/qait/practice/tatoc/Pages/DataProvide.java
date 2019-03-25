package com.qait.practice.tatoc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataProvide {

	private static WebElement element = null;
	
	public static WebElement greenBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='greenbox']"));
		return element;
	}
	

	
	public static WebElement Box(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='answer']"));
		return element;
	}
	
	public static WebElement repaintLink(WebDriver driver) {
		element =  driver.findElement(By.xpath("//a[contains(@onclick,'reloadChildFrame();')]"));
		return element;
	}
	

	public static WebElement proceedLink(WebDriver driver) {
		element =  driver.findElement(By.xpath("//a[contains(@onclick,'gonext();')]"));
		return element;
	}
	
	public static WebElement dragBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='dragbox']"));
		return element;
	}

	public static WebElement dropBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='dropbox']"));
		return element;
	}
	
	public static WebElement launchPopUpWindowLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(@onclick,'launchwindow();')]"));
		return element;
	}
	
	public static WebElement newLaunchedWindowTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='name']"));
		return element;
	}
	
	public static WebElement newLaunchedWindowSubmitButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='submit']"));
		return element;
	}
	
	
}
