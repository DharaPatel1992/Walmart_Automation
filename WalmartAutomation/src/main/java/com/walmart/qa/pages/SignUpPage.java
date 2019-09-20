package com.walmart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.walmart.qa.base.TestBase;

public class SignUpPage extends TestBase {

	// Page Factory

	@FindBy(xpath = "//input[@type='email' and @class='create-account-email']")
	WebElement emailId;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@type='checkbox' and @id='tnc']")
	WebElement isSelectedPrivatePolicy;

	@FindBy(xpath = "//button[@type='button' and @id='create-account-btn']")
	WebElement createMyAccountBtn;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateSignUpPageTitle() {
		return driver.getTitle();
	}

	public MyAccountPage CreateAccount(String fn, String ln, String psw, String cpsw) {
		emailId.sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Create my account')]")).click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		password.sendKeys(psw);
		confirmPassword.sendKeys(cpsw);
		isSelectedPrivatePolicy.click();
		createMyAccountBtn.click();
		return new MyAccountPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
