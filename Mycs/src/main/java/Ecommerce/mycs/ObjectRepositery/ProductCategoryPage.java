package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.mycs.generic.baseclass.BaseClass;

public class ProductCategoryPage extends BaseClass {

	WebDriver driver;

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='button']/parent::a[@href='category.php?page=product&action=add&id=16']")
	private WebElement sellerAddToCart;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-primary']")
	private WebElement addTOCart;

	@FindBy(xpath = "//i[contains(@class,'icon fa fa-heart')]/parent::a[@href='category.php?pid=34&&action=wishlist']")
	private WebElement wishList2;
	
	@FindBy(xpath="//a[text()='Bucket']")
	private WebElement productVerify;
	
	@FindBy(xpath="//div[@class='total-price-basket']")
	private WebElement cartBox;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-upper btn-primary btn-block m-t-20')]")
	private WebElement addToCartBoxButton;
	
	@FindBy(xpath="//a[@href='product-details.php?pid=33'][text()='SliverAnklet']/parent::h4")
	private WebElement verifyProductName;

	public WebElement getVerifyProductName() {
		return verifyProductName;
	}

	public WebElement getAddToCartBoxButton() {
		return addToCartBoxButton;
	}

	public WebElement getCartBox() {
		return cartBox;
	}

	public WebElement getProductVerify() throws InterruptedException {
		wLib.getJsScrollAmount(driver, 400);
		return productVerify;
	}

	public WebElement getWishList2() {
		wLib.getScrollByamount(0, 500, driver);
		return wishList2;
	}

	public WebElement getAddToCart() throws InterruptedException {
		wLib.getJsScrollAmount(driver, 500);
		return addTOCart;
	}

	public WebElement getSellerAddToCart() throws InterruptedException {
		wLib.getJsScrollAmount(driver, 500);
		return sellerAddToCart;
	}

}
