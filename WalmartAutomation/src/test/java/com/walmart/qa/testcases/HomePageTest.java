package com.walmart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;

public class HomePageTest extends TestBase{

	//LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();
		homePage = new HomePage();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * @Test(priority=1) public void verifyHomePageTitleTest() { String
	 * homePageTitle = homePage.verifyHomePageTitle();
	 * Assert.assertEquals(homePageTitle,
	 * "Shop Walmart.ca: Online Shopping & Everyday Low Prices"); }
	 */

	@Test(priority=1)
	public void clickOnSearch() throws InterruptedException {
		homePage.clickOnSearch();
	}
	


}
