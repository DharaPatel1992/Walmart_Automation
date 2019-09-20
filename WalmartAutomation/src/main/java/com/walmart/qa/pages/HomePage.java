package com.walmart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmart.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Hi')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//input[@type='text'and @class='e1xoeh2i1 css-150z6pi eesbt950']")
	WebElement searchClick;

	@FindBy(xpath = "//a[contains(text(),'Halloween')]")
	WebElement halloweenLink;

	@FindBy(xpath = "//a[contains(text(),'Thanksgiving')]")
	WebElement thanksgivingLink;

	@FindBy(xpath = "//a[contains(text(),'Clothing')]")
	WebElement clothingLink;

	// css-1pgwcoa e1xoeh2i2
	@FindBy(xpath = "//button[@type='submit' and @class='css-1pgwcoa e1xoeh2i2']")
	WebElement searchSubmitBtn;
	
	@FindBy(xpath = "//a[@id='loadmore' and @class='page-select-list-btn']")
	WebElement a;
	
	// Initializing the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage clickOnSearch() throws InterruptedException {
		searchClick.click();
		searchClick.sendKeys("fruit");
		searchSubmitBtn.click();
		// ExplicitWait(driver, searchSubmitBtn, 90);
		
		List pagination = driver.findElements(By.xpath("//a[@id='loadmore' and @class='page-select-list-btn']")); 
		// checkif pagination link exists 
		if(pagination .size()>0){ 
			System.out.println("pagination exists" + pagination .size()); 

			// click on pagination link 

			for(int i=0; i<pagination .size(); i++){ 
			((WebElement) pagination.get(i)).click(); 
			} 
			} else { 
			System.out.println("pagination not exists"); 
			} 
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='page-select']")));  
		ExplicitWait(driver, searchSubmitBtn, 300);
		dropdown.selectByValue("61-120");
		return new SearchPage();
	}

	
	  public static void ExplicitWait(WebDriver driver, WebElement locator, int
	  timeout) { new WebDriverWait(driver,
	  timeout).ignoring(StaleElementReferenceException.class)
	  .until(ExpectedConditions.elementToBeClickable(locator)); locator.click(); }
	 
	public HalloweenPage clickOnHalloweenLink() {
		halloweenLink.click();
		return new HalloweenPage();
	}

	public ThanksGivingPage clickOnThanksGivingLink() {
		thanksgivingLink.click();
		return new ThanksGivingPage();
	}

	public ClothingPage clickOnClothingLink() {
		clothingLink.click();
		return new ClothingPage();
	}

}
