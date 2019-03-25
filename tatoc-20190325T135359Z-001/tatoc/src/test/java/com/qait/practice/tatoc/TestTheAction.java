package com.qait.practice.tatoc;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTheAction {
	WebDriver driver ;
	ActionTest act = new ActionTest();
	
	@BeforeClass
	public void setUp() {
		act.setUpEnvironment();
		
	}
	
	@Test
	public void validateGridTest() {
		act.validateGrid();
		act.verify("//h1", "Frame Dungeon");
	}
	
	@Test (dependsOnMethods = { "validateGridTest" })
	public void boxColorMatchTest() {
		act.boxColorMatch();
		act.verify("//h1", "Drag Around");
	}
	
	@Test (dependsOnMethods = { "boxColorMatchTest" })
	public void dragAndDropTest() {
		act.dragAndDrop();
		act.verify("//h1" , "Popup Windows");
	}
	
	@Test (dependsOnMethods = { "dragAndDropTest" })
	public void popUpWindowTest() {
		act.popUpWindow();
		act.verify("//h1", "Cookie Handling");
	}
	
	@AfterClass
	public void tearDown() {
		act.shutDown();
		
	}
}
