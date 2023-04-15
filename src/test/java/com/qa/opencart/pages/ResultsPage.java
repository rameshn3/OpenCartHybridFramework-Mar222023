package com.qa.opencart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class ResultsPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(ResultsPage.class.getName());
	private WebDriver driver;
	public ResultsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[2]/a[text()='Search']")
	private WebElement searchBreadCrumb;
	
	@FindBy(css="div[id='content'] h1")
	private WebElement searchHeader;
	
	@FindBy(css="div[class*='product-layout product-grid']")
	private List<WebElement> searchProductList;
	
	
	public String getSearchResultsPageTitle(String productName) {
		return waitForTitleContains(productName);
	}

	public int getSearchProductListSize() {
		return searchProductList.size();
	}

	public ProductDetailsPage selectProduct(String productName) {
		log.debug("Product anme is:"+productName);
		driver.findElement(By.linkText(productName)).click();
		return new ProductDetailsPage(driver);
	}
	
	public boolean issearchBreadCrumbExists() {
		return isDisplayed(searchBreadCrumb);
	}
	
}
