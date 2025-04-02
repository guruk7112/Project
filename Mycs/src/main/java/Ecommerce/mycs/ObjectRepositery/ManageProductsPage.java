package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {
WebDriver driver;
public ManageProductsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@type='text']")
private WebElement manageTf;


@FindAll( { @FindBy(xpath="//a[@href='edit-products.php?id=16']"),@FindBy(className="icon-edit") })
private WebElement edit3;

public WebElement getEdit3() {
	return edit3;
}
@FindBy(className="icon-remove-sign")
private WebElement deleteProduct;

public WebElement getDeleteProduct() {
	return deleteProduct;
}

public WebElement getManageTf() {
	return manageTf;
}
}
