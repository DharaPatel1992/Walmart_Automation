package com.walmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Facotory : Object Repository
	@FindBy(id = "login-form-email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@id=\"account-signin-btn\"]")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPAgeTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String psw) {
		username.sendKeys(un);
		password.sendKeys(psw);
		loginBtn.click();
		return new HomePage();
	}

}
