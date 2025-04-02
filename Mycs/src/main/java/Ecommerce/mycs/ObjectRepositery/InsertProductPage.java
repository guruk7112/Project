package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.mycs.generic.baseclass.admin.BaseClass;

public class InsertProductPage extends BaseClass{
WebDriver driver;
public InsertProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="subcategory")
private WebElement insertSub;

@FindBy(name="productName")
private WebElement productName;

public WebElement getProductName() {
	return productName;
}

public WebElement getProductCompany() {
	return productCompany;
}

public WebElement getProductPricebd() {
	return productPricebd;
}

public WebElement getProductPrice() {
	return productPrice;
}

public WebElement getShippingCharge() {
	return shippingCharge;
}

public WebElement getpAvailabilityDD() {
	return pAvailabilityDD;
}

public WebElement getImage1() {
	return image1;
}

public WebElement getInsertButton() throws InterruptedException {
	wLib.getJsScrollAmount(driver, 600);
	return insertButton;
}
@FindBy(name="productCompany")
private WebElement productCompany;

@FindBy(name="productpricebd")
private WebElement productPricebd;

@FindBy(name="productprice")
private WebElement productPrice;

@FindBy(name="productShippingcharge")
private WebElement shippingCharge;

@FindBy(id="productAvailability")
private WebElement pAvailabilityDD;

@FindBy(xpath="//input[@type='file' and @name='productimage1']")
private WebElement image1;

@FindBy(name="submit")
private WebElement insertButton;

@FindBy(xpath="//select[@id='subcategory']")
private WebElement sub1;

public WebElement getSub1() {
	return sub1;
}

public WebElement getInsertSub() {
	return insertSub;
	}
/**
 * 
 * @param pname
 * @param pcompany
 * @param beforDiscount
 * @param price
 * @param shippingcharge
 */
public void insertProduct(String pname , String pcompany, String beforDiscount,String price,String shippingcharge) {
	productName.sendKeys(pname);
	productCompany.sendKeys(pcompany); 
	productPricebd.sendKeys(beforDiscount);
	wLib.getScrollByamount(0, 400, driver);
	productPrice.sendKeys(price);
	shippingCharge.sendKeys(shippingcharge);
	wLib.getScrollByamount(0, 400, driver);
	wLib.getSelectByIndex(pAvailabilityDD, 1);

	
	insertButton.click();
	
	
	
}
}
