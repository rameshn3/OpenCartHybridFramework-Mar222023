package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class ProductDetailsPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(ProductDetailsPage.class.getName());
	private WebDriver driver;
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#content > div:nth-child(1) > div.col-sm-4 > h1")
	private WebElement productHeader;
	
	@FindBy(css="a.thumbnail")
	private List<WebElement> productImageList; 
	
	@FindBy(xpath="(//*[@id='content']//ul[@class='list-unstyled'])[position()=1]/li")
	private List<WebElement> productMetaDataList; 
	
	@FindBy(xpath="(//*[@id='content']//ul[@class='list-unstyled'])[position()=2]/li")
	private List<WebElement> productPriceList; 
	
	@FindBy(id="button-cart")
	private WebElement addToCartBtn;
	
	public String getProductName() throws InterruptedException {
		return getText(productHeader);
	}
	
	public int getProductImageCount() {
		return productImageList.size();
	}
	
	private Map<String,String>productMap;
	
	public void getProductMetaData() {
		log.info("Product metadata count --->"+productMetaDataList.size());
		for(WebElement pmd:productMetaDataList) {
			String metaText=pmd.getText(); //Brand: Apple
			//split the metaText
			String[] metaData=metaText.split(":"); //["Brand","Apple"]
			String metaKey=metaData[0].trim();
			String metaValue=metaData[1].trim();
			//add key and value into the map using put()
			productMap.put(metaKey, metaValue);
		}
	}
	
	public void getProductPriceData() {
		log.info("product price count --->"+productPriceList.size());
		String price=productPriceList.get(0).getText().trim();
		String exTaxprice=productPriceList.get(1).getText().trim();
		productMap.put("actualprice", price);
		productMap.put("actualtaxprice", exTaxprice);
	}
	
	public Map<String,String> getProductInformation(){
		productMap=new HashMap<String,String>();
		getProductMetaData();
		getProductPriceData();
		return productMap;
	}
}
