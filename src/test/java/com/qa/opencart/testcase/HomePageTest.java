package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePageTest extends TestBase{
	private Logger log=LogManager.getLogger(HomePageTest.class.getName());
  
  @BeforeMethod
  public void beforeMethod() {
	  homePg.waitForPageLoad(2000);
  }

  @AfterMethod
  public void afterMethod() {
	  homePg.waitForPageLoad(2000);
	  Assert.assertEquals(Constants.HOME_PAGE_TITLE,homePg.getTitle());
  }

  @BeforeClass
  public void beforeClass() {
	  log.info("Initilizing the page class objects");
	  homePg=new HomePage(driver);
	  regPg=new RegistrationPage(driver);
	  loginPg=new LoginPage(driver);
	  
  }

  @Test(description="TC_01_Verifying the opencart Logo",priority=1)
  public void verifyOpenCartLogoTest() {
	  log.info("verify the logo text");
	  Assert.assertTrue(homePg.isOpenCartLogoExists());
  }

  @Test(description="TC_02_Verifying the opencart Page Title",priority=2)
  public void verifyOpenCartPageTitleTest() {
	  log.info("verify the opencart page title");
	  Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE);
  }
  
  @Test(description="TC_03_navigate to registration Page",priority=3)
  public void navigateToRegistrationPageTest() throws InterruptedException {
	  log.info("TC_03_navigate to registration Page");
	  homePg.goToRegisterPage();
	  regPg.waitForPageLoad(2000);
	  log.info("Assert the Registration page Title");
	  Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
	  log.info("Click on Home icon in registration page");
	  regPg.clickOnBreadCrumbHomeIcon();
  }
  
  @Test(description="TC_04_navigate to Login Page",priority=4)
  public void navigateToLoginPageTest() throws InterruptedException {
	  log.info("TC_04_navigate to login Page");
	  homePg.goToLoginPage();
	  loginPg.waitForPageLoad(2000);
	  log.info("Assert the Login page Title");
	  Assert.assertEquals(loginPg.getTitle(),Constants.LOGIN_PAGE_TITLE);
	  log.info("Click on Home icon in registration page");
	  loginPg.clickLoginHomeIcon();;
  }
  
}
