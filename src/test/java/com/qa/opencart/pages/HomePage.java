package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(HomePage.class.getName());
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div#logo>a>img")
	private WebElement openCartLogo;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	@FindBy(linkText="Login")
	private WebElement loginLink;
	
	@FindBy(xpath="//span[@id='cart-total']")
	private WebElement cartTotal;
	
	public void openMyAccountMenu() throws InterruptedException {
		log.debug("Opening the my account menu");
		click(myAccountMenu);
	}
	
	public void goToRegisterPage() throws InterruptedException {
		openMyAccountMenu();
		log.debug("click on Register link");
		waitForElementVisible(By.linkText("Register"));
		click(registerLink);
	}
	
	public void goToLoginPage() throws InterruptedException {
		openMyAccountMenu();
		log.debug("click on Login link");
		waitForElementVisible(By.linkText("Login"));
		click(loginLink);
	}
	
	public boolean isOpenCartLogoExists() {
		return isDisplayed(openCartLogo);
	}
	
	public String getCartTotal() throws InterruptedException {
		log.debug("get the cart total");
		return getText(cartTotal);
		
	}
	
}
