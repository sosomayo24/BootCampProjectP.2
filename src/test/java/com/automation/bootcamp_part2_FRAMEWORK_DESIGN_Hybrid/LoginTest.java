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

public class LoginTest {

	
	public WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		
	}
	
	
	@Test
	public void loginTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(logoutLink.isEnabled());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
	}
	
}
