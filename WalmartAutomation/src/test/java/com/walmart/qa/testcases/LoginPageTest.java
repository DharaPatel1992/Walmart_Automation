package com.walmart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		lp = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPAgeTitle();
		Assert.assertEquals(title, "Walmart Canada");
		System.out.println("equal" + title);
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
