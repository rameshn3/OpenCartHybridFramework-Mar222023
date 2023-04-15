package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class LogoutPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(LogoutPage.class.getName());
	private WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#content > h1")
	private WebElement accountLogoutHeader;
	@FindBy(css="#content > p:nth-child(2)")
	private WebElement accountLoggedOffMsg;
	@FindBy(css="#content > div > div > a")
	private WebElement accountLogoutContinueBtn;
	@FindBy(xpath="//ul[@class='breadcrumb']/li[3]/a[text()='Logout']")
	private WebElement accountLogoutBreadCrumb;
	
	public boolean isAccountLogoutHeaderExists() {
		waitForPageLoad(2000);
		return accountLogoutHeader.isDisplayed();
	}
	
	public boolean isAccountLoggedOffMsgExists() {
		waitForPageLoad(2000);
		return accountLoggedOffMsg.isDisplayed();
	}
	
	public boolean isAccountLogoutBreadCrumbExists() {
		waitForPageLoad(2000);
		return accountLogoutBreadCrumb.isDisplayed();
	}
	
	public String getLogoutPageTitle() {
		waitForPageLoad(2000);
		return getTitle();
	}
	
	public void clickContinueBtn() throws InterruptedException {
		click(accountLogoutContinueBtn);
	}
}
