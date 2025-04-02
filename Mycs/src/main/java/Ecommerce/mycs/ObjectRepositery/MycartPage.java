package Ecommerce.mycs.ObjectRepositery;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.mycs.generic.baseclass.BaseClass;

public class MycartPage extends BaseClass {

	WebDriver driver;

	public MycartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[contains(text(),' Books')]")
	private WebElement booksCategory;

	@FindBy(xpath = "//div[contains(@class,'arrow plus gradient')]")
	private WebElement plusArrowQuantity;

	@FindBy(name = "submit")
	private WebElement updateShoppingCartButton;

	/* billing adress and shipping adress */

	@FindBy(name = "billingaddress")
	private WebElement billingAdress;

	@FindBy(id = "bilingstate")
	private WebElement billingState;

	@FindBy(id = "billingcity")
	private WebElement billingCity;

	@FindBy(id = "billingpincode")
	private WebElement billingPincode;

	@FindBy(xpath = "//button[@type='submit' and @name='update']")
	private WebElement billingUpdateButton;

	@FindBy(name = "shippingaddress")
	private WebElement shippingAdress;

	@FindBy(id = "shippingstate")
	private WebElement shippingState;

	@FindBy(id = "shippingcity")
	private WebElement shippingCity;

	@FindBy(id = "shippingpincode")
	private WebElement shippingPincode;

	@FindBy(name = "shipupdate")
	private WebElement shippingUpdateButton;
	
	@FindBy(name="ordersubmit")
	private WebElement CheckoutButton;
	
	@FindBy(name="remove_code[]")
	private WebElement romoveCheckBox;
	
	@FindBy(xpath="//h3[@class='section-title']")
	private WebElement empty;
	
	public WebElement getEmpty() {
		return empty;
	}
	
	public WebElement getRemoveCheckBoc() {
		return romoveCheckBox;
	}

	public WebElement getCheckoutButton() {
		wLib.getScrollByamount(0,300, driver);
		return CheckoutButton;
	}

	public WebElement getUpdateShoppingCartButton() throws InterruptedException {
		wLib.getJsScrollAmount(driver, 200);
	 Thread.sleep(1000);
		return updateShoppingCartButton;
	}

	public WebElement getPlusArrowQuantity() {
		return plusArrowQuantity;
	}

	public WebElement getBooksCategory() {
		return booksCategory;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void increaseQuantity() throws Exception {
		int increase = (int) eLib.getDataFromXlsxNumberic("entire", 1, 0);
		for (int i = 0; i < increase; i++) {
			plusArrowQuantity.click();
		}
	}

	public WebElement getBillingAdress() {
		return billingAdress;
	}

	public WebElement getBillingState() {
		return billingState;
	}

	public WebElement getBillingCity() {
		return billingCity;
	}

	public WebElement getBillingPincode() {
		return billingPincode;
	}

	public WebElement getBillingUpdateButton() throws InterruptedException {
		wLib.getJsScrollAmount(driver,200);
		return billingUpdateButton;
	}

	public WebElement getShippingAdress() {
		return shippingAdress;
	}

	public WebElement getShippingState() {
		return shippingState;
	}

	public WebElement getShippingCity() {
		return shippingCity;
	}

	public WebElement getShippingPincode() {
		return shippingPincode;
	}

	public WebElement getShippingUpdateButton() {
		return shippingUpdateButton;
	}
/**
 * 
 * @param adres
 * @param state
 * @param city
 * @param pincode
 * @throws InterruptedException
 */
	public void billingAdress(String adres, String state , String city, String pincode) throws InterruptedException {
		billingAdress.clear();
		billingAdress.sendKeys(adres);
		billingState.clear();
		billingState.sendKeys(state);
		billingCity.clear();
		billingCity.sendKeys(city);
		billingPincode.clear();
		billingPincode.sendKeys(pincode);
		wLib.getJsScrollAmount(driver, 300);
		billingUpdateButton.click();
		
	}
	/**
	 * 
	 * @param adress
	 * @param state
	 * @param city
	 * @param pincode
	 * @throws InterruptedException
	 */
	public void shippingAdress(String adress,String state ,String city ,String pincode) throws InterruptedException {
		shippingAdress.clear();
		shippingAdress.sendKeys(adress);
		shippingState.clear();
		shippingState.sendKeys(state);
		shippingCity.clear();
		shippingCity.sendKeys(city);
		shippingPincode.clear();
		shippingPincode.sendKeys(pincode);
		wLib.getJsScrollAmount(driver, 300);
		shippingUpdateButton.click();
	
	}
}

