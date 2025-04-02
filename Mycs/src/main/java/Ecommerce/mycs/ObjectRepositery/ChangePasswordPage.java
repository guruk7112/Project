package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {

	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='manage-products.php']")
	private WebElement manageProduct;

	@FindBy(xpath = "//a[@href='category.php']")
	private WebElement createCategory;

	@FindBy(xpath = "//a[@href='subcategory.php']")
	private WebElement subcategoryLink;

	@FindBy(xpath = "//a[contains(text(),'Insert Product ')]")
	private WebElement insertProduct;

	@FindBy(className = "collapsed")
	private WebElement orderManagement;

	@FindBy(xpath = "//a[@href='todays-orders.php']")
	private WebElement todaysOrder;
	
	@FindBy(xpath="//a[@href='logout.php']/i")
	private WebElement adminLogout;

	public WebElement getAdminLogout() {
		return adminLogout;
	}

	public WebElement getTodaysOrder() {
		return todaysOrder;
	}

	public WebElement getOrderManagement() {
		return orderManagement;
	}

	public WebElement getInsertProduct() {
		return insertProduct;
	}

	public WebElement getSubcategoryLink() {
		return subcategoryLink;
	}

	public WebElement getCreateCategory() {
		return createCategory;
	}

	public WebElement getManageProduct() {
		return manageProduct;
	}

}
