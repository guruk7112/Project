package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.mycs.generic.baseclass.admin.BaseClass;

public class AdminLoginPage extends BaseClass {

	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement adminUsername;

	public WebElement getAdminUsername() {
		return adminUsername;
	}

	@FindBy(name = "password")
	private WebElement adminPassword;

	public WebElement getadminPassword() {
		return adminPassword;
	}

	@FindBy(name = "submit")
	private WebElement adminSubmitButton;

	@FindBy(className = "caret")
	private WebElement adminLogoutCarot;

	@FindBy(xpath = "//a[@href='logout.php']/parent::li//a[contains(text(),'Logout')]")
	private WebElement adminLogout;

	@FindAll({ @FindBy(xpath = "//span[contains(@style,'margin-right: 30px;')]"),@FindBy(xpath="//span[contains(text(),'Back to Portal')]") })
	private WebElement backToPortal;

	public WebElement getBackToPortal() throws InterruptedException {
		wLib.getJsScrollAmount(driver, 200);
		return backToPortal;
	}

	public WebElement getAdminLogoutCarot() {
		return adminLogoutCarot;
	}

	public WebElement getAdminLogout() {
		return adminLogout;
	}

	public WebElement getAdminSubmitButton() {
		return adminSubmitButton;
	}

	public void adminLogin(String un, String pwd) {
		adminUsername.sendKeys(un);
		adminPassword.sendKeys(pwd);
		adminSubmitButton.click();
	}
}
