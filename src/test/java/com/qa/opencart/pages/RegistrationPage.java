package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class RegistrationPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(RegistrationPage.class.getName());
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="h1")
	private WebElement registerAccntHeader;
	
	@FindBy(css="div[id='content'] p")
	private WebElement registerAccntStaticTxt;
	
	@FindBy(css="div[id='content'] p a")
	private WebElement registerAccntLoginPageLink;
	
	@FindBy(css="fieldset[id='account'] legend")
	private WebElement personalDetailsLegendTxt;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameEditbox;
	
	@FindBy(name="lastname")
	private WebElement lastNameEditbox;
	
	@FindBy(id="input-email")
	private WebElement emailEditbox;
	
	@FindBy(css="#input-telephone")
	private WebElement telephoneEditbox;
	
	@FindBy(css="#input-fax")
	private WebElement faxEditbox;
	
	@FindBy(css="fieldset[id='address'] legend")
	private WebElement addressLegendTxt;
	
	@FindBy(css="#input-company")
	private WebElement companyEditbox;
	
	@FindBy(css="#input-address-1")
	private WebElement address1Editbox;
	
	@FindBy(css="#input-address-2")
	private WebElement address2Editbox;
	
	@FindBy(css="#input-city")
	private WebElement cityEditbox;
	
	@FindBy(css="#input-postcode")
	private WebElement postCodeEditbox;
	
	@FindBy(css="#input-country")
	private WebElement countryDropdown;
	@FindBy(css="#input-zone")
	private WebElement stateDropdown;
	
	@FindBy(css="fieldset:nth-child(1) legend:nth-child(1)")
	private WebElement passwordLegendTxt;
	
	@FindBy(css="#input-password")
	private WebElement passwordEditbox;
	
	@FindBy(css="#input-confirm")
	private WebElement confirmPassowrdEditbox;
	
	@FindBy(css="input[value='1'][name='newsletter']")
	private WebElement subscribeYesRadioBtn;
	
	@FindBy(css="input[value='0']")
	private WebElement subscribeNoRadioBtn;
	
	@FindBy(css="input[value='1'][name='agree']")
	private WebElement privacypolicyCheckbox;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(css="body > div:nth-child(4) > div.alert.alert-danger")
	private WebElement agreeErrMsg;
	
	@FindBy(css="body div[class='container'] ul[class='breadcrumb'] li:nth-child(3) a:nth-child(1)")
	private WebElement registerBreadCrumb;
	
	@FindBy(css="div#content>h1")
	private WebElement accntCreatedHeader;
	
	@FindBy(css="div#content>p")
	private WebElement accntCreatedSuccMsg;
	
	@FindBy(css="a.btn.btn-primary")
	private WebElement accntCreatedContinueBtn;
	
	@FindBy(css="body > div:nth-child(4) > ul > li:nth-child(3) > a")
	private WebElement accntCreatedBreadCrumbSuccessLink;
	
	@FindBy(xpath = "//a[contains(.,'contact us')]")
	private WebElement contactUsLink;
	
	@FindBy(css=".fa.fa-home")
	private WebElement breadCrumbHomeIcon;
	
	public boolean isregisterBreadCrumbPresent() {
		return isDisplayed(registerBreadCrumb);
	}
	
	public boolean isAccntCreatedBreadCrumbSuccessLinkPresent() {
		return accntCreatedBreadCrumbSuccessLink.isDisplayed();
	}
	
	public void clickOnAccntCreatedcontactUsLink() throws InterruptedException {
		log.info("clicking on ContactUs link in CreatedAccount Page");
		click(contactUsLink);
	}
	
	public void clickOnBreadCrumbHomeIcon() throws InterruptedException {
		log.info("clicking on breadCrumbHomeIcon");
		click(breadCrumbHomeIcon);
	}
	
	public void clickOnAccntCreatedContinueBtn() throws InterruptedException {
		log.info("clicking on accntCreatedContinueBtn");
		click(accntCreatedContinueBtn);
	}
	
	public String getAccntCreatedSuccMsg() throws InterruptedException {
		log.info("fetching accntCreated success message");
		return getText(accntCreatedSuccMsg);
	}
	public String getAccntCreatedHeader() throws InterruptedException {
		log.info("fetching accntCreatedHeader");
		return getText(accntCreatedHeader);
	}
	
	public String getFirstNameEditbox() {
		return firstNameEditbox.getAttribute("value");
	}

	public void setFirstName(String firstName) throws InterruptedException {
		log.info("Enter the first name value:");
		sendData(firstNameEditbox,firstName);
	}

	public String getLastNameEditbox() {
		return lastNameEditbox.getAttribute("value");
	}

	public void setLastName(String lastName) throws InterruptedException {
		log.info("Enter the last name value:");
		sendData(lastNameEditbox,lastName);
	}

	public String getEmailEditbox() {
		return emailEditbox.getAttribute("value");
	}

	public void setEmail(String email) throws InterruptedException {
		log.info("Enter the email value:");
		sendData(emailEditbox, email);
	}

	public String getTelephoneEditbox() {
		return telephoneEditbox.getAttribute("value");
	}

	public void setTelephone(String telephone) throws InterruptedException {
		log.info("Enter the telephone value:");
		sendData(telephoneEditbox,telephone);
	}

	public String getFaxEditbox() {
		return faxEditbox.getAttribute("value");
	}

	public void setFax(String fax) throws InterruptedException {
		log.info("Enter the fax value:");
		sendData(faxEditbox, fax);
	}

	public String getCompanyEditbox() {
		return companyEditbox.getAttribute("value");
	}

	public void setCompany(String company) throws InterruptedException {
		log.info("Enter the company value:");
		sendData(companyEditbox, company);
	}

	public String getAddress1Editbox() {
		return address1Editbox.getAttribute("value");
	}

	public void setAddress1Editbox(String address1) throws InterruptedException {
		log.info("Enter the Address1 value:");
		sendData(address1Editbox,address1);
	}

	public String getAddress2Editbox() {
		return address2Editbox.getAttribute("value");
	}

	public void setAddress2Editbox(String address2) throws InterruptedException {
		log.info("Enter the address2 value:");
		sendData(address2Editbox,address2);
	}

	public String getCityEditbox() {
		return cityEditbox.getAttribute("value");
	}

	public void setCityEditbox(String city) throws InterruptedException {
		log.info("Enter the city value:");
		sendData(cityEditbox, city);
	}

	public String getPostCodeEditbox() {
		return postCodeEditbox.getAttribute("value");
	}

	public void setPostCodeEditbox(String postCode) throws InterruptedException {
		log.info("Enter the postCode value:");
		sendData(postCodeEditbox, postCode);
	}

	public String getPasswordEditbox() {
		return passwordEditbox.getAttribute("value");
	}

	public void setPasswordEditbox(String password) throws InterruptedException {
		log.info("Enter the password value:");
		sendData(passwordEditbox,password);
	}

	public String getConfirmPassowrdEditbox() {
		return confirmPassowrdEditbox.getAttribute("value");
	}

	public void setConfirmPassowrdEditbox(String confirmPassowrd) throws InterruptedException {
		log.info("Enter the email value:");
		sendData(confirmPassowrdEditbox,confirmPassowrd);
	}
	
	public void selectCountry(String optionTxt)
	{
		log.info("Select an option from country dropdownby label");
		
		try {
			selectOptionByVisibleText(countryDropdown, optionTxt);
			/*
			 * log.info("switching to Alert"); waitForAlertPresentAndSwitch();
			 * log.info("accept the alert"); acceptAlert();
			 */
			waitForPageLoad(1000);
		} catch (Exception e) {
			//log.info("org.openqa.selenium.TimeoutException: Expected condition failed: waiting for alert to be present");
			e.printStackTrace();
		}
		
		}
	
	
	public void selectState(String optionTxt)
	{
		log.info("Select an option from State dropdownby label");
		
		selectOptionByVisibleText(stateDropdown, optionTxt);
		
		
		}
	
	public void selectSubscribe(String subScribe) throws InterruptedException {
		log.info("select the NewsLetter Subscribe value");
		if(subScribe.equalsIgnoreCase("Yes")) {
			log.info("Select Yes radio button");
			click(subscribeYesRadioBtn);
		}else {
			log.info("Select No radio button");
			click(subscribeNoRadioBtn);
		}
	}
	
	public void checkAgreeCheckbox() throws InterruptedException {
		log.info("check Agree checkbox");
		check(privacypolicyCheckbox);
	}
	
	public void clickContinueBtn() throws InterruptedException {
		log.info("click on Continue button");
		click(continueBtn);
	}
	
	public String getRegisterAccount() throws InterruptedException {
		return getText(registerAccntHeader);
	}
	public void clickLoginPageLink() throws InterruptedException {
		log.info("click on LoginPageLink");
		click(registerAccntLoginPageLink);
	}
	
	public void setPersonalDetails(String fname,String lname,String email,String tele,String fax) throws InterruptedException {
		setFirstName(fname);
		setLastName(lname);
		setEmail(email);
		setTelephone(tele);
		setFax(fax);
	}
	
	public void setAddressDetails(String company,String addr1,String addr2,String city,String postCode,String Country,String state) throws InterruptedException {
		setCompany(company);
		setAddress1Editbox(addr1);
		setAddress2Editbox(addr2);
		setCityEditbox(city);
		setPostCodeEditbox(postCode);
		selectCountry(Country);
		selectState(state);
		}
	
	public void setPasswordDetails(String pwd,String confirmPwd) throws InterruptedException
	{
		setPasswordEditbox(pwd);
		setConfirmPassowrdEditbox(confirmPwd);
	}
	
	public String getAgreeWarningMessage() throws InterruptedException {
		return getText(agreeErrMsg);
	}
}
