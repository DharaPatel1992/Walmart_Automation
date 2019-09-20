package com.walmart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.MyAccountPage;
import com.walmart.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase {

	MyAccountPage myAccountPage;
	SignUpPage signUpPage;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		signUpPage = new SignUpPage();

	}

	@Test(priority = 1)
	public void SignUpPageTitleTest() {
		String title = signUpPage.ValidateSignUpPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
		System.out.println("equal" + title);
	}
	
	@Test(priority = 2)
	public void createAccountTest() {
		myAccountPage = signUpPage.CreateAccount("test", "test", "test@123", "test@123");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
