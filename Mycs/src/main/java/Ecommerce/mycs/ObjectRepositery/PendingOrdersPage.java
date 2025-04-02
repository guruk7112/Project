package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingOrdersPage {
WebDriver driver;
public PendingOrdersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@type='text']")
private WebElement orderSearchTf;

@FindBy(xpath="//tr[@class='odd']//td[contains(text(),'Anuj singh')]")
private WebElement verifyUser;

public WebElement getVerifyUser() {
	return verifyUser;
}
public WebElement getOrderSearchTf() {
	return orderSearchTf;
}
}
