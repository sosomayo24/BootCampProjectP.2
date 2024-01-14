package com.automation.bootcamp_part2_FRAMEWORK_DESIGN_Hybrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SpecialClasses.Util;

public class SearchProductTest {

	
	public WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		
	}
	
	@Test
	public void searchProductTest() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		driver.findElement(By.linkText("HP LP3065")).click();
		driver.findElement(By.id("button-cart")).click();
		driver.findElement(By.xpath("//a[@title = 'Checkout']/span")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
	}
	
}
