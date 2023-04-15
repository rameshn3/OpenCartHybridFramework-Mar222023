package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginPageTest extends TestBase{
	private Logger log=LogManager.getLogger(LoginPageTest.class.getName());
  
	
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  log.info("Initilizing the page class objects");
		  homePg=new HomePage(driver);
		  regPg=new RegistrationPage(driver);
		  loginPg=new LoginPage(driver);
		  myaccountPg=new MyAccountPage(driver);
		  forgotpwdPg=new ForgotPasswordPage(driver);
		  logoutPg=new LogoutPage(driver);
		  homePg.goToLoginPage();
	  }
	
  @BeforeMethod
  public void beforeMethod() {
	  loginPg.waitForPageLoad(2000);
  }
 

  @Test(description="TC_01_Verifying the login page url",priority=1)
  public void verifyLoginPageUrlTest() {
	  log.info("verify the login page URL test");
	  Assert.assertTrue(loginPg.getLoginPageUrl().contains(Constants.LOGIN_PAGE_FRACTION_URL));
  }

  @Test(description="TC_02_Verifying the Login Page Title",priority=2)
  public void verifyLoginPageTitleTest() {
	  log.info("verify the Login page title");
	  Assert.assertEquals(loginPg.getTitle(),Constants.LOGIN_PAGE_TITLE);
  }
  
  @Test(description="TC_03_verify newCustomer header in login Page",priority=3)
  public void verifyNewCustomerHeaderTest() throws InterruptedException {
	  log.info("TC_03_verifyNewCustomerHeader in login Page");
	  
	  Assert.assertTrue(loginPg.isNewCustomerHeaderExists());
	 
  }
  
  @Test(description="TC_04_verify register account text in login Page",priority=4)
  public void verifyRegisterAccountTextTest() throws InterruptedException {
	  log.info("TC_03_verify register account text in login Page");
	  
	  Assert.assertTrue(loginPg.isRegisterAccountTextExists());
	 
  }
  
  @Test(description="TC_05_navigate to Registration from login Page",priority=5)
  public void navigateToRegistrationPageTest() throws InterruptedException {
	  log.info("TC_05_navigate to Registration from login Page");
	  loginPg.clickNewCustomerContinueBtn();
	  regPg.waitForPageLoad(2000);
	  log.info("Assert the REgistration page Title");
	  Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
	  log.info("Click on browser back btn in registration page");
	  regPg.navigateBrowserBack();
  }
  
  
  @Test(description="TC_06_navigate to Forgot Password page from login Page",priority=6)
  public void navigateToForgotPasswordPageTest() throws InterruptedException {
	  log.info("TC_06_navigate to Forgot Password page from login Page");
	  loginPg.goToForgotPasswordPage();
	  forgotpwdPg.waitForPageLoad(2000);
	  log.info("Assert the ForgotPassword page Title");
	  Assert.assertEquals(forgotpwdPg.getTitle(),Constants.FORGOT_PWD_PAGE_TITLE);
	  log.info("Click on browser back btn in forgotpassword page");
	  forgotpwdPg.navigateBrowserBack();
  }
  
  @Test(description="TC_07_verify returning Customer header in login Page",priority=7)
  public void verifyReturningCustomerHeaderTextTest() throws InterruptedException {
	  log.info("TC_07_verify returning Customer header in login Page");
	  
	  Assert.assertTrue(loginPg.isReturningCustomerHeaderExists());
	 
  }
  
  @Test(description="TC_08_login to the Open cart Application",priority=9)
  public void happyPathLoginTest() throws InterruptedException {
	  log.info("TC_08_login to the Open cart Application");
	  loginPg.doLogin(rb.getString("username"), rb.getString("pwd"));
	  myaccountPg.waitForPageLoad(2000);
	  log.info("Assert the MyAccount page Title");
	  Assert.assertEquals( myaccountPg.getTitle(),Constants.MY_ACCOUNT_PAGE_TITLE);
	  
  } 
  
  @Test(description="TC_09_Empty credentials login to the Open cart Application",priority=8)
  public void emptyLoginTest() throws InterruptedException {
	  log.info("TC_09_Empty credentials login to Open cart Application");
	  loginPg.doLogin("", "");
	 
	  log.info("Verify the empty creds error message in login page ");
	  Assert.assertTrue(loginPg.getEmptyCredsErrMsgExists().contains(Constants.LOGIN_NOMATCH_ERR_MSG));
	  
  } 
  
  
  @AfterClass
  public void doLogout() throws InterruptedException {
	  log.info("click on logout link");
	  myaccountPg.clickLogoutLink();
	  logoutPg.waitForPageLoad(2000);
	  Assert.assertEquals(logoutPg.getTitle(), Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	  log.info("Click on Continue button in Logout page");
	  logoutPg.clickContinueBtn();
	  homePg.waitForPageLoad(2000);
	  Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
  }
  
}
