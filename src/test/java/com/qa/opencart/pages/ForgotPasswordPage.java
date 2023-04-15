package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class ForgotPasswordPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(ForgotPasswordPage.class.getName());
	private WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[id='content'] h1")
	private WebElement forgotYourPasswordHeader;
	
	@FindBy(css="form[class='form-horizontal'] fieldset legend")
	private WebElement emailAddrLegendTxt;
	
	@FindBy(className="form-control")
	private WebElement emailAddrEditbox;
	
	@FindBy(xpath="//a[normalize-space()='Back']")
	private WebElement backBtn;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(css="body div[class='container'] ul[class='breadcrumb'] li:nth-child(1) a:nth-child(1)")
	private WebElement forgotPasswordBreadCrumb;
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[1]/a/i")
	private WebElement forgotPwdHomeIcon;
	
	public void clickForgotPwdHomeIcon() throws InterruptedException {
		log.debug("click on Forgot password Page breadcrumb home icon");
		click(forgotPwdHomeIcon);
	}
	
	public void clickForgotPwdBackBtn() throws InterruptedException {
		log.debug("click on Forgot password Page Back button");
		click(backBtn);
	}
	
	public void clickForgotPwdContinueBtn() throws InterruptedException {
		log.debug("click on Forgot password Page Continue button");
		click(continueBtn);
	}
	
	public void fillEmailAddress(String email) throws InterruptedException {
		log.debug("Fill the email address");
		sendData(emailAddrEditbox, email);
	}
	
	public boolean isForgotYourPasswordHeaderExists() {
		return isDisplayed(forgotYourPasswordHeader);
	}
	
	public boolean isEmailAddrLegendTxtExists() {
		return isDisplayed(emailAddrLegendTxt);
	}
	public boolean isForgotPwdBreadCrumbExists() {
		return isDisplayed(forgotPasswordBreadCrumb);
	}
}
