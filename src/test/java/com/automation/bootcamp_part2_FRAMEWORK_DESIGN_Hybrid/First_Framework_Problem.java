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

public class First_Framework_Problem {

	
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
	
	
	@Test
	public void registerTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1123456789");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualAccountSuccessTitle = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String expectedAccountSuccessTitle = "Your Account Has Been Created!";
		Assert.assertTrue(actualAccountSuccessTitle.contains(expectedAccountSuccessTitle));
		
		
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
