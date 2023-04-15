package com.qa.opencart.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(LoginPage.class.getName());
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressEditbox;
	@FindBy(name="password")
	private WebElement passwordEditbox;
	@FindBy(css="input.btn.btn-primary")
	private WebElement loginBtn;
	@FindBy(partialLinkText="Forgotten Password")
	private WebElement ForgottenPasswordLink;
	@FindBy(xpath="//h2[contains(.,'Returning Customer')]")
	private WebElement returningCustomerHeader;
	@FindBy(xpath = "//h2[contains(.,'New Customer')]")
	private WebElement NewCustomerHeader;
	@FindBy(xpath = "//strong[contains(.,'Register Account')]")
	private WebElement registerAccountSubHeader;
	@FindBy(xpath = "//a[contains(.,'Continue')]")
	private WebElement newCustomerContinueBtn;
	@FindBy(xpath="//ul[@class='breadcrumb']/li[3]/a[text()='Login']")
	private WebElement accountLoginBreadCrumb;
	@FindBy(xpath="//ul[@class='breadcrumb']/li[1]/a/i")
	private WebElement loginHomeIcon;
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement loginNoMatchErrMsg;
	
	public String getLoginPageUrl() {
		log.info("Get login page current address bar url");
		return waitForUrlContains(Constants.LOGIN_PAGE_FRACTION_URL);
	}
	
	public String getLoginPageTitle() {
		log.info("Get Login page title");
		return getTitle();
	}
	
	public void doLogin(String email,String pwd) throws InterruptedException {
		log.debug("Performing the login action");
		sendData(emailAddressEditbox, email);
		sendData(passwordEditbox, pwd);
		log.debug("click on login button");
		click(loginBtn);
	}
	
	public void goToForgotPasswordPage() throws InterruptedException {
		log.info("Click on forgot password link");
		click(ForgottenPasswordLink);
	}
	
	public void clickNewCustomerContinueBtn() throws InterruptedException {
		log.info("click on Continue button");
		click(newCustomerContinueBtn);
	}
	public String getEmptyCredsErrMsgExists() throws InterruptedException {
		return getText(loginNoMatchErrMsg);
	}
	public boolean isNewCustomerHeaderExists() {
		return isDisplayed(NewCustomerHeader);
	}
	public boolean isRegisterAccountTextExists() {
		return isDisplayed(registerAccountSubHeader);
	}
	
	public boolean isReturningCustomerHeaderExists() {
		return isDisplayed(returningCustomerHeader);
	}
	public boolean isLoginBreadCrumbExists() {
		return isDisplayed(accountLoginBreadCrumb);
	}
	
	public void clickLoginHomeIcon() throws InterruptedException {
		log.debug("click on Login Page breadcrumb home icon");
		click(loginHomeIcon);
	}
}
